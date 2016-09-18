package com.salazar.raul.bkfo.restApi.model;

import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.pojo.Usuarios;

import java.util.ArrayList;

/**
 * Created by Spartan117 on 05/09/2016.
 */
public class UserResponse {

    ArrayList<Usuarios> usuarios;

    public ArrayList<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }
}
