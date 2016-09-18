package com.salazar.raul.bkfo.vista_activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.salazar.raul.bkfo.MainActivity;
import com.salazar.raul.bkfo.R;

public class configurar_cuenta extends AppCompatActivity implements ConfigurarCuenta{
    private Button btnConfigurarUsuario;
   private TextView TvUsuarioInstagram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.configurar_cuenta);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_configuracion);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Configurar Cuenta");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        /*Casteo de variables*/
        btnConfigurarUsuario = (Button) findViewById(R.id.btnConfigurarUsuario);
        TvUsuarioInstagram   = (TextView) findViewById(R.id.TvUsuarioInstagram);

        btnConfigurarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarcuenta();
                //Toast.makeText(configurar_cuenta.this, "Hola has presionado el boton", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void asignarcuenta() {
        String UsuarioInstagram = TvUsuarioInstagram.getText().toString();

        if(UsuarioInstagram == ""){
            Toast.makeText(configurar_cuenta.this, "Debe Ingresar un nombre de usuario de Sandbox", Toast.LENGTH_LONG).show();
        }
        else{

            /*Crear preferencia Compartida*/

            SharedPreferences PreferenciasCuentaInstagram = getSharedPreferences("USUARIOINSTAGRAM", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = PreferenciasCuentaInstagram.edit();
            editor.putString("CuentaSandbox",UsuarioInstagram);
            editor.commit();

            Toast.makeText(configurar_cuenta.this, "Se ha cambiado la cuenta de Instagram por : "+UsuarioInstagram, Toast.LENGTH_SHORT).show();

            Intent configurarcuenta = new Intent(configurar_cuenta.this,MainActivity.class);
            startActivity(configurarcuenta);
            finish();
        }
    }
}
