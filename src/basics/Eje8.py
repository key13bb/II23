"""
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.
"""

def menor(lista: list) -> int:
    return menorrec(lista, False)

def menorrec(lista: list, exit: bool) -> int:
    num = lista[0]
    for i in lista:
        if i < num:
            num = i
    if exit:
        return num
    else:
        lista.remove(num)
        num = menorrec(lista, True)
    return num

def main() -> None:
    lista = [4, 2, 5, 1, 3]
    print(menor(lista))

main()