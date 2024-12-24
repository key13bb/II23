#include <array>
#include <iostream>

using namespace std;

const int NUM = 10;
typedef array<int, NUM> TVector;

void leer(TVector& vec)
{
    int i;
    cout << "Introduzca una secuencia de digitos (negativo termina): " << endl;
    cin >> i;
    while (i >= 0) {
        vec[i]++;
        cin >> i;
    }
}

void mostrar(TVector v)
{
    for (int i = 0; i < NUM; i++) {
        cout << i << ": " << v[i] << endl;
    }
}

int main()
{
    TVector v;
    v = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    leer(v);
    cout << "La frecuencia de cada digito es:" << endl;
    mostrar(v);
}