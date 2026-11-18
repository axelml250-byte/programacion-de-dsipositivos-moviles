package com.example.act2_uni5;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CaloriasElfosLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcularMayorCalorias();
    }

    private void calcularMayorCalorias() {
        long maxCalorias = 0;
        long caloriasElfoActual = 0;
        int numeroElfoActual = 1;
        int elfoConMasCalorias = 1;

        try {
            InputStream is = getAssets().open("input-M5-02.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String linea;

            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();

                if (linea.isEmpty()) {
                    // Línea en blanco: termina el inventario del elfo actual
                    if (caloriasElfoActual > maxCalorias) {
                        maxCalorias = caloriasElfoActual;
                        elfoConMasCalorias = numeroElfoActual;
                    }
                    // Reiniciar acumulador para el siguiente elfo
                    caloriasElfoActual = 0;
                    numeroElfoActual++;
                } else {
                    // Sumar calorías del alimento actual
                    caloriasElfoActual += Long.parseLong(linea);
                }
            }

            // Verificar al último elfo en caso de que el archivo no termine con línea en blanco
            if (caloriasElfoActual > maxCalorias) {
                maxCalorias = caloriasElfoActual;
                elfoConMasCalorias = numeroElfoActual;
            }

            reader.close();

            // Imprimir resultados en Logcat
            Log.d(TAG, "=== CONTEO DE CALORÍAS DE LOS ELFOS ===");
            Log.d(TAG, "Total de elfos evaluados: " + numeroElfoActual);
            Log.d(TAG, "Elfo que lleva más calorías: Elfo #" + elfoConMasCalorias);
            Log.i(TAG, "RESPUESTA -> Calorías totales máximas: " + maxCalorias);

        } catch (IOException e) {
            Log.e(TAG, "Error al leer el archivo input-M5-02.txt: " + e.getMessage());
        } catch (NumberFormatException e) {
            Log.e(TAG, "Error de formato numérico en el archivo: " + e.getMessage());
        }
    }
}