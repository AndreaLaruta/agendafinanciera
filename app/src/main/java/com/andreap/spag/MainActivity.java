package com.andreap.spag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andreap.spag.Presentacion.PMovimientoActivity;
import com.andreap.spag.Presentacion.PCuentaActivity;
import com.andreap.spag.Presentacion.PObjetivoActivity;
import com.andreap.spag.Presentacion.PPresupuestoActivity;
import com.andreap.spag.Presentacion.PRecordatorioActivity;

public class MainActivity extends AppCompatActivity{

    Button btn_cuenta, btn_movimiento, btn_objetivo, btn_presupuesto, btn_recordatorio;

    Intent nuevaVista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_cuenta = findViewById(R.id.button_cuenta);
        btn_movimiento = findViewById(R.id.button_movimiento);
        btn_objetivo = findViewById(R.id.button_objetivo);
        btn_presupuesto = findViewById(R.id.button_presupuesto);
        btn_recordatorio = findViewById(R.id.button_recordatorio);

        btn_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PCuentaActivity.class);
                    startActivity(nuevaVista);
            }
        });

        btn_movimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PMovimientoActivity.class);
                    startActivity(nuevaVista);
            }
        });

        btn_objetivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PObjetivoActivity.class);
                    startActivity(nuevaVista);
            }
        });

        btn_presupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PPresupuestoActivity.class);
                    startActivity(nuevaVista);
            }
        });

        btn_recordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PRecordatorioActivity.class);
                    startActivity(nuevaVista);
            }
        });

        //GENERANDO MIS LISTENERS WHEN I DO ONCLICK JIJI


        btn_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PCuentaActivity.class);
                    startActivity(nuevaVista);
            }
        });

        btn_movimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PMovimientoActivity.class);
                    startActivity(nuevaVista);
            }
        });

        btn_objetivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PObjetivoActivity.class);
                    startActivity(nuevaVista);
            }
        });

        btn_presupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PPresupuestoActivity.class);
                    startActivity(nuevaVista);
            }
        });

        btn_recordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    nuevaVista=new Intent(MainActivity.this, PRecordatorioActivity.class);
                    startActivity(nuevaVista);
            }
        });

    }

}