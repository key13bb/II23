#include <iostream>

using namespace std;

int main()
{

    cout << endl
         << "Iniciado" << endl;

    char operacion;
    int op1, op2, res;

    cout << "Operacion: ";
    cin >> operacion;

    while (operacion != '&') {
        if ((operacion != '+') && (operacion != '-') && (operacion != '*') && (operacion != '/'))
            throw runtime_error("Operacion no existente");
        else {
            cout << "Operando 1: ";
            cin >> op1;
            cout << "Operando 2: ";
            cin >> op2;

            if ((operacion == '/') && (op2 == 0))
                throw runtime_error("No se puede dividir por 0");
            else {
                cout << "Resultado: ";
                switch (operacion) {
                case '+':
                    res = (op1 + op2);
                    break;
                case '-':
                    res = (op1 - op2);
                    break;
                case '*':
                    res = (op1 * op2);
                    break;
                case '/':
                    res = (op1 / op2);
                    break;
                }
                cout << res;
            }
        }

        cout << endl
             << "Operacion: ";
        cin >> operacion;
    }
    cout << "FIN DEL PROGRAMA";
}