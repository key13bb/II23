#include <array>
#include <iostream>

using namespace std;

const int N_EVALUACIONES = 3;

typedef array<double, N_EVALUACIONES> T_Notas;

struct T_Reg_Alumno {
    string nombre;
    T_Notas notas;
};
const int MAX_ALUMNOS = 20;

typedef array<T_Reg_Alumno, MAX_ALUMNOS> T_Alumnos;

struct T_Clase {
    T_Alumnos alumnos;
    int n_alums;
    T_Notas notas_medias;
};

void leer_alumnos(T_Clase& clase)
{
    do {
        cout << "Introduce el numero de alumnos de la clase (maximo " << MAX_ALUMNOS << "): ";
        cin >> clase.n_alums;
    } while (clase.n_alums <= 0 || clase.n_alums > MAX_ALUMNOS);
    for (int i = 0; i < clase.n_alums; i++) {
        cout << "Introduce el nombre y " << N_EVALUACIONES << " notas: ";
        cin >> clase.alumnos[i].nombre;
        for (int j = 0; j < N_EVALUACIONES; j++) {
            cin >> clase.alumnos[i].notas[j];
        }
    }
}
double calcular_media(int evaluacion, const T_Clase& clase)
{
    double suma;
    suma = 0.0;
    for (int i = 0; i < clase.n_alums; i++) {
        suma += clase.alumnos[i].notas[evaluacion];
    }
    return (suma / clase.n_alums);
}
void calcular_notas_medias(T_Clase& clase)
{
    for (int i = 0; i < N_EVALUACIONES; i++) {
        clase.notas_medias[i] = calcular_media(i, clase);
    }
}
int calcular_car_bloque(const T_Clase& clase)
{
    int separacion_minima = 2;
    int max_car_nombre = clase.alumnos[0].nombre.size();
    for (int i = 1; i < clase.n_alums; i++) {
        if (int(clase.alumnos[i].nombre.size()) > max_car_nombre) {
            max_car_nombre = clase.alumnos[i].nombre.size();
        }
    }
    if (max_car_nombre < 8) {
        max_car_nombre = 8;
    }
    return max_car_nombre + separacion_minima;
}
void escribir_caracter(char car, int veces)
{
    for (int i = 1; i <= veces; i++) {
        cout << car;
    }
}
void escribir_cabecera(int car_bloque)
{
    cout << "Alumno";
    escribir_caracter(' ', car_bloque - 6);
    for (int i = 1; i <= 3; i++) {
        cout << "Nota-" << i;
        escribir_caracter(' ', car_bloque - 6);
    }
    cout << endl;
    escribir_caracter('-', car_bloque * 4);
    cout << endl;
}
void emitir_informe(const T_Clase& clase)
{
    int car_bloque = calcular_car_bloque(clase);
    escribir_cabecera(car_bloque);
    for (int i = 0; i < clase.n_alums; i++) {
        cout << clase.alumnos[i].nombre;
        escribir_caracter(' ', car_bloque - clase.alumnos[i].nombre.size());
        for (int j = 0; j < N_EVALUACIONES; j++) {
            if (clase.alumnos[i].notas[j] >= clase.notas_medias[j]) {
                cout << "Aprobado";
                escribir_caracter(' ', car_bloque - 8);
            } else {
                cout << "Suspenso";
                escribir_caracter(' ', car_bloque - 8);
            }
        }
        cout << endl;
    }
}
int main()
{
    T_Clase clase;
    leer_alumnos(clase);
    calcular_notas_medias(clase);
    emitir_informe(clase);
    return 0;
}