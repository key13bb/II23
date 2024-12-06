#include <iostream>

using namespace std;

bool es_primo(int n) {
    int i=2;
    bool found = true;
    while (i<n && found==true) {
        int j=2;
        while (j<n && found==true) {
            if (n==i*j) {
                found = false;
            }
            j++;
        }
        i++;
    }
    return found;
}

int main() {

    int n;
    cout << "Introduce un numero: ";
    cin >> n;

    for(int i=2; i<n; i++) {
        if(es_primo(i)) {
            cout << i << ", ";
        }
    }

}
