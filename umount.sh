#!/bin/bash
#Save files in worktrees before being umounted
sh save.sh

# Umount all worktrees
for cuat in ./.git/refs/heads/*; do
    if [ "$(basename "$cuat")" != "MAIN" ]; then
        for branch in "$cuat"/*; do
            git worktree remove "$(basename "$cuat")/$(basename "$branch")"
        done
    fi
done