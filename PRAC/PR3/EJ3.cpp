#include <iostream>

using namespace std;

int main() {

    cout << endl << "Iniciado" << endl;

    int rowcol;

    cout << "Introduzca un numero: ";
    cin >> rowcol;

    for (int i=0; i<rowcol; i++) {
        for (int j=0; j<rowcol; j++) {
            if ((i+j)%2 == 0) {
                cout << "x";
            } else {
                cout << "o";
            }
        }
        cout << endl;
    }

}