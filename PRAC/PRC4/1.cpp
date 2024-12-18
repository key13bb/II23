#include <iostream>

using namespace std;

void leer(int& a, int& b) {
    cin >> a;
    cin >> b;
}

void ordenar(int& a, int& b){
    if(a>b) {
        int aux;
        aux=a;
        a=b;
        b=aux;
    }
}

double factorial(int n){
    double res=1;
    for(int i=n; i>0; i--){
        res *= i;
    }
    return res;
}

double potencia(int base, int exp){
    double res=1;
    for(int i=exp; i>0; i--){
        res *= base;
    }
    return res;
}

double termino(int a, int b){
    return potencia(b,a)/factorial(a);
}

void mostrar(double t) {
    cout <<  "El resultado es: " << t;
}

int main() {

    int a=0, b=0;

    cout << "Introduce dos numeros enteros mayores que cero: ";
    leer(a,b);
    while(a<=0 || b<=0) {
        cout << "Error. Introduce dos numeros enteros mayores que cero: ";
        leer(a,b);
    }
    ordenar(a,b);
    mostrar(termino(a,b));

}
