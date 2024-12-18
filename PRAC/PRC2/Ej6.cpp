#include <iostream>

using namespace std;

const int TRAMO1 = 100;
const int TRAMO2 = 150;

int main() {
    float total = 1;
    int kw;

    cout << "Introduzca el consumo del contador:  ";
    cin >> kw;

    if (kw > (TRAMO1 + TRAMO2)) {
        total += (kw-(TRAMO1+TRAMO2))*0.25;
        total += TRAMO1*0.5 + TRAMO2*0.35;
    } else if ((kw > TRAMO1)&&(kw <= TRAMO2)) {
        total += (kw-TRAMO1)*0.35;
        total += TRAMO1*0.5;
    } else if (kw <= TRAMO1) {
        total += kw*0.5;
    }

    cout << "El importe a pagar es: " << total << " euros";
    return 0;

}
