#include <iostream>

using namespace std;

void incremento_circular(int &x, int max) {
    x = (x + 1) % max;
}

int main() {
    int num = 0, max = 4, x = -1;
    while ((num<1) || (num>10)) {
        cout << "Ingrese el numero de filas: ";
        cin >> num;
    }
    for (int i = 0; i < num; i++) {
        for (int j = 0; j < max; j++) {
            int temp = x;
            incremento_circular(temp, max);
            x = temp;
            cout << x << " ";
        }
        cout << endl;
        incremento_circular(x, max);
    }
}