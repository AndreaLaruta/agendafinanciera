package com.andreap.spag.Negocio;

import android.content.Context;

import androidx.annotation.Nullable;

import com.andreap.spag.Datos.DCuenta;

import java.util.ArrayList;

public class NCuenta{

    DCuenta dato;

    public NCuenta(@Nullable Context context) {
        this.dato = new DCuenta(context);
    }

    public void insert(String nombre, Long nro_cuenta, String tipo_cuenta, Double saldo) {
        dato.setNombre_cuenta(nombre);
        dato.setNro_cuenta(nro_cuenta);
        dato.setTipo_cuenta(tipo_cuenta);
        dato.setSaldo(saldo);

        dato.insert();
    }

    public void update(Long id, String nombre, Long nro_cuenta, String tipo_cuenta, Double saldo) {
        dato.setId(id);
        dato.setNombre_cuenta(nombre);
        dato.setNro_cuenta(nro_cuenta);
        dato.setTipo_cuenta(tipo_cuenta);
        dato.setSaldo(saldo);

        dato.update();
    }

    public void delete(Long id) {
        dato.setId(id);
        dato.delete();
    }

    public ArrayList<String> select() {
        return dato.select();
    }
}
