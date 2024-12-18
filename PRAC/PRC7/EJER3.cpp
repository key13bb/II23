#include <iostream>
#include <array>
#include <string>

using namespace std;

const int MAX_PAL_DIST = 4;

typedef array<string, MAX_PAL_DIST> Palabras;

struct Cadena {
    Palabras palabras;
    int numPal = 0;
};

int tamPalabra(string palabra) {
    return palabra.length();
}

void insertarPalabra(Cadena &c, string palabra) {
    if (c.numPal == 0) {
        c.palabras[0] = palabra;
    } else {
        int i = 0;
        while (i < c.numPal && tamPalabra(c.palabras[i]) < tamPalabra(palabra)) {
            i++;
        }
        for (int j = c.numPal; j > i; j--) {
            c.palabras[j] = c.palabras[j - 1];
        }
        c.palabras[i] = palabra;
    }
    c.numPal++;
}

bool comprobarPalabra(Cadena c, string p) {
    bool found = false, valido = false;
    for (int i = 0; i < c.numPal; i++) {
        if (c.palabras[i] == p) {
            found = true;
        }
    }
    if (!found) {
        valido = true;
    }
    return valido;
} 

int main() {

    Cadena input;
    cout << "Introduzca un texto (FIN para terminar): ";
    string palabra = "";
    while (palabra != "FIN") {
        cin >> palabra;
        if (palabra != "FIN") {
            if (input.numPal == 0) {
                input.palabras[0] = palabra;
            } else {
                if (comprobarPalabra(input, palabra)) {
                    insertarPalabra(input, palabra);
                }
            }
            input.numPal++;
        }
    }

    cout << "Las palabras ordenadas de menor a mayor longitud son: " << endl;
    for (int i = 0; i < input.numPal; i++) {
        cout << input.palabras[i] << endl;
    }
}