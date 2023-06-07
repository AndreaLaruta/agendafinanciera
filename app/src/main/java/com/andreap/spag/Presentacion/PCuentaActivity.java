package com.andreap.spag.Presentacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.andreap.spag.MainActivity;
import com.andreap.spag.Negocio.NCuenta;
import com.andreap.spag.R;

import java.util.ArrayList;

public class PCuentaActivity extends AppCompatActivity implements IPresentacion{

    NCuenta negocio;

    String nombre,tipo_cuenta, txtBancoSp, txtTipoCuenta;
    Long id,nro_cuenta;
    Double  saldo;

    EditText txtcuenta;//sacar, ahora se hizo spinner
    EditText txtnrocuenta;
    EditText txttipocuenta;
    EditText txtsaldo;
    EditText txtid;
    Button btninsertar,btneditar,btneliminar;
    ListView lista;

    Spinner banco;
    Spinner tipoCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
        negocio = new NCuenta(PCuentaActivity.this);

        //
        btninsertar= findViewById(R.id.button_insertar);
        btneditar= findViewById(R.id.button_editar);
        btneliminar= findViewById(R.id.button_eliminar);

        txtnrocuenta = findViewById(R.id.text_input_nro_cuenta);
        txtsaldo = findViewById(R.id.input_saldo_cuenta);
        lista = findViewById(R.id.lista);

        banco = findViewById(R.id.banco_spinner);
        tipoCuenta = findViewById(R.id.tipoCuentaSpinner);

        listar();
        cargarSpinnerBanco();
        cargarSpinnerTipoCuenta();

        btninsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });
        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar();
            }
        });
        btneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar();
            }
        });
    }

    @Override
    public void insertar() {
        cargarDatos();
        negocio.insert(nombre, nro_cuenta,tipo_cuenta,saldo);
        limpiarDatos();
        listar();
    }

    private void limpiarDatos() {
        banco.setSelection(0);
        tipoCuenta.setSelection(0);
        txtcuenta.setText("");
        txtnrocuenta.setText("");
        txttipocuenta.setText("");
        txtsaldo.setText("");
    }

    private void cargarDatos() {
        nombre = txtcuenta.getText().toString();
        nro_cuenta = Long.valueOf(txtnrocuenta.getText().toString());
        tipo_cuenta = txttipocuenta.getText().toString();
        saldo = Double.valueOf(txtsaldo.getText().toString());
        id = Long.valueOf(txtid.getText().toString());
        txtBancoSp = banco.getSelectedItem().toString(); //obtengo dato de banco del spinner
        txtTipoCuenta = tipoCuenta.getSelectedItem().toString();
    }

    @Override
    public void editar() {
        cargarDatos();
        negocio.update(id, nombre, nro_cuenta,tipo_cuenta,saldo);
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
        ArrayList<String> datos= negocio.select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datos);
        lista.setAdapter(adapter);
    }

    public void cargarSpinnerBanco(){
        ArrayList<String> bancos = new ArrayList<>();
        bancos.add("Seleccionar Banco");
        bancos.add("Banco Economico");
        bancos.add("Banco Sol");
        bancos.add("Banco Ganadero");
        bancos.add("Banco FIE");
        bancos.add("Banco de Credito");

        ArrayAdapter adapterBancos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bancos);
        banco.setAdapter(adapterBancos);
    }

    public void cargarSpinnerTipoCuenta(){
        ArrayList<String> tipoCuentaArray = new ArrayList<>();
        tipoCuentaArray.add("Caja de Ahorro");
        tipoCuentaArray.add("Cuenta Corriente");


        ArrayAdapter adapterTipoCuenta = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tipoCuentaArray);
        tipoCuenta.setAdapter(adapterTipoCuenta);
    }


}