#include <array>
#include <iostream>

using namespace std;

const int FILAS = 4;
const int COLUMNAS = 5;

struct Posicion {
    int fila;
    int columna;
};

typedef array<int, FILAS> Tfila;
typedef array<Tfila, COLUMNAS> Tmatriz;

int main()
{
    Tmatriz matriz;
    int mayor = 0;
    Posicion mmayor;
    cout << "Introduce por filas una matriz " << FILAS << " x " << COLUMNAS << ": " << endl;
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            cin >> matriz[i][j];
            if (mayor == 0) {
                mayor = matriz[i][j];
            } else if (matriz[i][j] > mayor) {
                mayor = matriz[i][j];
                mmayor.fila = i;
                mmayor.columna = j;
            }
        }
    }
    cout << "El mayor elemento de la matriz es: " << mayor << " que aparece en la posicion: [" << mmayor.fila << "][" << mmayor.columna << "]" << endl;
}