#!/bin/bash

# ==============================================================================
# Script para HACER COPIA DE SEGURIDAD de las carpetas .idea y .vscode
# ==============================================================================
#
# Este script recorre las carpetas de proyectos estructuradas como:
#   ./<año>.<cuatrimestre>/<siglas_asignatura>/
# y copia las carpetas '.idea' (JetBrains) y '.vscode' (VS Code) que encuentre
# a un directorio de backup, replicando la estructura.
#
# USO:
# 1. Guarda este script, por ejemplo, como 'backup_ide_config.sh'.
# 2. Dale permisos de ejecución: chmod +x backup_ide_config.sh
# 3. Ejecútalo desde el directorio que contiene las carpetas <año>.<cuatrimestre>
#    (por ejemplo, la raíz donde tienes 2024.1/, 2024.2/, etc.)
#    ./backup_ide_config.sh
#

# --- Configuración ---
# Directorio donde se guardará la copia de seguridad.
# Puede ser una ruta relativa (como "../Backup_IDE") o absoluta (/ruta/completa/backup).
BACKUP_DIR="../Backup"
# --- Fin Configuración ---

# Funciones para logs
log() { echo "[INFO] $1"; }
warn() { echo "[WARN] $1"; }
error() { echo "[ERROR] $1" >&2; }

# 1. Crear directorio de backup principal si no existe
# Resolvemos la ruta por si es relativa como "../Backup" para la comprobación
resolved_backup_dir=$(realpath -m "$BACKUP_DIR" 2>/dev/null || echo "$BACKUP_DIR") # -m para que no falle si no existe aún

if [ ! -d "$resolved_backup_dir" ]; then
    log "Creando directorio de backup principal: $resolved_backup_dir"
    # Usamos la ruta original en mkdir por si es relativa
    mkdir -p "$BACKUP_DIR"
    if [[ $? -ne 0 ]]; then
        error "No se pudo crear el directorio de backup '$BACKUP_DIR'. Abortando."
        exit 1
    fi
else
    log "Usando directorio de backup existente: $resolved_backup_dir"
fi

# 2. Iterar sobre las carpetas de cuatrimestre/año en el directorio actual
log "Iniciando búsqueda de carpetas de configuración de IDE para backup..."
found_configs=0
copied_configs=0
shopt -s extglob # Activar globbing extendido para la exclusión

# Obtenemos el nombre base del directorio de backup para excluirlo
backup_basename=$(basename "$resolved_backup_dir")

# Iteramos excluyendo el directorio de backup si está en el mismo nivel
for cuat in !(~$backup_basename); do
    # Asegurarse de que es un directorio
    if [ -d "$cuat" ]; then
        log "Procesando directorio: $cuat"
        # 3. Iterar sobre las carpetas de asignatura dentro de 'cuat'
        for subj in "$cuat"/*; do
            # Asegurarse de que 'subj' es un directorio
            if [ -d "$subj" ]; then
                log "  -> Revisando asignatura: $subj"
                processed_subj=0 # Flag para saber si procesamos .idea o .vscode

                # Ruta base de destino para esta asignatura en el backup
                # $subj ya contiene $cuat, ej: "2024.1/PROG1"
                subj_backup_path="$BACKUP_DIR/$subj"

                # --- Procesar .idea (JetBrains) ---
                if [ -d "$subj/.idea" ]; then
                    log "      -> Encontrado: $subj/.idea"
                    found_configs=$((found_configs + 1))
                    processed_subj=1

                    # Asegurar que la estructura de directorios exista en el backup (ej: ../Backup/2024.1/PROG1/)
                    mkdir -p "$subj_backup_path"
                    if [[ $? -ne 0 ]]; then
                         error "      -> No se pudo crear la estructura de directorios en '$subj_backup_path'. Saltando backup de .idea."
                         continue # Podríamos seguir con .vscode si esto falla? Mejor saltar la asignatura.
                    fi

                    # Eliminar backup anterior de .idea para esta asignatura (para una copia limpia)
                    if [ -e "$subj_backup_path/.idea" ]; then # -e por si es enlace simbólico, etc.
                       log "      -> Eliminando backup anterior de .idea en $subj_backup_path/"
                       rm -rf "$subj_backup_path/.idea"
                       if [[ $? -ne 0 ]]; then
                            warn "      -> No se pudo eliminar el backup anterior de .idea. La copia podría fallar o ser incompleta."
                       fi
                    fi

                    # Copiar la carpeta .idea al backup usando cp -a (preserva atributos)
                    log "      -> Copiando $subj/.idea a $subj_backup_path/"
                    # Copiamos la carpeta .idea DENTRO de subj_backup_path
                    cp -a "$subj/.idea" "$subj_backup_path/"
                    if [[ $? -eq 0 ]]; then
                        log "      -> Copia de .idea completada."
                        copied_configs=$((copied_configs + 1))
                    else
                        error "      -> Fallo al copiar $subj/.idea a $subj_backup_path/."
                    fi
                fi # Fin if -d .idea

                # --- Procesar .vscode (VS Code) ---
                if [ -d "$subj/.vscode" ]; then
                    log "      -> Encontrado: $subj/.vscode"
                    found_configs=$((found_configs + 1))
                    processed_subj=1

                    # Asegurar que la estructura de directorios exista en el backup
                    mkdir -p "$subj_backup_path"
                     if [[ $? -ne 0 ]]; then
                         error "      -> No se pudo crear la estructura de directorios en '$subj_backup_path'. Saltando backup de .vscode."
                         continue
                    fi

                    # Eliminar backup anterior de .vscode
                    if [ -e "$subj_backup_path/.vscode" ]; then
                       log "      -> Eliminando backup anterior de .vscode en $subj_backup_path/"
                       rm -rf "$subj_backup_path/.vscode"
                       if [[ $? -ne 0 ]]; then
                            warn "      -> No se pudo eliminar el backup anterior de .vscode. La copia podría fallar o ser incompleta."
                       fi
                    fi

                    # Copiar la carpeta .vscode al backup
                    log "      -> Copiando $subj/.vscode a $subj_backup_path/"
                    cp -a "$subj/.vscode" "$subj_backup_path/"
                     if [[ $? -eq 0 ]]; then
                        log "      -> Copia de .vscode completada."
                        copied_configs=$((copied_configs + 1))
                    else
                        error "      -> Fallo al copiar $subj/.vscode a $subj_backup_path/."
                    fi
                fi # Fin if -d .vscode

                # Mensaje si no se encontró nada en la asignatura
                if [[ $processed_subj -eq 0 ]]; then
                     log "      -> No se encontraron carpetas .idea ni .vscode en $subj"
                fi

            fi # Fin if subj es directorio
        done # Fin loop subj
    fi # Fin if cuat es directorio
done # Fin loop cuat

shopt -u extglob # Desactivar globbing extendido

log "--------------------------------------------------"
log "Resumen del Backup de Configuración IDE:"
log "  Carpetas de configuración (.idea/.vscode) encontradas: $found_configs"
log "  Carpetas de configuración copiadas con éxito:      $copied_configs"
if [[ $found_configs -ne $copied_configs ]]; then
    warn "Algunas carpetas de configuración no pudieron ser copiadas. Revisa los errores anteriores."
    exit 1 # Salir con error si algo falló
else
    log "Copia de seguridad completada con éxito en '$BACKUP_DIR'."
fi

exit 0
