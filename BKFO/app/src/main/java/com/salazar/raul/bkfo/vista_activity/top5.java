package com.salazar.raul.bkfo.vista_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.salazar.raul.bkfo.R;
import com.salazar.raul.bkfo.adapter.MascotaAdaptador;
import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.presenter.RecyclerViewFragmentPresenter;
import com.salazar.raul.bkfo.presenter.Top5ActivityPresenter;

import java.util.ArrayList;

public class top5 extends AppCompatActivity implements Itop5 {
    ArrayList<Mascotas> mascotasTop5;
    private RecyclerView listaMascotasTop5;
    Top5ActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarTop5);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Top 5 Mascotas");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        //Castear listaView
        listaMascotasTop5  = (RecyclerView)findViewById(R.id.rvMascotasTop5);
        presenter = new Top5ActivityPresenter(this,this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_top5,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mAbout:
                Toast.makeText(this,"Seleccionaste About ",Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public MascotaAdaptador CrearAdaptador(ArrayList<Mascotas> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRVTop5(MascotaAdaptador adaptador) {
        listaMascotasTop5.setAdapter(adaptador);
    }

    @Override
    public void generarLinearLayoutVerticalTop5() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasTop5.setLayoutManager(llm);
    }
}
