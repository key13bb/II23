#include <iostream>

using namespace std;

int main() {

    cout << endl << "Iniciado" << endl;

    int res = 0, temp, n;

    cout << "Introduce numero de modelo de coches: ";
    cin >> n;

    for(int i=1; i<=n; i++) {
        cout << "Precio modelo " << i << ": ";
        cin >> temp;
        res += temp;
    }

    res /= n;
    cout << "El valor medio de los " << n << "modelos de coche asciende a: " << res << " euros";

}