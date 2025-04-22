"""
GNU GENERAL PUBLIC LICENSE
Version 3, 29 June 2007

Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
Everyone is permitted to copy and distribute verbatim copies
of this license document, but changing it is not allowed.
"""

def dominio(correo: str) -> list:
    splitted = correo.split("@")
    print("Usuario: " + splitted[0])
    print("Dominio: " + splitted[1])
    return splitted

def main() -> None:
    correo = input("Ingrese su correo: ")
    dominio(correo)

main()