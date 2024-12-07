#!/bin/sh

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

# Mount all worktrees
git worktree add ./1.1/FELE 1.1/FELE
git worktree add ./1.1/IPRO 1.1/IPRO
git worktree add ./1.1/MDIS 1.1/MDIS
git worktree add ./1.1/OEMP 1.1/OEMP

git worktree add ./1.2/IISO 1.2/IISO
git worktree add ./1.2/PAV1 1.2/PAV1
git worktree add ./1.2/TCOM 1.2/TCOM

git worktree add ./2.1/ADAL 2.1/ADAL
git worktree add ./2.1/BDAT 2.1/BDAT
git worktree add ./2.1/ECOM 2.1/ECOM
git worktree add ./2.1/MECO 2.1/MECO

git worktree add ./2.2/FIAR 2.2/FIAR
git worktree add ./2.2/PAV2 2.2/PAV2
git worktree add ./2.2/RSER 2.2/RSER
git worktree add ./2.2/SOPE 2.2/SOPE
git worktree add ./2.2/TALF 2.2/TALF
