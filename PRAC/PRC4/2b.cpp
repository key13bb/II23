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

    int i=0,j=2;
    while(i<n){
        if(es_primo(j)) {
            cout << j << ", ";
            i++;
        }
        j++;
    }

}
