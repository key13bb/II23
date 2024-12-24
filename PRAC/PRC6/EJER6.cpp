#include <array>
#include <cmath>
#include <iostream>

using namespace std;

const int MAX = 100;
typedef array<bool, MAX + 1> TArray;

struct TPrimos {
    TArray primos;
    int limite;
};

void inicializar(TPrimos& num, int n)
{
    if (n > MAX) {
        num.limite = MAX;
    } else {
        num.limite = n;
    }
    num.primos[1] = false;
    for (int i = 2; i <= num.limite; i++) {
        num.primos[i] = true;
    }
}

void eliminarMultiplos(TPrimos& num, int primo)
{
    for (int i = 2 * primo; i <= num.limite; i += primo) {
        num.primos[i] = false;
    }
}

void encontrarPrimos(TPrimos& num)
{
    for (int i = 2; i <= sqrt(num.limite); i++) {
        if (num.primos[i]) {
            eliminarMultiplos(num, i);
        }
    }
}

void imprimirPrimos(const TPrimos& num)
{
    cout << "Los numeros primos menores o iguales que " << num.limite << " son:\n";
    for (int i = 1; i <= num.limite; i++) {
        if (num.primos[i]) {
            cout << i << " ";
        }
    }
}

void eratostenes(int n)
{
    TPrimos num;
    inicializar(num, n);
    encontrarPrimos(num);
    imprimirPrimos(num);
}

int leer()
{
    int n;
    do {
        cout << "Introduzca el limite para calcular los primos (> 0 y <= " << MAX << "): ";
        cin >> n;
    } while (n <= 0 || n > MAX);
    return n;
}

int main()
{
    int n;
    n = leer();
    eratostenes(n);
    return 0;
}