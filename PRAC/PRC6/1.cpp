#include <iostream>
#include <array>

using namespace std;

const int TAM = 10;
typedef array<int, TAM> TVector;

int mayor(TVector v) {
    int max = v[0];
    for (int i = 1; i < v.size(); i++) {
        if (v[i] > max) {
            max = v[i];
        }
    }
    return max;
}

void leer(TVector& v) {
    for (int i = 0; i < v.size(); i++) {
        cin >> v[i];
    }
}

int main() {
    cout << "Introduce " << TAM << " numeros enteros: ";
    TVector v;
    leer(v);
    cout << "El mayor del array es: " << mayor(v) << endl;
}