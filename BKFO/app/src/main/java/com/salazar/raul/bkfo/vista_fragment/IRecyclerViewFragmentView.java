package com.salazar.raul.bkfo.vista_fragment;

import com.salazar.raul.bkfo.adapter.MascotaAdaptador;
import com.salazar.raul.bkfo.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Spartan117 on 25/07/2016.
 */
public interface IRecyclerViewFragmentView {

    public MascotaAdaptador CrearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador mascota);

    public void generarLinearLayoutVertical();

    public void generarGridLayout();



}
