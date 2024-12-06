#include <iostream>
using namespace std;

int main() {
    int N;

    while (N<=0) {
        cout << "Introduce un numero mayor que 0: ";
        cin >> N;
    }

    int sum = 0;
    int i = 1;

    /*******************************************************
    
    i = 1;
    while (i <= N) {
        sum += i;
        i++;
    }

    ########################################################

    do {
        cout << "Enter a positive integer greater than 0: ";
        cin >> N;
    } while (N <= 0);

    sum = 0;
    i = 1;
    do {
        sum += i;
        i++;
    } while (i <= N);

    *******************************************************/

    sum = 0;
    for (i = 1; i <= N; i++) {
        sum += i;
    }

    cout << "Resultado: " << sum << endl;

    return 0;
}