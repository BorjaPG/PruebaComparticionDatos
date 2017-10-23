package com.bp.pruebacomparticiondatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainEmisor extends AppCompatActivity {

    private EditText shareSubject;
    private EditText shareMessage;
    private Button shareBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emisor_main);

        shareSubject = (EditText) findViewById(R.id.shareSubject);
        shareMessage = (EditText) findViewById(R.id.shareMessage);
        shareBtn = (Button) findViewById(R.id.shareBtn);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Declaración del intent. ACTION_SEND indica que el intent es para
                enviar datos. */
                Intent intent=new Intent(android.content.Intent.ACTION_SEND);
                /* Tipo de los datos a enviar. Si no se conoce usar '/' */
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, shareMessage.getText().toString());
                /* Se crea un chooser que permita al usuario elegir con que app compartir
                * los datos. */
                startActivity(Intent.createChooser(intent, getResources().getString(R.string.shareData)));
            }
        });

    }
}
