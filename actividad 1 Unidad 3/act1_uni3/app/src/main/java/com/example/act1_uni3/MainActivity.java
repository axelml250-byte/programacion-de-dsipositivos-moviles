package com.example.act1_uni3;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CalculadoraLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancia polimórfica usando la interfaz ICalculadora
        ICalculadora calc = new Calculadora();

        double num1 = 25.0;
        double num2 = 5.0;

        Log.d(TAG, "=== PRUEBA DE OPERACIONES BÁSICAS ===");
        imprimirResultado("Suma (" + num1 + " + " + num2 + ")", calc.sumar(num1, num2));
        imprimirResultado("Resta (" + num1 + " - " + num2 + ")", calc.restar(num1, num2));
        imprimirResultado("Multiplicación (" + num1 + " * " + num2 + ")", calc.multiplicar(num1, num2));
        imprimirResultado("División (" + num1 + " / " + num2 + ")", calc.dividir(num1, num2));

        Log.d(TAG, "=== VALIDACIÓN DE NaN ===");
        imprimirResultado("División indeterminada (0.0 / 0.0)", calc.dividir(0.0, 0.0));
        imprimirResultado("División entre cero (25.0 / 0.0)", calc.dividir(num1, 0.0));
        imprimirResultado("Suma con operando NaN (NaN + 5.0)", calc.sumar(Double.NaN, num2));
    }

    private void imprimirResultado(String operacion, double resultado) {
        if (Double.isNaN(resultado)) {
            Log.w(TAG, operacion + " -> Resultado inválido detectado: NaN (Not a Number)");
        } else {
            Log.d(TAG, operacion + " = " + resultado);
        }
    }
}