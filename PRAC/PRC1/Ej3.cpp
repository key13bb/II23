/*
Si se introduce un valor int, imprime ese valor.
Si se introducen caracteres, devuelve 0.
Si se introduce un decimal, se trunca el valor.
*/

#include <iostream>

using namespace std;

int main() {

    int valor;

    cout << "Introduce algo: ";
    cin >> valor;
    cout << valor << endl;

    return 0;
}