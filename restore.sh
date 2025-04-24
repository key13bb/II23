#!/bin/bash

# ==============================================================================
# Script para RESTAURAR las carpetas .idea y .vscode DESDE una copia de seguridad
# ==============================================================================
#
# Este script recorre las carpetas de proyectos estructuradas como:
#   ./<año>.<cuatrimestre>/<siglas_asignatura>/
# y busca las carpetas '.idea' y '.vscode' correspondientes en un directorio
# de backup. Si las encuentra, REEMPLAZA las carpetas existentes en el proyecto
# con las de la copia de seguridad.
#
# ¡ADVERTENCIA! Esto reemplazará cualquier configuración .idea o .vscode
# existente en tus carpetas de proyecto con la versión del backup. Asegúrate
# de que el backup contiene lo que quieres restaurar.
#
# USO:
# 1. Guarda este script, por ejemplo, como 'restore_ide_config.sh'.
# 2. Dale permisos de ejecución: chmod +x restore_ide_config.sh
# 3. Ejecútalo desde el directorio que contiene las carpetas <año>.<cuatrimestre>
#    (igual que el script de backup):
#    ./restore_ide_config.sh
#

# --- Configuración ---
# Directorio DESDE DONDE se restaurará la copia de seguridad.
# Debe coincidir con el BACKUP_DIR usado en el script de backup.
BACKUP_DIR="../Backup"
# --- Fin Configuración ---

# Funciones para logs
log() { echo "[INFO] $1"; }
warn() { echo "[WARN] $1"; }
error() { echo "[ERROR] $1" >&2; }

# 1. Verificar que el directorio de backup existe
if [ ! -d "$BACKUP_DIR" ]; then
    error "El directorio de backup especificado NO existe: '$BACKUP_DIR'."
    error "Asegúrate de que la variable BACKUP_DIR es correcta y la copia de seguridad existe."
    exit 1
else
    # Resolvemos la ruta por si es relativa para mostrarla
    resolved_backup_dir=$(realpath -m "$BACKUP_DIR" 2>/dev/null || echo "$BACKUP_DIR")
    log "Usando directorio de backup: $resolved_backup_dir"
fi

# 2. Iterar sobre las carpetas de cuatrimestre/año en el directorio actual
log "Iniciando búsqueda de configuraciones de IDE en el backup para restaurar..."
found_in_backup=0
restored_configs=0
shopt -s extglob # Activar globbing extendido para la exclusión

# Obtenemos el nombre base del directorio de backup para excluirlo
backup_basename=$(basename "$resolved_backup_dir")

# Iteramos excluyendo el directorio de backup si está en el mismo nivel
for cuat in !(~$backup_basename); do
    # Asegurarse de que es un directorio
    if [ -d "$cuat" ]; then
        log "Procesando directorio del proyecto: $cuat"
        # 3. Iterar sobre las carpetas de asignatura
        for subj in "$cuat"/*; do
            # Asegurarse de que 'subj' es un directorio del proyecto
            if [ -d "$subj" ]; then
                log "  -> Revisando asignatura en proyecto: $subj"
                processed_subj=0 # Flag para saber si restauramos algo

                # Ruta de la asignatura EN EL BACKUP
                subj_backup_path="$BACKUP_DIR/$subj" # ej: ../Backup/2024.1/PROG1

                # --- Restaurar .idea (JetBrains) ---
                # Primero, VERIFICAR si existe en el backup
                if [ -d "$subj_backup_path/.idea" ]; then
                    log "      -> Encontrado en backup: $subj_backup_path/.idea"
                    found_in_backup=$((found_in_backup + 1))
                    processed_subj=1

                    # Segundo, ELIMINAR .idea actual en el proyecto (si existe)
                    if [ -e "$subj/.idea" ]; then # Usar -e por si es enlace simbólico, etc.
                       log "      -> Eliminando $subj/.idea existente en el proyecto..."
                       rm -rf "$subj/.idea"
                       if [[ $? -ne 0 ]]; then
                            error "      -> ¡Fallo al eliminar $subj/.idea existente! No se puede restaurar."
                            # Podríamos decidir continuar con .vscode o saltar esta asignatura
                            continue # Saltamos al siguiente 'subj' por seguridad
                       fi
                    fi

                    # Tercero, COPIAR .idea desde el backup al proyecto
                    log "      -> Restaurando $subj/.idea desde el backup..."
                    # cp -a preserva atributos. Copia la carpeta .idea DENTRO de $subj/
                    cp -a "$subj_backup_path/.idea" "$subj/"
                    if [[ $? -eq 0 ]]; then
                        log "      -> Restauración de .idea completada para $subj."
                        restored_configs=$((restored_configs + 1))
                    else
                        error "      -> ¡Fallo al copiar desde '$subj_backup_path/.idea' a '$subj/'!"
                    fi
                fi # Fin if -d .idea en backup

                # --- Restaurar .vscode (VS Code) ---
                # VERIFICAR si existe en el backup
                if [ -d "$subj_backup_path/.vscode" ]; then
                    log "      -> Encontrado en backup: $subj_backup_path/.vscode"
                    found_in_backup=$((found_in_backup + 1))
                    processed_subj=1

                    # ELIMINAR .vscode actual en el proyecto (si existe)
                    if [ -e "$subj/.vscode" ]; then
                       log "      -> Eliminando $subj/.vscode existente en el proyecto..."
                       rm -rf "$subj/.vscode"
                        if [[ $? -ne 0 ]]; then
                            error "      -> ¡Fallo al eliminar $subj/.vscode existente! No se puede restaurar."
                            continue # Saltamos al siguiente 'subj'
                       fi
                    fi

                    # COPIAR .vscode desde el backup al proyecto
                    log "      -> Restaurando $subj/.vscode desde el backup..."
                    cp -a "$subj_backup_path/.vscode" "$subj/"
                    if [[ $? -eq 0 ]]; then
                        log "      -> Restauración de .vscode completada para $subj."
                        restored_configs=$((restored_configs + 1))
                    else
                        error "      -> ¡Fallo al copiar desde '$subj_backup_path/.vscode' a '$subj/'!"
                    fi
                fi # Fin if -d .vscode en backup

                 # Mensaje si no se encontró nada en el backup para esta asignatura
                if [[ $processed_subj -eq 0 ]]; then
                     log "      -> No se encontraron carpetas .idea ni .vscode en el backup para $subj"
                fi

            fi # Fin if subj es dir (en proyecto)
        done # Fin loop subj
    fi # Fin if cuat es dir (en proyecto)
done # Fin loop cuat

shopt -u extglob # Desactivar globbing extendido

log "--------------------------------------------------"
log "Resumen de la Restauración de Configuración IDE:"
log "  Carpetas de config. encontradas en el backup: $found_in_backup"
log "  Carpetas de config. restauradas con éxito:    $restored_configs"
if [[ $found_in_backup -ne $restored_configs ]]; then
    warn "Algunas carpetas encontradas en el backup no pudieron ser restauradas en el proyecto. Revisa los errores anteriores."
    exit 1 # Salir con error si algo falló
else
    log "Restauración completada con éxito desde '$BACKUP_DIR'."
fi

exit 0
