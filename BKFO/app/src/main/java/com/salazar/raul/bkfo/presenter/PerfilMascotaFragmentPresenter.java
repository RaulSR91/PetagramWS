package com.salazar.raul.bkfo.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.IpPrefix;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.salazar.raul.bkfo.DB.ConstructorMascotas;
import com.salazar.raul.bkfo.R;
import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.pojo.Usuarios;
import com.salazar.raul.bkfo.pojo.Usuarios2;
import com.salazar.raul.bkfo.restApi.ConstantesRestApi;
import com.salazar.raul.bkfo.restApi.EndPointsApi;
import com.salazar.raul.bkfo.restApi.adapter.RestApiAdapter;
import com.salazar.raul.bkfo.restApi.model.MascotaResponse;
import com.salazar.raul.bkfo.restApi.model.UserResponse2;
import com.salazar.raul.bkfo.vista_fragment.IPerfilMascota;
import com.salazar.raul.bkfo.vista_fragment.IRecyclerViewFragmentView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rsalazarr on 05/09/2016.
 */
public class PerfilMascotaFragmentPresenter implements IPerfilMascotaFragmentPresenter {
    private IPerfilMascota iPerfilMascota;/*Vista de Perfil Mascotas*/
    private ArrayList<Mascotas> mascotas;
    private ArrayList<Usuarios2> usuario;
    private Context context;
    //private String Id_Usuario_Media_Recent ="3691098682";
    private String Id_Usuario_Media_Recent ="";


    private String USUARIO_SANDBOX;


    public  PerfilMascotaFragmentPresenter(IPerfilMascota iPerfilMascota, Context context ){
        this.iPerfilMascota  = iPerfilMascota;
        this.context = context;

        this.CrearPreferenciaInstagram();
        this.obtenerIdUsuario();

    }



    @Override
    public void mostrarMascotasRV() {
        iPerfilMascota.inicializarAdaptadorRV(iPerfilMascota.CrearAdaptador(mascotas));
//        iRecyclerViewFragmentView.generarLinearLayoutVertical();
        iPerfilMascota.generarGridLayout();
    }

    public void mostrarUsuarios(ArrayList<Usuarios2> usuarios){
       iPerfilMascota.asignarFotoPerfil(usuarios);

    }

    @Override
    public void obtenerIdUsuario() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.ConstruyeGsonInfoUsuario();
        EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
       //Call<UserResponse2> userResponseCall = endpointsApi.getPerfilUsuario("jcma1979");
       Call<UserResponse2> userResponseCall = endpointsApi.getPerfilUsuario(this.USUARIO_SANDBOX);

        userResponseCall.enqueue(new Callback<UserResponse2>() {
            @Override
            public void onResponse(Call<UserResponse2> call, Response<UserResponse2> response) {
                try{
                    UserResponse2 userResponse = response.body();
                    usuario = userResponse.getUsuario2();
                    Id_Usuario_Media_Recent = usuario.get(0).getId().replace("\"","");
                    mostrarUsuarios(usuario);
                    obtenerMediosRecientes();
                }
                catch (IndexOutOfBoundsException e){
                    Toast.makeText(context, "Sin datos que mostrar", Toast.LENGTH_SHORT).show();
                   // CrearPreferenciaInstagram();
                }
                catch (NullPointerException r){
                    Toast.makeText(context, "Sin datos que mostrar", Toast.LENGTH_SHORT).show();
                    //CrearPreferenciaInstagram();
                }

            }

            @Override
            public void onFailure(Call<UserResponse2> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });


    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        //Call<MascotaResponse> contactoResponseCall = endpointsApi.getRecenteMediaUser("3812039633");

        Call<MascotaResponse> contactoResponseCall = endpointsApi.getRecenteMediaUser(""+Id_Usuario_Media_Recent+"");

        Log.d("id :::::: ", " VARIABLE GLOBAL: "+Id_Usuario_Media_Recent);



        contactoResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse contactoResponse = response.body();

                try {
                    mascotas = contactoResponse.getContactos();
                    mostrarMascotasRV();
                }catch (Exception e){

                    Log.d("ERROR DE CONTEDIDO : ",e.toString());
                }




            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }

    public void CrearPreferenciaInstagram(){
       /*Los datos ahora de manejan desde un webService*/

        SharedPreferences LeerPreferenciasCuentaInstagram =  context.getSharedPreferences("USUARIOINSTAGRAM",Context.MODE_PRIVATE);
        this.USUARIO_SANDBOX = LeerPreferenciasCuentaInstagram.getString("CuentaSandbox","");
    }



}
