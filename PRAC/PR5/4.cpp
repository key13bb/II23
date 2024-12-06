#include <iostream>

using namespace std;

void inverso (int n) {
    if (n <= 9) {
        cout << n;
    } else {
        cout << n % 10;
        inverso(n / 10);
    }
}

void comprobar(int & n) {
    while (n < 0) {
        cout << "Error: n debe ser mayor o igual a 0" << endl;
        cout << "Introduce n: ";
        cin >> n;
    }
}

int main() {
    int n;
    cout << "Introduce n: ";
    cin >> n;
    comprobar(n);
    cout << "El inverso de " << n << " es ";
    inverso(n);
}