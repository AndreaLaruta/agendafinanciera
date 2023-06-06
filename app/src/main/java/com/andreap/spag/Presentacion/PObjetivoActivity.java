package com.andreap.spag.Presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.andreap.spag.Negocio.NCuenta;
import com.andreap.spag.Negocio.NObjetivo;
import com.andreap.spag.R;

public class PObjetivoActivity extends AppCompatActivity implements IPresentacion{

    NObjetivo negocio;
    NCuenta cuenta;
    
    String nombre, descripcion;
    Long id_cuenta, id;
    Double monto;

    EditText txtid, txtnombre, txtmonto, txtdescripcion, txtcuentas;
    Button btninsertar,btneditar,btneliminar;
    Spinner cuenta_objetivo;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivo);

        btninsertar = findViewById(R.id.button_insertar);
        btneditar = findViewById(R.id.button_editar);
        btneliminar = findViewById(R.id.button_eliminar);

        txtid = findViewById(R.id.text_input_ID);
        txtnombre = findViewById(R.id.text_input_objetivo);
        txtmonto = findViewById(R.id.text_input_precio);
        txtcuentas = findViewById(R.id.spinner_cuenta_objetivos);
        txtdescripcion = findViewById(R.id.text_input_descripcion);

        btninsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { insertar();          }
        });
        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { editar();          }
        });
        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { eliminar();          }
        });


    }

    @Override
    public void insertar() {
        cargarDatos();
        negocio.insert(nombre, descripcion, monto, id_cuenta);
        limpiarDatos();
        listar();
    }

    private void limpiarDatos() {
        txtid.setText("");
        txtnombre.setText("");
        txtdescripcion.setText("");
        txtmonto.setText("");
        txtcuentas.setText("");
    }

    private void cargarDatos() {
        id = Long.valueOf(txtid.getText().toString());
        nombre = txtnombre.getText().toString();
        descripcion = txtdescripcion.getText().toString();
        monto = Double.valueOf(txtmonto.getText().toString());
        id_cuenta = Long.valueOf(txtcuentas.getText().toString());
    }

    @Override
    public void editar() {
        cargarDatos();
        negocio.update(id, nombre, descripcion, monto,id_cuenta);
        limpiarDatos();
        listar();
    }

    @Override
    public void eliminar() {
        cargarDatos();
        negocio.delete(id);
        limpiarDatos();
        listar();
    }

    @Override
    public void listar() {

    }
}