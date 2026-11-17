package com.example.act1_uni3;

public class Calculadora implements ICalculadora{

    // Metodo auxiliar para validar si alguno de los operandos es NaN
    private boolean hayNaN(double a, double b) {
        return Double.isNaN(a) || Double.isNaN(b);
    }
    @Override
    public double sumar(double a, double b) {
        if (hayNaN(a, b)) {
            return Double.NaN;
        }
        return a + b;
    }
    @Override
    public double restar(double a, double b) {
        if (hayNaN(a, b)) {
            return Double.NaN;
        }
        return a - b;
    }
    @Override
    public double multiplicar(double a, double b) {
        if (hayNaN(a, b)) {
            return Double.NaN;
        }
        return a * b;
    }
    @Override
    public double dividir(double a, double b) {
        if (hayNaN(a, b) || b == 0.0) {
            return Double.NaN;
        }
        return a / b;
    }
}
