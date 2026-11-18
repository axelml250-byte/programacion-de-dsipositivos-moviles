package com.example.act1_uni5;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FibonacciLog";

    // Estructura HashMap para aplicar Memoization (almacena resultados previos)
    private final HashMap<Integer, Long> memo = new HashMap<>();

    // Contador de clics / posición actual 'n' en la secuencia
    private int nActual = 0;

    private TextView tvFibonacci;
    private TextView tvPosicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFibonacci = findViewById(R.id.tvFibonacci);
        tvPosicion = findViewById(R.id.tvPosicion);
        Button btnAvance = findViewById(R.id.btnAvance);
        Button btnRetroceso = findViewById(R.id.btnRetroceso);

        // Casos base precargados en memoization
        memo.put(0, 0L);
        memo.put(1, 1L);
        memo.put(2, 1L);

        // Botón Avance: incrementa n y calcula Fibonacci(n)
        btnAvance.setOnClickListener(v -> {
            nActual++;
            actualizarVista();
        });

        // Botón Retroceso: decrementa n (mínimo 1) y muestra Fibonacci(n)
        btnRetroceso.setOnClickListener(v -> {
            if (nActual > 1) {
                nActual--;
                actualizarVista();
            } else {
                Toast.makeText(this, "Ya estás en el inicio de la secuencia (n = 1)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void actualizarVista() {
        long resultado = calcularFibonacciMemo(nActual);
        tvPosicion.setText("Posición n = " + nActual);
        tvFibonacci.setText(String.valueOf(resultado));
        Log.d(TAG, "Clic #" + nActual + " -> Fibonacci(" + nActual + ") = " + resultado + " | Caché size: " + memo.size());
    }

    // Método recursivo con Memoization
    private long calcularFibonacciMemo(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Si el valor ya fue calculado previamente, se recupera directo de memoria
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Cálculo recursivo y almacenamiento en el mapa (memoization)
        long valor = calcularFibonacciMemo(n - 1) + calcularFibonacciMemo(n - 2);
        memo.put(n, valor);
        return valor;
    }
}