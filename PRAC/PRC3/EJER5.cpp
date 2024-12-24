#include <iostream>

using namespace std;

int main()
{

    cout << endl
         << "Iniciado" << endl;

    int n;
    double up = 2, down = 1, pi = 0;

    cout << "Introduce un numero: ";
    cin >> n;

    for (int i = 0; i < n; i++) {
        if (i == 0) {
            pi += 4;
        } else {
            pi *= up / down;
        }
        if (i % 2 == 1) {
            up += 2;
        } else {
            down += 2;
        }
    }

    cout << pi;
}