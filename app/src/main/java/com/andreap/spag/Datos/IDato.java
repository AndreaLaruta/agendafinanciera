package com.andreap.spag.Datos;

import java.util.ArrayList;

public interface IDato {

    public void insert();
    public void update();
    public void delete();
    public ArrayList<String> select();
}
