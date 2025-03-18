#!/bin/bash

for cuat in *; do
    if [ -d "$cuat" ]; then
        # Create folders
        mkdir -p "../Backup/$cuat"

        for subj in "$cuat"/*; do
            if [ -d "$subj" ]; then
                # Create more folders
                mkdir -p "../Backup/$subj"

                # Save .idea folders
                rm -rf "../Backup/$subj/.idea"
                mv "$subj/.idea" "../Backup/$subj/.idea"

                # Save .vscode folders
                rm -rf "../Backup/$subj/.vscode"
                mv "$subj/.vscode" "../Backup/$subj/.vscode"
            fi
        done
    fi
done