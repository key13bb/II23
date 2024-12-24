#include <iostream>

using namespace std;

bool esPrimoRec(int num, int divisor)
{
    bool primo;
    if (divisor >= num / 2) {
        primo = true;
    } else if (num % divisor == 0) {
        primo = false;
    } else {
        primo = esPrimoRec(num, divisor + 1);
    }
    return primo;
}

void comprobar(int& n)
{
    while (n <= 1) {
        cout << "Error: n debe ser mayor que 1" << endl;
        cout << "Introduce n: ";
        cin >> n;
    }
}

int main()
{
    int num;
    cout << "Introduce un número: ";
    cin >> num;
    comprobar(num);
    if (esPrimoRec(num, 2)) {
        cout << "El número " << num << " es primo." << endl;
    } else {
        cout << "El número " << num << " no es primo." << endl;
    }
}