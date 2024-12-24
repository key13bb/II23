#include <iostream>
using namespace std;
const int SEG_EN_MIN = 60;
const int MIN_EN_HOR = 60;
const int SEG_EN_HOR = SEG_EN_MIN * MIN_EN_HOR;
const int HOR_EN_DIA = 24;
const int SEG_EN_DIA = SEG_EN_HOR * HOR_EN_DIA;
const int DIA_EN_SEM = 7;
const int SEG_EN_SEM = SEG_EN_DIA * DIA_EN_SEM;
int main()
{
    unsigned segundos;
    cout << "Introduzca una cantidad de segundos: ";
    cin >> segundos;
    cout << "Esa cantidad forma:" << endl;
    cout << " semanas = " << segundos / SEG_EN_SEM << endl;
    segundos = segundos % SEG_EN_SEM;
    cout << " dias = " << segundos / SEG_EN_DIA << endl;
    segundos = segundos % SEG_EN_DIA;
    cout << " horas = " << segundos / SEG_EN_HOR << endl;
    segundos = segundos % SEG_EN_HOR;
    cout << " minutos = " << segundos / SEG_EN_MIN << endl;
    segundos = segundos % SEG_EN_MIN;
    cout << " segundos = " << segundos << endl;
    return 0;
}