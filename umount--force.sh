#!/bin/sh
# Save files in worktrees before being umounted
sh save.sh
# Umount all worktrees
git worktree remove ./1.1/FELE --force
git worktree remove ./1.1/IPRO --force
git worktree remove ./1.1/MDIS --force
git worktree remove ./1.1/OEMP --force

git worktree remove ./1.2/IISO --force
git worktree remove ./1.2/PAV1 --force
git worktree remove ./1.2/TCOM --force

git worktree remove ./2.1/ADAL --force
git worktree remove ./2.1/BDAT --force
git worktree remove ./2.1/ECOM --force
git worktree remove ./2.1/MECO --force

git worktree remove ./2.2/FIAR --force
git worktree remove ./2.2/PAV2 --force
git worktree remove ./2.2/RSER --force
git worktree remove ./2.2/SOPE --force
git worktree remove ./2.2/TALF --force
