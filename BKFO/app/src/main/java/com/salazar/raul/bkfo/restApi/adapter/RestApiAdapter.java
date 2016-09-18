package com.salazar.raul.bkfo.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salazar.raul.bkfo.restApi.ConstantesRestApi;
import com.salazar.raul.bkfo.restApi.EndPointsApi;
import com.salazar.raul.bkfo.restApi.deserializador.MascotaDeserializador;
import com.salazar.raul.bkfo.restApi.deserializador.UserDeserializador;
import com.salazar.raul.bkfo.restApi.deserializador.UserDeserializador2;
import com.salazar.raul.bkfo.restApi.model.MascotaResponse;
import com.salazar.raul.bkfo.restApi.model.UserResponse;
import com.salazar.raul.bkfo.restApi.model.UserResponse2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rsalazarr on 05/09/2016.
 */
public class RestApiAdapter {

    /*Regresa endpointsApi*/
    public EndPointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndPointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaDeserializador());
        return gsonBuilder.create();
    }


    public Gson ConstruyeGsonInfoUsuario(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserResponse2.class,new UserDeserializador2());
        return gsonBuilder.create();
    }




}
