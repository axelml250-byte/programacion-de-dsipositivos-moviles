package com.example.act3_uni1;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Crear arreglo de 1 millón de elementos enteros aleatorios
        int tamano = 1000000;
        int[] arreglo = new int[tamano];
        Random random = new Random();

        for (int i = 0; i < tamano; i++) {
            arreglo[i] = random.nextInt(1000000); // Números aleatorios entre 0 y 999,999
        }

        // 2. Medir tiempo de inicio
        long tiempoInicio = System.currentTimeMillis();

        // 3. Ordenar los elementos
        Arrays.sort(arreglo);

        // 4. Medir tiempo de fin y calcular duración
        long tiempoFin = System.currentTimeMillis();
        long tiempoTotal = tiempoFin - tiempoInicio;

        // 5. Imprimir resultados en el Logcat
        Log.d("Actividad3Log", "Arreglo de " + tamano + " elementos ordenado exitosamente.");
        Log.d("Actividad3Log", "Primer elemento (menor): " + arreglo[0]);
        Log.d("Actividad3Log", "Último elemento (mayor): " + arreglo[tamano - 1]);
        Log.d("Actividad3Log", "Tiempo total de ordenamiento: " + tiempoTotal + " ms");
    }
}