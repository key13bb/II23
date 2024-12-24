#include <array>
#include <iostream>

using namespace std;

const int N = 5;
const int NUM_VALORES = N * N;

typedef array<int, N> TFila;
typedef array<TFila, N> TMatriz;
typedef array<bool, NUM_VALORES + 1> TRango;

int sumaFila(const TFila& fila)
{
    int suma = 0;
    for (int c = 0; c < N; c++) {
        suma += fila[c];
    }
    return suma;
}
int sumaCol(const TMatriz& m, int c)
{
    int suma = 0;
    for (int f = 0; f < N; f++) {
        suma += m[f][c];
    }
    return suma;
}
int sumaDiag1(const TMatriz& m)
{
    int suma = 0;
    for (int i = 0; i < N; i++) {
        suma += m[i][i];
    }
    return suma;
}
int sumaDiag2(const TMatriz& m)
{
    int suma = 0;
    for (int c = 0; c < N; c++) {
        suma += m[(N - 1) - c][c];
    }
    return suma;
}
bool filasIguales(const TMatriz& m, int v)
{
    int f = 0;
    while ((f < N) && (v == sumaFila(m[f]))) {
        f++;
    }
    return (f >= N);
}
bool colIguales(const TMatriz& m, int v)
{
    int c = 0;
    while ((c < N) && (v == sumaCol(m, c))) {
        c++;
    }
    return (c >= N);
}
bool diagIguales(const TMatriz& m, int v)
{
    return ((v == sumaDiag1(m)) && (v == sumaDiag2(m)));
}
bool numerosDentroRango(const TMatriz& m)
{
    TRango rango = { {} };
    bool bien = true;
    int i, j;
    i = 0;
    while ((i < N) && bien) {
        j = 0;
        while ((j < N) && bien) {
            if ((1 <= m[i][j]) && (m[i][j] <= NUM_VALORES) && (!rango[m[i][j]])) {
                rango[m[i][j]] = true;
            } else {
                bien = false;
            }
            j++;
        }
        i++;
    }
    return bien;
}
bool esMagico(const TMatriz& m)
{
    int valor = sumaFila(m[0]);
    return filasIguales(m, valor) && colIguales(m, valor) && diagIguales(m, valor) && numerosDentroRango(m);
}
void leer(TMatriz& m)
{
    cout << "Introduzca por filas una matriz " << N << " x " << N << ":\n";
    for (int f = 0; f < N; f++) {
        for (int c = 0; c < N; c++) {
            cin >> m[f][c];
        }
    }
}
int main()
{
    TMatriz m;
    leer(m);
    if (esMagico(m)) {
        cout << "SI es magico" << endl;
    } else {
        cout << "No es magico" << endl;
    }
    return 0;
}