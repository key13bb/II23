#include <iostream>

using namespace std;

int main() {
    int num, prov, opcode1, opcode2, control;
    cout << "Introduzca un numero de 4 digitos (el primero distinto de cero): ";
    cin >> num;

    if ((num < 1000)||(num > 9999)) {
        cout << "ERROR: CODIGO INVALIDO (no tiene 4 digitos)";
    } else {
        prov = num/1000;
        if (prov == 0) {
            cout << "ERROR: CODIGO INVALIDO (el primer numero es 0)";
        } else {
            opcode1 = num/100%10;
            opcode2 = num/10%10;
            control = num%10;

            if ((opcode1*10+opcode2)%prov != control) {
                cout << "ERROR: CODIGO INVALIDO (digito de control erroneo)";
            } else {
                cout << "PROVINCIA:             " << prov << endl;
                cout << "NUMERO DE OPERACION:   " << opcode1*10+opcode2 << endl;
                cout << "DIGITO DE CONTROL      " << control << endl;
            }
        }
    }
    return 0;
}
