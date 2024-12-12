#!/bin/sh
# Save files in worktrees before being umounted
sh save.sh
# Umount all worktrees
git worktree remove ./1.1/FELE
git worktree remove ./1.1/IPRO
git worktree remove ./1.1/MDIS
git worktree remove ./1.1/OEMP

git worktree remove ./1.2/IISO
git worktree remove ./1.2/PAV1
git worktree remove ./1.2/TCOM

git worktree remove ./2.1/ADAL
git worktree remove ./2.1/BDAT
git worktree remove ./2.1/ECOM
git worktree remove ./2.1/MECO

git worktree remove ./2.2/FIAR
git worktree remove ./2.2/PAV2
git worktree remove ./2.2/RSER
git worktree remove ./2.2/SOPE
git worktree remove ./2.2/TALF
