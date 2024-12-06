#include <iostream>

using namespace std;

const float PRECIO = 100;
const float IVA = 1.12; // 1 del precio total + 0.12 del IVA
const float DISC = 0.95; // 1 es el precio total - 0.05 de descuento

int main() {
    float total;
    int unidades;

    cout << "Numero de unidades adquiridas: ";
    cin >> unidades;

    total = PRECIO*unidades*IVA;

    if (total >= 300) {
        cout << "Se aplica un descuento del 5%" << endl;
        total *= DISC;
    }

    cout << "El precio total a pagar es: " << total << " euros";

    return 0;
}
