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

const int TAM = 5;

typedef array<int, TAM> TFila;
typedef array<TFila, TAM> TMatriz;

void leer(TMatriz& matriz)
{
    cout << "Introduce " << TAM << " x " << TAM << " numeros: ";
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            cin >> matriz[i][j];
        }
    }
}

double media(TFila fila)
{
    double suma = 0.0;
    for (int i = 0; i < TAM; i++) {
        suma += fila[i];
    }
    return suma / TAM;
}

TFila diagonal(TMatriz matriz)
{
    TFila diagonal;
    for (int i = 0; i < TAM; i++) {
        diagonal[i] = matriz[i][i];
    }
    return diagonal;
}

TFila columnar(TMatriz matriz, int col)
{
    TFila columna;
    for (int i = 0; i < TAM; i++) {
        columna[i] = matriz[i][col];
    }
    return columna;
}

bool comparar(TFila columna, double mediaDiag)
{
    bool found = false;
    double mediaCol = media(columna);
    if (mediaCol >= mediaDiag) {
        found = true;
    }
    return found;
}

int procesar(TMatriz matriz, double mediaDiag)
{
    int res = -1, i = 0;
    bool encontrado = false;
    while (!encontrado && i < TAM) {
        TFila columna = columnar(matriz, i);
        if (comparar(columna, mediaDiag)) {
            res = i;
            encontrado = true;
        }
        i++;
    }
    return res;
}

void mostrar(TMatriz matriz, float mediaDiag, int res)
{
    cout << "Matriz: " << endl;
    for (int i = 0; i < TAM; i++) {
        for (int j = 0; j < TAM; j++) {
            cout << matriz[i][j] << " ";
        }
        cout << endl;
    }
    cout << "Media diagonal: " << mediaDiag << endl;
    if (res != -1) {
        cout << "El indice de la columna es: " << res << endl;
    } else {
        cout << "La columna no ha sido encontrada" << endl;
    }
}

int main()
{
    TMatriz matriz;
    leer(matriz);
    TFila diag = diagonal(matriz);
    double mediaDiag = media(diag);
    int res = procesar(matriz, mediaDiag);
    mostrar(matriz, mediaDiag, res);
}