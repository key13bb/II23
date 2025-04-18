#include <iostream>

using namespace std;

int sumaNaturales(int n)
{
    int res;
    if (n == 0) {
        res = 0;
    } else {
        res = n + sumaNaturales(n - 1);
    }
    return res;
}

int main()
{
    int n;
    cout << "Introduce un número: ";
    cin >> n;
    cout << "La suma de los " << n << " primeros números naturales es: " << sumaNaturales(n) << endl;
}