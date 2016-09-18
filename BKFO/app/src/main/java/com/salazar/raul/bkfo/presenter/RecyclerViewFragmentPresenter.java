package com.salazar.raul.bkfo.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.salazar.raul.bkfo.DB.ConstructorMascotas;
import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.restApi.EndPointsApi;
import com.salazar.raul.bkfo.restApi.adapter.RestApiAdapter;
import com.salazar.raul.bkfo.restApi.model.MascotaResponse;
import com.salazar.raul.bkfo.vista_fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Spartan117 on 25/07/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;
    private Context context;



    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context ){
        this.iRecyclerViewFragmentView  = iRecyclerViewFragmentView;
        this.context = context;
        /*Los datos ahora de manejan desde un webServices*/
       // this.obtenerMascotasBaseDatos();
        this.obtenerMediosRecientes();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);

        mascotas = constructorMascotas.obtenerDatos();




        this.mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.CrearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarGridLayout();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse contactoResponse = response.body();
                mascotas = contactoResponse.getContactos();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }
}
