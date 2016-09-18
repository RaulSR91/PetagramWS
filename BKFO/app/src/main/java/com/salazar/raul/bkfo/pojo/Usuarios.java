package com.salazar.raul.bkfo.pojo;

/**
 * Created by Spartan117 on 05/09/2016.
 */
public class Usuarios {

    private String id;
    private String profile_picture;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }
}
