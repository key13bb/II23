#include <iostream>

using namespace std;

int main() {

    cout << endl << "Iniciado" << endl;

    int tam;
    cout << "Introduce el tamaño en bytes: ";
    cin >> tam;
    cout << (tam/1024)/1024 << " MB" << endl;
    cout << (tam/1024)%1024 << " KB" << endl;
    cout << (tam%1024) << " B" << endl;

    return 0;
}