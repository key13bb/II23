#!/bin/bash

# ==============================================================================
# Script para eliminar TODOS los worktrees de Git EXCEPTO el principal
# ==============================================================================
#
# Este script lista todos los worktrees registrados, identifica el principal
# (la raíz del repositorio) y elimina todos los demás.
#
# ¡ADVERTENCIA! Usa 'git worktree remove --force', lo que significa que
# eliminará los worktrees incluso si contienen cambios sin confirmar o
# archivos sin seguimiento. Si quieres evitar esto, elimina '--force'
# de la línea del comando 'git worktree remove'.
#
# USO:
# 1. Guarda este script, por ejemplo, como 'desmontar_worktrees.sh'.
# 2. Dale permisos de ejecución: chmod +x desmontar_worktrees.sh
# 3. Ejecútalo desde cualquier lugar dentro de tu repositorio Git: ./desmontar_worktrees.sh
#

# Funciones para logs
log() { echo "[INFO] $1"; }
error() { echo "[ERROR] $1" >&2; }
warn() { echo "[WARN] $1"; }

# 1. Verificar si estamos en un repositorio Git
# (No necesitamos estar en la raíz, git puede determinarla)
if ! git rev-parse --is-inside-work-tree > /dev/null 2>&1; then
  error "Debes ejecutar este script desde dentro de un repositorio Git."
  exit 1
fi

# 2. Obtener la ruta absoluta del worktree principal (raíz del repo)
main_worktree_path=$(git rev-parse --show-toplevel)
if [[ $? -ne 0 || -z "$main_worktree_path" ]]; then
    error "No se pudo determinar la ruta del repositorio principal."
    exit 1
fi
log "Worktree principal (se conservará): $main_worktree_path"

# 3. Listar y procesar worktrees
log "Buscando worktrees adicionales para eliminar..."
processed_count=0
removed_count=0
declare -a errors # Array para guardar mensajes de error

# Usamos 'git worktree list --porcelain' para un parseo más fiable
# Leemos línea por línea
git worktree list --porcelain | while IFS= read -r line || [[ -n "$line" ]]; do # || [[ -n "$line" ]] para capturar la última línea si no tiene \n
    # Buscar la línea que define la ruta del worktree
    if [[ "$line" == worktree* ]]; then
        # Extraer la ruta (todo lo que sigue a "worktree ")
        current_worktree_path="${line#worktree }"

        # Comprobar si es el worktree principal
        if [[ "$current_worktree_path" == "$main_worktree_path" ]]; then
            log "Saltando worktree principal: $current_worktree_path"
            continue # Pasar al siguiente bloque de worktree
        fi

        # Es un worktree adicional, intentar eliminarlo
        processed_count=$((processed_count + 1))
        log "Intentando eliminar worktree en: $current_worktree_path"

        # Comprobación extra: ¿Existe realmente el directorio?
        if [ ! -d "$current_worktree_path" ]; then
             warn "La ruta del worktree '$current_worktree_path' no existe o no es un directorio. Puede que ya se haya eliminado o esté dañado."
             # Aunque no exista, intentamos el remove por si Git tiene info interna
        fi

        # Intentar la eliminación forzada. Quita --force si prefieres que falle si hay cambios.
        git worktree remove --force "$current_worktree_path"

        if [[ $? -eq 0 ]]; then
            log "Worktree eliminado con éxito: $current_worktree_path"
            removed_count=$((removed_count + 1))

            # --- Opcional: Intentar eliminar directorio base si queda vacío ---
            # Descomenta las siguientes líneas si quieres intentar borrar carpetas como "2024.1"
            # SIEMPRE Y CUANDO queden vacías después de borrar el worktree. ¡Úsalo con precaución!
            # base_dir=$(dirname "$current_worktree_path")
            # # Asegurarse de no intentar borrar la raíz del repo (.) ni directorios fuera del repo
            # if [[ "$base_dir" != "." && "$base_dir" != "/" && -d "$base_dir" ]]; then
            #    # Comprobar si está vacío (ls -A lista todo excepto . y ..)
            #    if [ -z "$(ls -A "$base_dir")" ]; then
            #        log "Directorio base '$base_dir' parece vacío. Intentando eliminarlo..."
            #        rmdir "$base_dir"
            #        if [[ $? -eq 0 ]]; then
            #             log "Directorio base vacío '$base_dir' eliminado."
            #        else
            #             warn "No se pudo eliminar el directorio base '$base_dir' (quizás no esté vacío o falten permisos)."
            #        fi
            #    fi
            # fi
            # --- Fin Opcional ---

        else
            error_msg="Fallo al eliminar el worktree en '$current_worktree_path'. Comprueba la salida de Git y posibles problemas (permisos, procesos abiertos)."
            error "$error_msg"
            # Guardamos el error para mostrarlo al final
            errors+=("$error_msg")
        fi
    fi
done # El bucle while procesa la salida del comando 'git worktree list --porcelain'

# 4. Limpiar referencias obsoletas de worktrees
log "Ejecutando 'git worktree prune' para limpiar referencias internas..."
git worktree prune
if [[ $? -ne 0 ]]; then
    warn "'git worktree prune' finalizó con advertencias o errores. Revisa la salida."
fi

# 5. Resumen final
log "--------------------------------------------------"
log "Resumen del Desmontaje de Worktrees:"
log "  Worktrees adicionales encontrados: $processed_count"
log "  Worktrees eliminados con éxito:  $removed_count"

if [[ ${#errors[@]} -gt 0 ]]; then
    error "Se encontraron ${#errors[@]} errores durante la eliminación:"
    for err in "${errors[@]}"; do
        error "  - $err"
    done
    warn "Es posible que necesites eliminar manualmente algún directorio o ejecutar 'git worktree prune' de nuevo."
    exit 1 # Salir con error si algo falló
else
    if [[ $processed_count -eq $removed_count ]]; then
        log "Todos los worktrees adicionales fueron eliminados correctamente."
    else
         warn "Algunos worktrees no pudieron ser eliminados. Revisa los mensajes anteriores."
         # Podríamos salir con error aquí también si processed != removed aunque no haya habido errores explícitos
         # exit 1
    fi
fi

log "Script finalizado."
exit 0
