#include<iostream>
#include<cmath>
using namespace std;

class Complex {
    float real, imag;
public:
    Complex(float r=0, float i=0): real(r), imag(i){}

    Complex add(Complex c) {
        return Complex(real+c.real, imag+c.imag);
    }

    Complex subtract(Complex c) {
        return Complex(real-c.real, imag-c.imag);
    }

    Complex multiply(Complex c) {
        return Complex(real*c.real-imag*c.imag, real*c.imag+imag*c.real);
    }

    Complex divide(Complex c) {
        float d = c.real*c.real + c.imag*c.imag;
        return Complex((real*c.real+imag*c.imag)/d, (imag*c.real-real*c.imag)/d);
    }

    Complex conjugate() {
        return Complex(real, -imag);
    }

    void display() {
        cout << real << (imag>=0 ? "+" : "") << imag << "i" << endl;
    }
};

int main() {
    Complex c1(3, 4), c2(1, -2);

    cout << "c1="; c1.display();
    cout << "c2="; c2.display();
    cout << "Add:     "; c1.add(c2).display();
    cout << "Sub:     "; c1.subtract(c2).display();
    cout << "Mul:     "; c1.multiply(c2).display();
    cout << "Div:     "; c1.divide(c2).display();
    cout << "Conj c1: "; c1.conjugate().display();

    return 0;
}
