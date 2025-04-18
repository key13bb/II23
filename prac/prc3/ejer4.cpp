#include <iostream>

using namespace std;

int main()
{

    cout << endl
         << "Iniciado" << endl;

    char caracter;
    cout << "Introduzca el texto terminado en un punto: " << endl;
    cin >> caracter;

    while (caracter != '.') {
        cout << int(caracter) << " ";
        cin.get(caracter);
    }
}