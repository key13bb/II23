#include <array>
#include <iostream>

using namespace std;

const int MAX = 50;
typedef array<int, MAX> TEstaturas;

double media(const TEstaturas& est, int def, int& menor, int& mayor)
{
    int suma = 0;
    for (int i = 0; i < def; i++) {
        suma += est[i];
    }
    double med = 0;
    med = suma / def;
    for (int j = 0; j < def; j++) {
        if (est[j] < med) {
            menor++;
        } else {
            mayor++;
        }
    }
    return med;
}

void leer(TEstaturas& est, int def)
{
    cout << "Introduzca las " << def << " estaturas: ";
    for (int i = 0; i < def; i++) {
        cin >> est[i];
    }
}

int main()
{
    TEstaturas est;
    int def, menor = 0, mayor = 0;
    cout << "Cuantas estaturas va a introducir (maximo " << MAX << "): ";
    cin >> def;
    leer(est, def);
    cout << "La media es: " << media(est, def, menor, mayor) << endl;
    cout << "Numero de alumnos mas altos que la media: " << mayor << endl;
    cout << "Numero de alumnos mas bajos que la media: " << menor << endl;
}