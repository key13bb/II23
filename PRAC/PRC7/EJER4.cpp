#include <array>
#include <iostream>
using namespace std;
const int M = 4;
typedef array<int, M> TFila;
typedef array<TFila, M> TMatriz;
void leerMatriz(TMatriz& m)
{
    cout << "Introduzca una matriz de enteros de " << M << "x" << M << " (por filas): " << endl;
    for (int fi = 0; fi < M; fi++) {
        for (int co = 0; co < M; co++) {
            cin >> m[fi][co];
        }
    }
}
void leerFila(int& fi)
{
    do {
        cout << endl
             << "Introduzca la fila a sumar (entre 0 y " << M - 1 << "): ";
        cin >> fi;
    } while (fi < 0 || fi > M - 1);
}
void leerColumna(int& co)
{
    do {
        cout << endl
             << "Introduzca la columna a sumar (entre 0 y " << M - 1 << "): ";
        cin >> co;
    } while (co < 0 || co > M - 1);
}
int sumaFila(const TMatriz& m, int fi)
{
    int suma = 0;
    for (int co = 0; co < M; co++) {
        suma += m[fi][co];
    }
    return suma;
}
int sumaColumna(const TMatriz& m, int co)
{
    int suma = 0;
    for (int fi = 0; fi < M; fi++) {
        suma += m[fi][co];
    }
    return suma;
}
int sumaDiagonalPrincipal(const TMatriz& m)
{
    int suma = 0;
    for (int fi = 0; fi < M; fi++) {
        suma += m[fi][fi];
    }
    return suma;
}
int sumaDiagonalSecundaria(const TMatriz& m)
{
    int suma = 0;
    for (int fi = 0; fi < M; fi++) {
        suma += m[fi][M - 1 - fi];
    }
    return suma;
}
int main()
{
    TMatriz m;
    int fi, co;
    leerMatriz(m);
    leerFila(fi);
    cout << "La suma de la fila " << fi << " es: " << sumaFila(m, fi) << endl;
    leerColumna(co);
    cout << "La suma de la columna " << co << " es: " << sumaColumna(m, co) << endl;
    cout << "La suma de la diagonal principal es: " << sumaDiagonalPrincipal(m) << endl;
    cout << "La suma de la diagonal secundaria es: " << sumaDiagonalSecundaria(m) << endl;
    return 0;
}