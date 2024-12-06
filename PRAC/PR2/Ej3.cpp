#include <iostream>

using namespace std;

int main() {
    char caracter;

    cout << "Introduce un caracter: ";
    cin >> caracter;

    if (((caracter >= 'A')&&(caracter <= 'Z'))||((caracter >= 'a')&&(caracter <= 'z'))) {
        cout << "Es letra";
    } else if (caracter == '.') {
        cout << "Es punto";
    } else {
        cout << "Error"
    }
}
