package com.example.tlenguajes2023.configuracion;

public class ConfigDB
{
    // Configuracion de los parametros de la base de datos local en sqlite
    //Nombre de la base de datos
    public static final String namebd = "DBTLeng";

    // Tablas de las bases de datos
    public static final String tblfutbolista = "FUTBOLISTA";

    // Campos de la tabla personas
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";

    public static final String paises = "paises";

    public static final String posiciones = "posiciones";
    public static final String edad = "edad";


    // Creacion de objetos DDL - CREATE - DROP - ALTER
    public static final String CreateTBFutbolista = "CREATE TABLE FUTBOLISTA (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT," +
            "apellidos TEXT, paises TEXT, posiciones TEXT, edad INTEGER)";

    public static final String DropTBFutbolista = "DROP TABLE IF EXISTS FUTBOLISTA";

    // Creacion de objetos DML para poder seleccionar informacion de la base de datos
    public static final String SelectTBFutbolista = "SELECT * FROM " + ConfigDB.tblfutbolista;

    public static final String Empty = "";

}
