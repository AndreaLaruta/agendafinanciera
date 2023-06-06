package com.andreap.spag.Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.andreap.spag.conexion.ConexionSQLite;

import java.util.ArrayList;

public class DCuenta implements IDato{

    ConexionSQLite conexion;

    Long id, nro_cuenta;
    String nombre_cuenta, tipo_cuenta;
    Double saldo;

    public DCuenta(@Nullable Context context) {
        this.conexion = new ConexionSQLite(context);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNro_cuenta(Long nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void insert() {
        SQLiteDatabase db = conexion.getWritableDatabase();
         ContentValues insert = new ContentValues();
         insert.put("nombre_cuenta",nombre_cuenta);
         insert.put("numero_cuenta",nro_cuenta);
         insert.put("tipo_cuenta",tipo_cuenta);
         insert.put("saldo_cuenta",saldo);
         db.insert(conexion.table_Cuenta,null,insert);
    }

    @Override
    public void update() {
        SQLiteDatabase db = conexion.getWritableDatabase();

        String wher= "id = ?";
        String[] argWhere=new String[]{String.valueOf(id)};

        ContentValues update = new ContentValues();
        update.put("nombre_cuenta",nombre_cuenta);
        update.put("numero_cuenta",nro_cuenta);
        update.put("tipo_cuenta",tipo_cuenta);
        update.put("saldo_cuenta",saldo);
        db.update(conexion.table_Cuenta,update,wher,argWhere);
    }

    @Override
    public void delete() {
        SQLiteDatabase db = conexion.getWritableDatabase();

        String wher= "id = ?";
        String[] argWhere=new String[]{String.valueOf(id)};

        db.delete(conexion.table_Cuenta,wher,argWhere);
    }

    @Override
    public ArrayList<String> select() {
        SQLiteDatabase db = conexion.getWritableDatabase();

        String sql= "select * from "+conexion.table_Cuenta;

        ArrayList<String> lista= new ArrayList<>();
        String dato="";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToFirst()) {
            do {
                dato+=  String.valueOf(cursor.getInt(0)) +"\t";
                dato+=  cursor.getString(1) +"\t";
                dato+= String.valueOf(cursor.getInt(2))+"\t";
                dato+=  cursor.getString(3) +"\t";
                dato+= String.valueOf(cursor.getDouble(4))+"\t";
                lista.add(dato);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;

    }
}
