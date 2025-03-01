"""
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.
"""

def primos(a: int, b: int) -> list:
    """
    Funcion que recibe dos numeros enteros y devuelve una lista con los numeros primos entre ellos.
    """
    lista = []
    for i in range(a, b):
        if i > 1:
            for j in range(2, i):
                if i % j == 0:
                    break
            else:
                lista.append(i)
    return lista

def main() -> None:
    a = int(input("Ingrese el primer numero: "))
    b = int(input("Ingrese el segundo numero: "))
    print(primos(a, b))

main()