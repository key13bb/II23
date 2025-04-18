#include <iostream>
using namespace std;

int main()
{
    int mes;
    cout << "Introduzca numero de mes: ";
    cin >> mes;

    switch (mes) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
        cout << "El mes tiene 31 dias";
        break;
    case 4:
    case 6:
    case 9:
    case 11:
        cout << "El mes tiene 30 dias";
        break;
    case 2:
        cout << "El mes tiene 28 dias";
        break;
    default:
        cout << "Mes incorrecto";
        break;
    }
    return 0;
}
