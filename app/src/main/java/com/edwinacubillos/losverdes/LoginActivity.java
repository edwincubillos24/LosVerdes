package com.edwinacubillos.losverdes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bRegistro, bEntrar;
    EditText eContrasena, eUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bRegistro = (Button) findViewById(R.id.bRegistro);
        bEntrar = (Button) findViewById(R.id.bEntrar);
        eContrasena = (EditText)findViewById(R.id.eContrasena);
        eUsuario = (EditText) findViewById(R.id.eUsuario);

      /*  Bundle extras = getIntent().getExtras();

        String user = extras.getString("usuario");
        String contrasena = extras.getString("contrasena");

        Toast.makeText(this, "user: "+user+" contrasena: "+contrasena,Toast.LENGTH_SHORT).show();
*************/

        bRegistro.setOnClickListener(this);
        bEntrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.bRegistro:
                    Intent intent = new Intent(this, RegistroActivity.class);
                    startActivityForResult(intent,1234);
                break;
            case R.id.bEntrar:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK){
            String user = data.getExtras().getString("usuario");
            String contrasena = data.getExtras().getString("contrasena");
            Log.d("user",user);
            Log.d("contraseña",contrasena);
            //Toast.makeText(this, "user: "+user+" contrasena: "+contrasena,Toast.LENGTH_SHORT).show();
        }
        if (requestCode==1234 && resultCode == RESULT_CANCELED){
            Log.d("mensaje","no se cargaron datos");
        }
    }
}
