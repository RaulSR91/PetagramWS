package com.salazar.raul.bkfo.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.salazar.raul.bkfo.DB.ConstructorMascotas;
import com.salazar.raul.bkfo.MainActivity;
import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Spartan117 on 10/07/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewgridmascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder MascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);

        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.gato)
                .into(MascotaViewHolder.imgFotoCV);

        MascotaViewHolder.tvRatingCV.setText(Integer.toString(mascota.getLikes())+" Likes");

       /*Boton de likes comentado
        MascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);

                MascotaViewHolder.tvRatingCV.setText(constructorMascotas.devolverLikesMascota(mascota)+" Likes");

                Toast.makeText(activity,"Te ha gustado : "+mascota.getNombre(),Toast.LENGTH_SHORT).show();

            }
        });
        */

    }

    @Override
    public int getItemCount() {
        try {
            return mascotas.size();
        }
        catch (Exception E){

            E.printStackTrace();
            return 0;
        }

    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView   imgFotoCV;
        private TextView    tvNombreCV;
        private TextView    tvRatingCV;
        private ImageButton btnLikeCV;
        private ImageButton btnRatingCV;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV       = (ImageView)   itemView.findViewById(R.id.imgFotoCV);
           // tvNombreCV      = (TextView)    itemView.findViewById(R.id.tvNombreCV);
           // btnLikeCV       = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            tvRatingCV      = (TextView)    itemView.findViewById(R.id.tvRatingCV);
        }
    }



}
