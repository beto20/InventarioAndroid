package com.example.inventario.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.inventario.Entity.Objeto;

import java.util.ArrayList;

public class ObjetoDAO {
    Objeto objeto;
    Context context;
    ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();
    SQLiteDatabase conexion;
    String nombredb = "dbinventario";
    String tablaObjeto = "create table if not exists objeto(id integer primary key autoincrement, nombre text, descripcion text, estado text, cantidad integer)";

    public ObjetoDAO(Context objeto) {
        this.context = objeto;
        conexion = objeto.openOrCreateDatabase(nombredb,Context.MODE_PRIVATE,null);
        conexion.execSQL(tablaObjeto);
    }

    public boolean agregarObjeto(Objeto objeto){
        return  true;
    }

    public ArrayList<Objeto> listarObjetos(Objeto objeto){
        return listaObjetos;
    }

    public boolean eliminarObjeto(int id){
        return true;
    }

    public boolean editarObjeto(Objeto objeto){
        return true;
    }







}
