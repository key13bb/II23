/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */

#include <array>
#include <iostream>

using namespace std;

const int MAX_LONG_DIST = 15;

typedef array<int, MAX_LONG_DIST> Tarray;

int tamano(int numero)
{
    int tam = 0;
    while (numero != 0) {
        numero /= 10;
        tam++;
    }
    return tam;
}

void procesarNumero(Tarray& tam, Tarray& rep, int numero)
{
    int tamNum = tamano(numero);
    bool proc = false;
    int i = 0;
    while (proc == false || i == MAX_LONG_DIST - 1) {
        if (tam[i] == 0) {
            tam[i] = tamNum;
            rep[i]++;
            proc = true;
        } else if (tam[i] == tamNum) {
            rep[i]++;
            proc = true;
        }
        i++;
    }
}

void mostrar(const Tarray& tam, const Tarray& rep)
{
    cout << "Resultado (L = Longitud; V = Veces que ocurre esa Longitud): " << endl;
    cout << "L V" << endl;
    for (int i = 0; i < MAX_LONG_DIST; i++) {
        if (tam[i] != 0) {
            cout << tam[i] << " " << rep[i] << endl;
        }
    }
}

int main()
{
    Tarray tam = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, rep = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int numero = -1;
    cout << "Introduce una coleccion de numeros enteros (0 para terminar): ";
    while (numero != 0) {
        cin >> numero;
        procesarNumero(tam, rep, numero);
    }
    mostrar(tam, rep);
}