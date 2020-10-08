package com.example.inventario.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.inventario.Entity.Categoria;

import java.util.ArrayList;

public class CategoriaDAO {

    SQLiteDatabase conexion;
    ArrayList<Categoria> lista = new ArrayList<Categoria>();
    Categoria categoria;
    Context context;
    String nombredb = "dbinventario";
    String tablaCategoria = "create table if not exists categoria(id integer primary key autoincrement, nombre text, estado text)";

    public CategoriaDAO(Context categoria) {
        this.context = categoria;
        conexion = categoria.openOrCreateDatabase(nombredb,Context.MODE_PRIVATE,null);
        conexion.execSQL(tablaCategoria);
    }

    public boolean agregarCategoria(Categoria categoria){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",categoria.getNombre());
        contentValues.put("estado",categoria.getEstado());
        return (conexion.insert("categoria",null,contentValues))>0;
    }

    public ArrayList<Categoria> listarCategorias(){
        lista.clear();
        Cursor cursor = conexion.rawQuery("select * from categoria", null);
        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                lista.add(new Categoria(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return lista;
    }

    public boolean eliminarCategoria(int id){
        return true;
    }

    public boolean editarCategoria(Categoria categoria){
        return true;
    }






}
