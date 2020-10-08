package com.example.inventario.Util;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.inventario.DAO.CategoriaDAO;
import com.example.inventario.Entity.Categoria;
import com.example.inventario.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    Activity activity;
    Categoria categoria;
    CategoriaDAO categoriaDAO;
    ArrayList<Categoria> lista;
    int id = 0;

    TextView tvNombre, tvEstado;
    Button btnEditar, btnEliminar, btnVer;

    public Adaptador(Activity activity, ArrayList<Categoria> lista, CategoriaDAO categoriaDAO) {
        this.activity = activity;
        this.lista = lista;
        this.categoriaDAO = categoriaDAO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Categoria getItem(int position) {
        categoria =lista.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        categoria = lista.get(position);
        return categoria.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater li = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.itemcategoria, null);
        }
        categoria = lista.get(position);
        tvNombre = (TextView)v.findViewById(R.id.txtNombre);
        tvEstado = (TextView)v.findViewById(R.id.txtEstado);
        btnEditar = (Button)v.findViewById(R.id.btnEditar);
        btnEliminar = (Button)v.findViewById(R.id.btnEliminar);
        btnVer = (Button)v.findViewById(R.id.btnVer);

        tvNombre.setText(categoria.getNombre());
        tvEstado.setText(categoria.getEstado());
        btnEditar.setTag(position);
        btnEliminar.setTag(position);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        return v;
    }
}
