package com.bp.pruebacomparticiondatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainReceptor extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receptor_main);

        //Recupera el intent.
        final Intent intent = getIntent();
        //Recupera la acción del intent.
        final String action = intent.getAction();
        //Obtiene su tipo de datos.
        final String type = intent.getType();

        final String text = "text/plain";

        /* Comprueba que la acción se corresponde con una compartición
        * de datos... */
        if (action.equals(Intent.ACTION_SEND)) {
            /* ... y que el tipo es el esperado. */
            if (text.equals(type)) {
                //Obtiene la cadena de caracteres compartida.
                String sharedUrl = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (sharedUrl != null)
                    Toast.makeText(this, sharedUrl, Toast.LENGTH_LONG).show();
            }
        }
    }
}
