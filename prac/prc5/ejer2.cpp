#include <iostream>

using namespace std;

int potencia(int x, int n)
{
    int res;
    if (n == 0) {
        res = 1;
    } else {
        res = potencia(x, n - 1) * x;
    }
    return res;
}

void comprobar(int& x, int& n)
{
    while (x < 0 || n < 0) {
        cout << "Error: x y n deben ser mayores o iguales a 0" << endl;
        cout << "Introduce x: ";
        cin >> x;
        cout << "Introduce n: ";
        cin >> n;
    }
}

int main()
{
    int x, n;
    cout << "Introduce x: ";
    cin >> x;
    cout << "Introduce n: ";
    cin >> n;
    comprobar(x, n);
    cout << "El resultado de " << x << " elevado a " << n << " es " << potencia(x, n) << endl;
}