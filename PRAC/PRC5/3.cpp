#include <iostream>

using namespace std;

int producto(int x, int y) {
    int res;
    if (y == 0) {
        res = 0;
    } else {
        res = x + producto(x, y - 1);
    }
    return res;
}

void comprobar(int & x, int & n) {
    while (x<0 || n<0) {
        cout << "Error: x e y deben ser mayores o iguales a 0" << endl;
        cout << "Introduce x: ";
        cin >> x;
        cout << "Introduce y: ";
        cin >> n;
    }
}

int main() {
    int x, y;
    cout << "Introduce x: ";
    cin >> x;
    cout << "Introduce y: ";
    cin >> y;
    comprobar(x, y);
    cout << "El producto de " << x << " y " << y << " es " << producto(x, y) << endl;
    return 0;
}