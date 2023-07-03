package com.example.tlenguajes2023;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tlenguajes2023.configuracion.ConfigDB;
import com.example.tlenguajes2023.configuracion.SQLiteConnection;
import com.example.tlenguajes2023.configuracion.personas;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity
{
    SQLiteConnection conexion;
    ListView lista;
    ArrayList<personas> listfutbolista;
    ArrayList<String> arreglofutbolista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConnection(this, ConfigDB.namebd, null, 1);
        lista = (ListView) findViewById(R.id.Lista);

        ObtenerTabla();

        ArrayAdapter apd = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arreglofutbolista);
        lista.setAdapter(apd);

    }

    private void ObtenerTabla()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        personas person = null;
        listfutbolista = new ArrayList<personas>();

        // Cursor de Base de Datos
        Cursor cursor = db.rawQuery(ConfigDB.SelectTBFutbolista,null);

        // recorremos el cursor
        while(cursor.moveToNext())
        {
            person = new personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setPaises(cursor.getString(3));
            person.setPosiciones(cursor.getString(4));
            person.setEdad(cursor.getInt(5));

            listfutbolista.add(person);
        }

        cursor.close();

        fillData();
    }

    private void fillData()
    {
        arreglofutbolista = new ArrayList<String>();

        for(int i=0; i < listfutbolista.size(); i++)
        {
            arreglofutbolista.add(listfutbolista.get(i).getId() + " - "
                    +listfutbolista.get(i).getNombres() + " - "
                    +listfutbolista.get(i).getApellidos() + " - "
                    +listfutbolista.get(i).getPaises() + " - "
                    +listfutbolista.get(i).getPosiciones()+ " - "
                    +listfutbolista.get(i).getEdad());
        }
    }
}