package com.salazar.raul.bkfo.presenter;

import android.content.Context;

import com.salazar.raul.bkfo.DB.ConstructorMascotas;
import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.vista_activity.Itop5;
import com.salazar.raul.bkfo.vista_fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by Spartan117 on 26/07/2016.
 */
public class Top5ActivityPresenter implements Itop5ActivityPresenter{

    private Itop5 itop5;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;
    private Context context;


    public  Top5ActivityPresenter(Itop5 itop5, Context context ){
        this.itop5 = itop5;
        this.context = context;
        this.obtenerMascotasBaseDatosTop5();
    }



    @Override
    public void obtenerMascotasBaseDatosTop5() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerTop5();
        this.mostrarMascotasRVTop5();
    }

    @Override
    public void mostrarMascotasRVTop5() {
        itop5.inicializarAdaptadorRVTop5(itop5.CrearAdaptador(mascotas));
        itop5.generarLinearLayoutVerticalTop5();
    }
}
