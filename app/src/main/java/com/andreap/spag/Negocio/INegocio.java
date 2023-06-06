package com.andreap.spag.Negocio;

import java.util.ArrayList;

public interface INegocio {

    public void insert(String nombre, Long nro_cuenta, String tipo_cuenta, Double saldo);
    public void update(Long id, String nombre, Long nro_cuenta, String tipo_cuenta, Double saldo);
    public void delete(Long id);
    public ArrayList<String> select();
}
