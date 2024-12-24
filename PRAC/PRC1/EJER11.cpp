#include <iostream>
using namespace std;
const double PORCENTAJE_TEORIA = 0.7;
const double PORCENTAJE_PRACTICA = 0.3;
int main()
{
    double teoria, practica, calificacion;
    cout << "Nota Teoria: ";
    cin >> teoria;
    cout << "Nota Practica: ";
    cin >> practica;
    calificacion = teoria * PORCENTAJE_TEORIA +
                   practica * PORCENTAJE_PRACTICA;
    cout << "La calificacion es: " << calificacion << endl;
    return 0;
}