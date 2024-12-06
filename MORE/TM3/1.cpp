#include <iostream>
#include <cmath>

using namespace std;

int main() {
    float res, x;

    cout << "Ingrese el valor de X [0..1]: ";
    cin >> x;
    res = x;

    for (int i = 0; i < 6; i++) {
        int up=1, num=1, down=2, den=1;

        for (int j = 0; j <= i; j++) {
            num *= up;
            up += 2;
            den *= down;
            down += 2;
        }
        res += (num*pow(x,up)) / (den*(down-1));
    }

    cout << "Serie: " << res << endl;
}