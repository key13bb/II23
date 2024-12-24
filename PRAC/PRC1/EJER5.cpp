#include <iostream>
using namespace std;
int main()
{
    cout << endl
         << "Iniciado" << endl;
    char caracter;
    cout << "Introduce 4 caracteres: ";
    for (int i = 0; i < 4; i++)
    {
        cin >> caracter;
        cout << char(caracter + 1);
    }
    cout << endl;
    return 0;
}