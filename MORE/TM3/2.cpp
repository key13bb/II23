#include <iostream>

using namespace std;

int main() {
    cout << "Introduzca sucesión de ceros y unos hasta punto: ";
    char c, copy;
    int count=0, max=1;
    cin >> c;
    while (c != '.') {
        copy = c;
        count++;
        cin >> c;
        if(copy=='1' && c=='0') {
            if(count > max) {
                max = count;
            }
            count = 0;
        }
    }
    if(count > max) {
        max = count;
    }
    cout << "Mayor subsucesion ordenada: " << max << endl;
}