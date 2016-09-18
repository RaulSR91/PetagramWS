package com.salazar.raul.bkfo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.salazar.raul.bkfo.adapter.PageAdpter;
import com.salazar.raul.bkfo.vista_activity.configurar_cuenta;
import com.salazar.raul.bkfo.vista_fragment.PerfilMascota;
import com.salazar.raul.bkfo.vista_fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final ArrayList<Fragment> ListadoFragments = new ArrayList<>();


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar     = (Toolbar)   findViewById(R.id.toolbar);
        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);

        toolbar = (Toolbar) findViewById(R.id.toolbarPrincipal);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }
        this.setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragment(){
        ListadoFragments.add(new RecyclerViewFragment());
        ListadoFragments.add(new PerfilMascota());
        return ListadoFragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdpter(getSupportFragmentManager(),this.agregarFragment()));
        //Se agrega al tabLayout
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case  R.id.mContacto:
                Intent contacto = new Intent(MainActivity.this,contacto.class);
                startActivity(contacto);
                break;

            case R.id.mAbout:

                Intent acercaDe = new Intent(MainActivity.this,AcercaDe.class);
                startActivity(acercaDe);
                break;

            case R.id.mEstrella:
                Intent top5 = new Intent(MainActivity.this, com.salazar.raul.bkfo.vista_activity.top5.class);
               startActivity(top5);
                break;

            case R.id.mConfiguracion:
                Intent config = new Intent(MainActivity.this, configurar_cuenta.class);
                startActivity(config);
                break;


        }

        return super.onOptionsItemSelected(item);
    }



   
    
}
