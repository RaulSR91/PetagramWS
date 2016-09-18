package com.salazar.raul.bkfo.vista_fragment;

import com.salazar.raul.bkfo.adapter.MascotaAdaptador;
import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.pojo.Usuarios;
import com.salazar.raul.bkfo.pojo.Usuarios2;

import java.util.ArrayList;

/**
 * Created by rsalazarr on 05/09/2016.
 */
public interface IPerfilMascota {

    public MascotaAdaptador CrearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador mascota);

    public void generarLinearLayoutVertical();

    public void generarGridLayout();

    public void asignarFotoPerfil(ArrayList<Usuarios2> usuarios2);

}
