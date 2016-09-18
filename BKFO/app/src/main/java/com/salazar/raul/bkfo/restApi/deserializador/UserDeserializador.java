package com.salazar.raul.bkfo.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.salazar.raul.bkfo.pojo.Usuarios;
import com.salazar.raul.bkfo.restApi.JsonKeys;
import com.salazar.raul.bkfo.restApi.model.UserResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Spartan117 on 05/09/2016.
 */
public class UserDeserializador implements JsonDeserializer<UserResponse>{

    @Override
    public UserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UserResponse userResponse = gson.fromJson(json, UserResponse.class);
        JsonArray userResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        userResponse.setUsuarios(deserializarUsuarioDeJson(userResponseData));
        return userResponse;
    }

    private ArrayList<Usuarios> deserializarUsuarioDeJson(JsonArray usuariosResponseData){
        /*ArrayList que regresará*/
        ArrayList<Usuarios> arrayUsuarios = new ArrayList<>();

        for (int i = 0; i < usuariosResponseData.size() ; i++) {
            /*Obtiene todo el json en la pocisión indicada*/
            JsonObject usuariosResponseDataObject = usuariosResponseData.get(i).getAsJsonObject();

           // JsonArray jsonArray = usuariosResponseDataObject.getAsJsonArray();
            String id               =  usuariosResponseDataObject.get(JsonKeys.USER_ID).toString();
            String profile_picture  =  usuariosResponseDataObject.get(JsonKeys.PROFILE_PICTURE).toString();
            String nombre           =  usuariosResponseDataObject.get(JsonKeys.USERNAME).toString();
            Usuarios usuarioActual = new Usuarios();
            usuarioActual.setId(id);
            usuarioActual.setProfile_picture(profile_picture);
            usuarioActual.setNombre(nombre);

            /*Agrega la usuario actual al ArrayList*/
            arrayUsuarios.add(usuarioActual);
        }
        return arrayUsuarios;
    }


}
