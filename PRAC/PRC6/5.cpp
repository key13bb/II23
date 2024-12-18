#include <iostream>
#include <array>

using namespace std; 

const int MAX = 10;
typedef array<int,MAX> TArray;

void leerDatos(TArray& a) {
    cout << "Introduzca la sucesion de " << MAX << " naturales: ";
    for (int i = 0; i < MAX; i++) {
        cin >> a[i];
    }
}

int calcularMaximo(const TArray& a) {
    int maximo = a[0];
    for (int i = 1; i < MAX; i++) {
        if (a[i] > maximo) {
            maximo = a[i];
        }
    }
    return maximo;
}
    
int calcularAparicionesMax(const TArray& a, int maximo) {
    int apariciones = 0;
    for (int i = 0; i < MAX; i++) {
        if (a[i] == maximo) {
            apariciones++;
        }
    }
    return apariciones; 
}  

void escribirDatosYActualizar(TArray& a, int maximo, int apariciones) {  
    cout << maximo << " aparece " << apariciones;  
    if (apariciones > 1) {  
        cout << " veces, en las posiciones ";  
    } else {   
        cout << " vez, en la posicion ";  
    }  for (int i = 0; i < MAX; i++) {   
        if (a[i] == maximo) {    
            cout << i+1 << " ";    
            a[i] = -1; 
        }   
    }   
    cout << endl; 
}    

int main(){  
    TArray a;  
    int numAnalizados = 0;  
    int maximo, apariciones;   
    leerDatos(a);   
    while (numAnalizados < MAX) {   
        maximo = calcularMaximo(a);   
        apariciones = calcularAparicionesMax(a, maximo);   
        escribirDatosYActualizar(a, maximo, apariciones);   
        numAnalizados += apariciones;  
    } 
}