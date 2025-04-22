"""
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.
"""

def sumas(lista: list[tuple]) -> list[int]:
    lista2 = []
    for tupla in lista:
        res = 0
        for num in tupla:
            res += num
        lista2.append(res)
    return lista2

def main() -> None:
    lista = [(1, 2), (3, 4), (5, 6), (7, 8), (9, 10, 11)]
    print(sumas(lista))

main()