"""
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.
"""

def diff(cad1: str, cad2:str) -> str:
    list1 = list(cad1)
    list2 = list(cad2)
    for i in list2:
        if i in list1:
            list1.remove(i)
    return str(list1)

def main() -> None:
    cad1 = input("Ingrese la primera cadena: ")
    cad2 = input("Ingrese la segunda cadena: ")
    print(diff(cad1, cad2))

main()