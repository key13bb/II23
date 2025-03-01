"""
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.
"""

def par(lista: list) -> list:
    res = []
    it = 0
    num = lista[it]
    while num % 2 != 0:
        it += 1
        num = lista[it]
        res.append(num)
    res.remove(num)
    return res

def main():
    lista = [1, 3, 5, 7, 8, 9, 10, 11, 12]
    print(par(lista))

main()