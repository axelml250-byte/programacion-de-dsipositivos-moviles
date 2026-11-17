package com.example.act1_uni4;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloVidaLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "1. onCreate(): La Activity ha sido creada e inicializada en memoria.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "2. onStart(): La Activity está a punto de hacerse visible para el usuario.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "3. onResume(): La Activity está en primer plano y lista para interactuar.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "4. onPause(): La Activity perdió el foco o está parcialmente oculta.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "5. onStop(): La Activity ya no es visible y pasó a segundo plano.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "6. onRestart(): La Activity vuelve a iniciar después de haber sido detenida.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "7. onDestroy(): La Activity está siendo destruida y liberada de memoria.");
    }
}