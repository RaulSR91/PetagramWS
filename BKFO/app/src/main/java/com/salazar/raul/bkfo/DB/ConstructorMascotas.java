package com.salazar.raul.bkfo.DB;

import android.content.ContentValues;
import android.content.Context;

import com.salazar.raul.bkfo.R;
import com.salazar.raul.bkfo.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Spartan117 on 25/07/2016.
 */
public class ConstructorMascotas {

    private static final int LIKE = 1; ;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }



    /* TOP 5*/
    public  ArrayList<Mascotas> obtenerTop5(){
        BaseDatos db = new BaseDatos(context);
        return db.ObtenerMascotasTop5();
    }


    public ArrayList<Mascotas> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        this.insertarMascotas(db);
        return db.ObtenerTodosLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"UNO");
        contentValues.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato1);

       ContentValues contentValues2 = new ContentValues();
        contentValues2.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"DOS");
        contentValues2.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gatos2);

        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"TRES");
        contentValues3.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato3);


        ContentValues contentValues4 = new ContentValues();
        contentValues4.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"CUATRO");
        contentValues4.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato4);

        ContentValues contentValues5 = new ContentValues();
        contentValues5.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"CINCO");
        contentValues5.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato5);


        ContentValues contentValues6 = new ContentValues();
        contentValues6.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"SEIS");
        contentValues6.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato6);

        ContentValues contentValues7 = new ContentValues();
        contentValues7.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"SIETE");
        contentValues7.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato7);


        ContentValues contentValues8 = new ContentValues();
        contentValues8.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"OCHO");
        contentValues8.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato8);

        ContentValues contentValues9 = new ContentValues();
        contentValues9.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"NUEVE");
        contentValues9.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato9);

        ContentValues contentValues10 = new ContentValues();
        contentValues10.put(ConfigDB.TABLE_MASCOTAS_NOMBRE,"DIEZ");
        contentValues10.put(ConfigDB.TABLE_MASCOTAS_FOTO, R.drawable.gato10);

        db.insertarMascotas(contentValues);
        db.insertarMascotas(contentValues2);
        db.insertarMascotas(contentValues3);
        db.insertarMascotas(contentValues4);
        db.insertarMascotas(contentValues5);
        db.insertarMascotas(contentValues6);
        db.insertarMascotas(contentValues7);
        db.insertarMascotas(contentValues8);
        db.insertarMascotas(contentValues9);
        db.insertarMascotas(contentValues10);
        db.close();
    }


    public void darLikeMascota(Mascotas mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConfigDB.TABLE_LIKES_ID_MASCOTA,mascota.getId());
        contentValues.put(ConfigDB.TABLE_LIKES_NUMERO_LIKES,LIKE);
        db.insertarLikeMascota(contentValues);
    }


    public int devolverLikesMascota(Mascotas mascota){
        BaseDatos bd = new BaseDatos(context);
        return  bd.obtenerLikesMascota(mascota);
    }
}
