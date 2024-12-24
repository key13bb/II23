#include <iostream>
using namespace std;
const int DISTANCIA = 'a' - 'A';
int main()
{
    cout << endl
         << "Iniciado" << endl;
    char caracter;
    cout << "Introduce 4 letras minusculas: ";
    for (int i = 0; i < 4; i++)
    {
        cin >> caracter;
        cout << char(caracter - DISTANCIA);
    }
    cout << endl;
}