"""
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.
"""

def dicc(diccionario: dict, valor: str) -> dict:
    res = {}
    for i in diccionario:
        if diccionario.get(i) != valor:
            res[i] = diccionario.get(i)

    return res

def main() -> None:
    diccionario = {
        "a": "1",
        "b": "2",
        "c": "3",
        "d": "4",
        "e": "5"
    }
    valor = input("Ingrese el valor a eliminar: ")
    print(dicc(diccionario, valor))

main()