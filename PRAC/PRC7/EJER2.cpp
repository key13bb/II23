#include <array>
#include <iostream>

using namespace std;

const int N = 4;
typedef array<array<int, N>, N> Matriz;

int main()
{
    bool simetrica = true;
    Matriz m;
    cout << "Introduce por filas una matriz " << N << "x" << N << ": " << endl;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> m[i][j];
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (m[i][j] != m[j][i]) {
                simetrica = false;
            }
        }
    }
    if (simetrica) {
        cout << "SI es simétrica" << endl;
    } else {
        cout << "NO es simétrica" << endl;
    }
}