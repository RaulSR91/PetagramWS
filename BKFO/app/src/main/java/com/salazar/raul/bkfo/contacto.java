package com.salazar.raul.bkfo;
import com.salazar.raul.bkfo.email.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


public class contacto extends AppCompatActivity {

    EditText edNombreCompletoEmail,edCorreo,edMensaje;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar         = (Toolbar) findViewById(R.id.toolbar_Contacto);
        edNombreCompletoEmail   = (EditText) findViewById(R.id.edNombreCompletoEmail);
        edCorreo                = (EditText) findViewById(R.id.edCorreo);
        edMensaje               = (EditText) findViewById(R.id.edMensaje);


        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Contacto");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }




    }

    public void sendEmail(View v) {
        //Getting content for email
        String email =   edCorreo.getText().toString().trim();
        String subject = edNombreCompletoEmail.getText().toString().trim();
        String message = edMensaje.getText().toString().trim();

        //Creating SendMail object
        SendEmail sm = new SendEmail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}
