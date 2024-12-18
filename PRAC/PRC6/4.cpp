#include <iostream>
#include <array>

using namespace std;

const int NUM = 10;
typedef array<int, NUM> TVector;

void leer(TVector& vec) {
    int i;
    cout << "Introduzca una secuencia de digitos (negativo termina): " << endl;
    cin >> i;
    while (i >= 0) {
        vec[i]++;
        cin >> i;
    }
}

void mostrar(TVector v, int maximo) {
    for (int i = maximo; i > 0; i--) {
        for (int j = 0; j < NUM; j++) {
            if (v[j] >= i) {
                cout << "* ";
            } else {
                cout << "  ";
            }
        }
        cout << endl;
    }

    for (int i = 0; i < NUM; i++) {
        cout << i << " ";
    }
}

int max (TVector v) {
    int max = v[0];
    for (int i = 0; i < NUM; i++) {
        if (v[i] > max) {
            max = v[i];
        }
    }
    return max;
}

int main() {
    TVector v;
    v = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    leer(v);
    cout << endl << endl;
    mostrar(v, max(v));
}