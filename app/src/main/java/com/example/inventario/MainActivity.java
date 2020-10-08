package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.inventario.DAO.CategoriaDAO;
import com.example.inventario.Entity.Categoria;
import com.example.inventario.Util.Adaptador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Categoria> lista;
    Categoria categoria;
    CategoriaDAO categoriaDAO;
    Adaptador adaptador;
    EditText etNombreCat;
    Button btnAgregar;
    String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //variables

        etNombreCat = (EditText)findViewById(R.id.txtNombreCat);
        estado = "Activo";
        btnAgregar = (Button)findViewById(R.id.btnAgregar);
        //clases instanciadas
        categoriaDAO = new CategoriaDAO(this);
        lista = categoriaDAO.listarCategorias();
        adaptador = new Adaptador(this, lista, categoriaDAO);

        ListView list = (ListView)findViewById(R.id.lista);
        list.setAdapter(adaptador);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    categoria = new Categoria(etNombreCat.getText().toString(), estado);
                    categoriaDAO.agregarCategoria(categoria);
                    lista = categoriaDAO.listarCategorias();
                    adaptador.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }


            }
        });




    }
/*
    public void AgregarCate(View view){
        try {

            categoria = new Categoria(etNombreCat.getText().toString(), estado);
            categoriaDAO.agregarCategoria(categoria);
            lista = categoriaDAO.listarCategorias();
            adaptador.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
    }
*/








}