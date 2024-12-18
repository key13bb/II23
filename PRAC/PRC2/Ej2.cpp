#include <iostream>

using namespace std;

int main() {
    int num1, num2, num3;

    cout << "Introduce tres numeros separados: ";
    cin >> num1 >> num2 >> num3;

    if ((num1 == num2)||(num2 == num3)||(num1 == num3)) {
        cout << "No hay mayor estricto";
    } else if ((num1 > num2)&&(num1 > num3)) {
        cout << "El mayor estricto es " << num1;
    } else if ((num2 > num1)&&(num2 > num3)) {
        cout << "El mayor estricto es " << num2;
    } else if ((num3 > num1)&&(num3 > num2)) {
        cout << "El mayor estricto es " << num3;
    }
}
