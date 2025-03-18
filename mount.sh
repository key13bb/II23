#!/bin/bash

# Mount all worktrees
for cuat in ./.git/refs/heads/*; do
    if [ "$(basename "$cuat")" != "MAIN" ]; then
        for branch in "$cuat"/*; do
            git worktree add "$(basename "$cuat")/$(basename "$branch")" "$(basename "$cuat")/$(basename "$branch")"
        done
    fi
done

# Restore all config folders
sh restore.sh