package com.andreap.spag.conexion;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite extends SQLiteOpenHelper {

    public static final String dB_Name = "spag";
    public static final int dB_Version = 1;

    public static final String table_Cuenta  = "cuenta";
    public static final String table_Movimiento   = "movimiento";
    public static final String table_Objetivo   = "objetivo";
    public static final String table_Presupuesto   = "presupuesto";

    String query="";

    public ConexionSQLite(@Nullable Context context) {
        super(context, dB_Name, null, dB_Version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {


        query = "CREATE TABLE " + table_Cuenta + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nombre_cuenta String,"
                + "numero_cuenta INTEGER,"
                + "tipo_cuenta String,"
                + "saldo_cuenta Double)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_Cuenta);
        onCreate(db);

    }
}
