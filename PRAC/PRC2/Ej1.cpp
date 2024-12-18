#include <iostream>

using namespace std;

int main() {
    float num;

    cout << "Introduce un numero: ";
    cin >> num;

    if(num>=0) {
        cout << "El numero es positivo";
    } else {
        cout << "El numero es negativo";
    }

    return 0;
}
