package com.salazar.raul.bkfo.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.salazar.raul.bkfo.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by Spartan117 on 25/07/2016.
 */
public class BaseDatos extends SQLiteOpenHelper{
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConfigDB.DATABASE_NAME, null, ConfigDB.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CrearTablaMascotas = "CREATE TABLE " + ConfigDB.TABLE_MASCOTAS +"(" +
                ConfigDB.TABLE_MASCOTAS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , " +
                ConfigDB.TABLE_MASCOTAS_NOMBRE + " TEXT , "+
                ConfigDB.TABLE_MASCOTAS_FOTO+" INTEGER "+
                ")";

        String CrearTablaLikesMascota = "CREATE TABLE "+ConfigDB.TABLE_LIKES_MASCOTA + "(" +
                ConfigDB.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                ConfigDB.TABLE_LIKES_ID_MASCOTA + " INTEGER , "+
                ConfigDB.TABLE_LIKES_NUMERO_LIKES+ " INTEGER , "+
                " FOREIGN KEY (" + ConfigDB.TABLE_LIKES_ID_MASCOTA+ ") "  +
                " REFERENCES  "+ConfigDB.TABLE_MASCOTAS+ " ("+ConfigDB.TABLE_MASCOTAS_ID+") "+
                ")";
        db.execSQL(CrearTablaMascotas);
        db.execSQL(CrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConfigDB.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConfigDB.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }


    public ArrayList<Mascotas> ObtenerTodosLasMascotas(){
        ArrayList<Mascotas> mascotas  = new ArrayList<>();

        String consulta ="SELECT * FROM "+ConfigDB.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(consulta,null);

//        while (registros.moveToNext()){
//
//
//            Mascotas mascotaActual = new Mascotas();
//            mascotaActual.setId(registros.getInt(0));
//            mascotaActual.setNombre(registros.getString(1));
//            mascotaActual.setFoto(registros.getInt(2));
//
//            String queryLikes = "SELECT COUNT("+ConfigDB.TABLE_LIKES_NUMERO_LIKES+") AS likes" +
//                    " FROM "+ConfigDB.TABLE_LIKES_MASCOTA+" " +
//                    " WHERE "+ConfigDB.TABLE_LIKES_ID_MASCOTA+" = '"+mascotaActual.getId()+"'";
//
//            Cursor registrosLikes = db.rawQuery(queryLikes,null);
//            if(registrosLikes.moveToNext()){
//                mascotaActual.setRating(registrosLikes.getInt(0));
//            }
//            else{
//                mascotaActual.setRating(0);
//            }
//
//            mascotas.add(mascotaActual);
//        }
        db.close();
        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConfigDB.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConfigDB.TABLE_LIKES_MASCOTA,null,contentValues);
        db.close();
    }


    public int obtenerLikesMascota(Mascotas mascota){
        int likes = 0;

        String consulta = " SELECT COUNT("+ ConfigDB.TABLE_LIKES_NUMERO_LIKES +") " +
                " FROM "+ ConfigDB.TABLE_LIKES_MASCOTA +" " +
                " WHERE "+ ConfigDB.TABLE_LIKES_ID_MASCOTA +" = '"+mascota.getId() +"' ";

        SQLiteDatabase db = getWritableDatabase();
        Cursor registros = db.rawQuery(consulta,null);

        /*Utilizo if y no while debido a que es un único registro*/
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes ;
    }


    /*Obtener top 5*/
    public ArrayList<Mascotas> ObtenerMascotasTop5(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String ConsultaTop5 = "SELECT mascotas.*,likes.likes AS likes FROM\n" +
                "    (SELECT * FROM "+ConfigDB.TABLE_MASCOTAS+")AS mascotas\n" +
                "    INNER JOIN\n" +
                "    (\n" +
                "    SELECT "+ConfigDB.TABLE_LIKES_ID_MASCOTA+", COUNT("+ConfigDB.TABLE_LIKES_NUMERO_LIKES+")  AS likes\n" +
                "    FROM "+ConfigDB.TABLE_LIKES_MASCOTA+"\n" +
                "    GROUP BY  "+ConfigDB.TABLE_LIKES_ID_MASCOTA+"\n" +
                "    ORDER BY likes  DESC\n" +
                "    LIMIT 5\n" +
                "   )AS likes \n" +
                "ON mascotas."+ConfigDB.TABLE_MASCOTAS_ID+" = likes."+ConfigDB.TABLE_LIKES_ID_MASCOTA+"\n" +
                "ORDER BY likes  DESC, "+ConfigDB.TABLE_MASCOTAS_NOMBRE+"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(ConsultaTop5,null);

//        while (registros.moveToNext()){
//            Mascotas mascotaActual = new Mascotas();
//            mascotaActual.setId(registros.getInt(0));
//            mascotaActual.setNombre(registros.getString(1));
//            mascotaActual.setFoto(registros.getInt(2));
//            mascotaActual.setRating(registros.getInt(3));
//            mascotas.add(mascotaActual);
//        }
        db.close();
        return mascotas;
    }

}
