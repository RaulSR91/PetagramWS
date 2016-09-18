package com.salazar.raul.bkfo.DB;

/**
 * Created by Spartan117 on 25/07/2016.
 */
public final class ConfigDB {

    public static final String  DATABASE_NAME       =   "mascotas";
    public static final int     DATABASE_VERSION    =   1;

    public static final String TABLE_MASCOTAS = "mascota";
    public static final String TABLE_MASCOTAS_ID = "id";
    public static final String TABLE_MASCOTAS_NOMBRE = "nombre";
    public static final String TABLE_MASCOTAS_FOTO = "foto";


    public static final String TABLE_LIKES_MASCOTA = "mascotas_likes";
    public static final String TABLE_LIKES_ID = "id";
    public static final String TABLE_LIKES_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_NUMERO_LIKES = "numero_likes";
}
