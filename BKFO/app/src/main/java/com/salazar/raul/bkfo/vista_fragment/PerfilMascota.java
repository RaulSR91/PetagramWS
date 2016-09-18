package com.salazar.raul.bkfo.vista_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.salazar.raul.bkfo.R;
import com.salazar.raul.bkfo.adapter.MascotaAdaptador;
import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.pojo.Usuarios;
import com.salazar.raul.bkfo.pojo.Usuarios2;
import com.salazar.raul.bkfo.presenter.IPerfilMascotaFragmentPresenter;
import com.salazar.raul.bkfo.presenter.IRecyclerViewFragmentPresenter;
import com.salazar.raul.bkfo.presenter.PerfilMascotaFragmentPresenter;
import com.salazar.raul.bkfo.presenter.RecyclerViewFragmentPresenter;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascota extends Fragment implements IPerfilMascota {

    ArrayList<Mascotas> mascotas;
    private RecyclerView fotosMascotas;
    private IPerfilMascotaFragmentPresenter presenter;

    private ImageView circular;

    private TextView tvNombreDetalleMascota;



    public PerfilMascota() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);
        //Lista que se va a llenar
        fotosMascotas  = (RecyclerView) v.findViewById(R.id.rvFotosMascotas);

        //Lista que se va a llenar
        fotosMascotas           = (RecyclerView) v.findViewById(R.id.rvFotosMascotas);
        presenter               = new PerfilMascotaFragmentPresenter( this , getContext());
        circular                = (ImageView)v.findViewById(R.id.CIMPerfil) ;
        tvNombreDetalleMascota  = (TextView) v.findViewById(R.id.tvNombreDetalleMascota);


          return v;

    }

    @Override
    public MascotaAdaptador CrearAdaptador(ArrayList<Mascotas> mascotas)
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        fotosMascotas.setAdapter(adaptador);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        fotosMascotas.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        fotosMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void asignarFotoPerfil(ArrayList<Usuarios2> usuarios2) {
        try {
            for (int i = 0; i < usuarios2.size(); i++) {


                Picasso.with(getActivity())
                        .load(usuarios2.get(i).getProfile_picture().replace("\"",""))
                        .into(circular);
                //tvNombreDetalleMascota.setText(usuarios.get(i).getId());
                tvNombreDetalleMascota.setText(usuarios2.get(i).getNombre().replace("\"",""));

                Log.d("URL DE LA IMGAEN ",usuarios2.get(i).getProfile_picture()+" Cargó? ");
            }
        }catch (NullPointerException e) {
        }

    }



}
