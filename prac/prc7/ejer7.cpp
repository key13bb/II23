#include <array>
#include <iostream>

using namespace std;

const int N = 5;
const int NUM_VALORES = N * N;

typedef array<int, N> TFila;
typedef array<TFila, N> TMatriz;

void incrementar(int& v)
{
    v = (v + 1) % N;
}
void decrementar(int& v)
{
    v = (v - 1 + N) % N;
}
void siguienteCoordenada(const TMatriz& m, int& x, int& y)
{
    decrementar(x);
    decrementar(y);
    if (m[x][y] != 0) {
        incrementar(y);
        incrementar(x);
        incrementar(x);
    }
}
void construirMagico(TMatriz& m)
{
    int x = 0, y = N / 2;
    m = { {} };
    m[0][N / 2] = 1;
    for (int i = 2; i <= NUM_VALORES; i++) {
        siguienteCoordenada(m, x, y);
        m[x][y] = i;
    }
}
void escribirMagico(const TMatriz& m)
{
    for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
            cout << m[x][y] << ' ';
        }
        cout << endl;
    }
}
int main()
{
    TMatriz m;
    construirMagico(m);
    escribirMagico(m);
    return 0;
}