package com.salazar.raul.bkfo.restApi.model;

import com.salazar.raul.bkfo.pojo.Mascotas;

import java.util.ArrayList;

/**
 * Created by rsalazarr on 05/09/2016.
 */
public class MascotaResponse {

        ArrayList<Mascotas> mascotas;

        public ArrayList<Mascotas> getContactos() {
            return mascotas;
        }

        public void setContactos(ArrayList<Mascotas> mascotas) {
            this.mascotas = mascotas;
        }


}
