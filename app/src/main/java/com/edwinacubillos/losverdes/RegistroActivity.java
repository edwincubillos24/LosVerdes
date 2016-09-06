package com.edwinacubillos.losverdes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    Button bAceptar, bCancelar;
    EditText eRUsuario, eRContrasena, eRRContrasena, eCorreoE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        bAceptar = (Button) findViewById(R.id.bAceptar);
        bCancelar = (Button) findViewById(R.id.bCancelar);
        eRUsuario = (EditText) findViewById(R.id.eRUsuario);
        eRContrasena = (EditText) findViewById(R.id.eRContrasena);
        eRRContrasena = (EditText) findViewById(R.id.eRRContrasena);
        eCorreoE = (EditText) findViewById(R.id.eCorreoE);

        bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        /*        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("usuario",eRUsuario.getText().toString());
                intent.putExtra("contrasena",eRContrasena.getText().toString());
                startActivity(intent);*/

                Intent intent = new Intent();
                intent.putExtra("usuario",eRUsuario.getText().toString());
                intent.putExtra("contrasena",eRContrasena.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
    }
}
