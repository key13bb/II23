#!/bin/bash

for cuat in *; do
    if [ -d "$cuat" ]; then
        for subj in "$cuat"/*; do
            if [ -d "$subj" ]; then
                # Restore .idea folders
                rm -rf "$subj/.idea"
                mv "../Backup/$subj/.idea" "$subj/.idea"

                # Restore .vscode folders
                rm -rf "$subj/.vscode"
                mv "../Backup/$subj/.vscode" "$subj/.vscode"
            fi
        done
    fi
done