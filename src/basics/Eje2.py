"""
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.
"""

def producto(nombre, precio, cantidad) -> float:
    print(nombre + ": " + str(cantidad) + " unidades x " + f"{precio:09.2f}" + "€ = " + f"{precio*cantidad:011.2f}" + "€")
    return precio*cantidad

def main() -> None:
    nombre = input("Ingrese el nombre del producto: ")
    precio = float(input("Ingrese el precio del producto: "))
    cantidad = int(input("Ingrese la cantidad de unidades: "))
    producto(nombre, precio, cantidad)

main()