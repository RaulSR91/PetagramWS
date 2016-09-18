package com.salazar.raul.bkfo.pojo;

/**
 * Created by Spartan117 on 10/07/2016.
 */
public class Mascotas {

    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int likes = 0;

    public Mascotas(String urlFoto, String nombreCompleto, String telefono, String email, int likes) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }

    public Mascotas() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }







}
