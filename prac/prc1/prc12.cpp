#include <iostream>
using namespace std;
int main()
{
    int a = 6, b = 14;
    int auxiliar;
    cout << "a vale " << a << " y b vale " << b << endl;
    // ¿Qué hacen estas tres sentencias?
    auxiliar = a;
    a = b;
    b = auxiliar;
    cout << "a vale " << a << " y b vale " << b << endl;
    a = a + b;
    b = a - b;
    a = a - b;
    cout << "a vale " << a << " y b vale " << b << endl;
    return 0;
}

/*
 * Tanto uno como otro grupo de sentencias llevan a cabo el intercambio de
 * los valores almacenados en dos variables (a y b). En el primer caso se
 * hace uso de una variable intermedia (auxiliar)
 */