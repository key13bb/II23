#!/bin/bash

# ==============================================================================
# Script para montar worktrees de Git DENTRO de carpetas AÑO.CUATRIMESTRE
# ==============================================================================
#
# Este script busca ramas locales que sigan el patrón <año>.<cuatrimestre>/<siglas>
# (ej. 2024.1/PROG1) y crea un worktree para cada una directamente en la ruta
# que coincide con el nombre de la rama (ej. ./2024.1/PROG1/).
# Se asegura de crear el directorio base (ej. ./2024.1/) si no existe.
#

# --- Configuración ---
EXCLUDE_BRANCH="main"           # Rama principal a excluir (ajusta si usas 'master', 'MAIN', etc.)
# Patrón Regex OBLIGATORIO para identificar las ramas de asignaturas.
# DEBE tener la estructura BASE/ALGO, donde BASE es el directorio a crear.
# Formato: AÑO(2 digitos).CUATRIMESTRE(1 o 2)/SIGLAS(letras, numeros, _, -)
BRANCH_PATTERN='^[1234]\.[12]/[A-Za-z0-9_-]+$'
# Alternativa más permisiva para el cuatrimestre (1 a 4):
# BRANCH_PATTERN='^[0-9]{4}\.[1-4]/[A-Za-z0-9_-]+$'
# --- Fin Configuración ---

# Funciones para logs
log() { echo "[INFO] $1"; }
error() { echo "[ERROR] $1" >&2; }

# 1. Verificar si estamos en un repo Git
if ! git rev-parse --is-inside-work-tree > /dev/null 2>&1; then
  error "Debes ejecutar este script desde la raíz de un repositorio Git."
  exit 1
fi
log "Ejecutando en el repositorio Git: $(pwd)"

# 2. Procesar las ramas locales usando 'git branch --format'
log "Buscando ramas con el patrón '$BRANCH_PATTERN' (excluyendo '$EXCLUDE_BRANCH')..."

git branch --format='%(refname:short)' | while IFS= read -r branch_name; do
    # Saltar la rama principal
    if [[ "$branch_name" == "$EXCLUDE_BRANCH" ]]; then
        log "Saltando rama principal: '$branch_name'."
        continue
    fi

    # Verificar si la rama coincide con el patrón OBLIGATORIO
    if [[ ! "$branch_name" =~ $BRANCH_PATTERN ]]; then
        log "Saltando rama '$branch_name': No coincide con el patrón requerido '$BRANCH_PATTERN'."
        continue
    fi

    # Patrón coincide, proceder a crear el worktree
    log "Procesando rama: '$branch_name'..."

    # La ruta del worktree será idéntica al nombre de la rama
    worktree_path="$branch_name"
    absolute_worktree_path="$(pwd)/$worktree_path"

    # Extraer el directorio base (ej. "2024.1" de "2024.1/PROG1")
    base_dir="${branch_name%/*}" # Elimina la última parte después de la última '/'

    # 3. Crear el directorio base si no existe
    if [[ ! -d "$base_dir" ]]; then
        log "El directorio base '$base_dir' no existe. Creándolo..."
        mkdir -p "$base_dir"
        if [[ $? -ne 0 ]]; then
            error "No se pudo crear el directorio base '$base_dir'. Saltando rama '$branch_name'."
            continue # Saltar a la siguiente rama si no se puede crear el directorio
        else
            log "Directorio base '$base_dir' creado."
            # Nota: Este nuevo directorio base NO se añade automáticamente a .gitignore.
            # Decide si quieres añadir manualmente "2024.1/", "2024.2/", etc., a tu .gitignore
            # o si prefieres trackear otros archivos que puedan ir en ellos.
            # Git no trackeará el *contenido* de los worktrees añadidos aquí de todas formas.
        fi
    fi

    # 4. Comprobar si ya existe un worktree para esta rama
    existing_worktree_info=$(git worktree list --porcelain | grep -B 1 "branch refs/heads/$branch_name$" | head -n 1 | awk '{print $2}')
    if [[ -n "$existing_worktree_info" ]]; then
        if [[ "$existing_worktree_info" == "$absolute_worktree_path" ]]; then
            log "El worktree para '$branch_name' ya existe en la ubicación esperada '$worktree_path'."
        else
            log "El worktree para '$branch_name' ya existe en una ubicación diferente ('$existing_worktree_info'). Saltando creación."
        fi
        continue
    fi

    # 5. Comprobar si la ruta de destino ya existe (y no es un worktree registrado)
    if [[ -e "$worktree_path" ]]; then
        log "Saltando '$branch_name': La ruta '$worktree_path' ya existe pero no es un worktree registrado para esta rama."
        continue
    fi

    # 6. Crear el worktree
    log "Creando worktree para '$branch_name' en './$worktree_path/'..."
    # Git se encarga de crear el directorio final (ej. PROG1) dentro del base_dir
    git worktree add "$worktree_path" "$branch_name"
    if [[ $? -ne 0 ]]; then
        error "Fallo al crear worktree para '$branch_name'. Comprueba posibles conflictos o errores."
    else
        log "Worktree para '$branch_name' creado con éxito en './$worktree_path/'."
    fi

done <<< "$(git branch --format='%(refname:short)')"

log "Proceso de creación de worktrees completado."

# 7. Ejecutar script de restauración (si existe y es ejecutable)
# (Misma lógica que antes)
if [ -f "restore.sh" ]; then
    if [ -x "restore.sh" ]; then
        log "Ejecutando ./restore.sh ..."
        ./restore.sh
        if [[ $? -ne 0 ]]; then
             error "El script restore.sh finalizó con errores."
        else
             log "restore.sh completado."
        fi
    else
        log "Se encontró restore.sh pero no tiene permisos de ejecución. Ejecuta: chmod +x restore.sh"
    fi
else
    log "No se encontró el script restore.sh en el directorio actual."
fi

log "Script finalizado."
exit 0
