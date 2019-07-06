package br.com.rafaelleme.senai.myapplication.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AcademiaDB extends SQLiteOpenHelper  {


                //DATABASE
    public static final String NOME_BANCO = "MeuTreino";

                //TABLE TREINO
    public static final String TABLE_TREINO = "Treino";
    public static final String ID_TREINO = "Id_Treino";
    public static final String NOME = "Nome";
    public static final String CICLOS = "Ciclos";
    public static final String CICLOS_REALIZADOS = "Ciclos_Realizados";

                //TABLE EXERCICIO
    public static final String TABLE_EXERCICIO = "Exercicio";
    public static final String ID_EXERCICIO = "Id_Exercicio";
    public static final String DESCRICAO = "Descricao";
    public static final String CARGA = "Carga";
    public static final String REPETICOES = "Repeticoes";

                //VERSÃO
    public static final int VERSAO = 1;

    public AcademiaDB(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlComando = " CREATE TABLE IF NOT EXISTS " + TABLE_TREINO + " ( Id_Treino INTEGER PRIMARY KEY AUTOINCREMENT,Nome TEXT,Ciclos INTEGER,Ciclos_Realizados INTEGER); ";
        db.execSQL(sqlComando);
        sqlComando = " CREATE TABLE " + TABLE_EXERCICIO + " ( Id_Exercicio INTEGER PRIMARY KEY AUTOINCREMENT,Descricao TEXT,Carga INTEGER,Repeticoes INTEGER, Id_Treino INTEGER); ";
        db.execSQL(sqlComando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlComando = " DROP TABLE IF EXISTS " + TABLE_TREINO;
        db.execSQL(sqlComando);
        sqlComando = " DROP TABLE IF EXISTS " + TABLE_EXERCICIO;
        db.execSQL(sqlComando);
        onCreate(db);
    }
}
