#include <iostream>

using namespace std;

void decimalAbinario (int n) {
    if(n == 0) {
        cout << "0";
    } else if(n == 1) {
        cout << "1";
    } else {
        decimalAbinario(n / 2);
        cout << n % 2;
    }
}

int main() {
    int num;
    cout << "Introduce un número: ";
    cin >> num;
    decimalAbinario(num);
}