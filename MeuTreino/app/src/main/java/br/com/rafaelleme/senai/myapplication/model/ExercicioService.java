package br.com.rafaelleme.senai.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelleme.senai.myapplication.model.vo.Exercicio;

public class ExercicioService {

    private SQLiteDatabase dbMeuTreino;
    private AcademiaDB bancoMeuTreino;

    public ExercicioService(Context context){
         bancoMeuTreino = new AcademiaDB(context);
    }

    public long inserirExercicio(String strDescr, int intCarga , int intRepet, long idTreino){
        ContentValues valoresCampos;
        long resultadoRetorno;

        dbMeuTreino = bancoMeuTreino.getWritableDatabase();
        valoresCampos = new ContentValues();
        valoresCampos.put(AcademiaDB.DESCRICAO, strDescr);
        valoresCampos.put(AcademiaDB.CARGA, intCarga);
        valoresCampos.put(AcademiaDB.REPETICOES, intRepet);
        valoresCampos.put(AcademiaDB.ID_TREINO, idTreino);

        resultadoRetorno = dbMeuTreino.insert(AcademiaDB.TABLE_EXERCICIO,null,valoresCampos);
        dbMeuTreino.close();

        return resultadoRetorno;
    }

    public List<Exercicio> carregarExercicio(long idTreino){
        Cursor cursorExercicios;
        String[] camposTabela = {bancoMeuTreino.ID_EXERCICIO, bancoMeuTreino.DESCRICAO, bancoMeuTreino.CARGA, bancoMeuTreino.REPETICOES,
        bancoMeuTreino.ID_TREINO};
        String clausulaWhere = AcademiaDB.ID_TREINO + " = " + idTreino;
        dbMeuTreino = bancoMeuTreino.getReadableDatabase();
        cursorExercicios = dbMeuTreino.query(bancoMeuTreino.TABLE_EXERCICIO, camposTabela, clausulaWhere, null,
                null, null, null, null);

        if(cursorExercicios != null && cursorExercicios.getCount() > 0){
            cursorExercicios.moveToFirst();
            return toList(cursorExercicios);
        }else {
            dbMeuTreino.close();
            return null;
        }
    }

    public List<Exercicio> toList(Cursor cursor){
        List<Exercicio> exercicios = new ArrayList<>();

        do{
            Exercicio e = new Exercicio();
            e.setIdExercicio(cursor.getInt(cursor.getColumnIndexOrThrow(AcademiaDB.ID_EXERCICIO)));
            e.setDescricaoExercicio(cursor.getString(cursor.getColumnIndexOrThrow(AcademiaDB.DESCRICAO)));
            e.setCargaExercicio(cursor.getInt(cursor.getColumnIndexOrThrow(AcademiaDB.CARGA)));
            e.setRepeticoesExercicio(cursor.getInt(cursor.getColumnIndexOrThrow(AcademiaDB.REPETICOES)));

            exercicios.add(e);

        }while(cursor.moveToNext());

        return exercicios;
    }

    public Exercicio recuperarExercicio(long idExercicio){
        Cursor cursorExercicios;
        String[] camposTabela = {bancoMeuTreino.ID_EXERCICIO, bancoMeuTreino.DESCRICAO, bancoMeuTreino.CARGA, bancoMeuTreino.REPETICOES};
        String clasulaWhere = AcademiaDB.ID_EXERCICIO + " = " +idExercicio;
        dbMeuTreino = bancoMeuTreino.getReadableDatabase();
        cursorExercicios = dbMeuTreino.query(bancoMeuTreino.TABLE_EXERCICIO, camposTabela, clasulaWhere, null, null,
                null, null, null);

        if(cursorExercicios != null)
            cursorExercicios.moveToFirst();

        int intId = cursorExercicios.getInt(cursorExercicios.getColumnIndexOrThrow(bancoMeuTreino.ID_EXERCICIO));
        String strDescr = cursorExercicios.getString(cursorExercicios.getColumnIndexOrThrow(bancoMeuTreino.DESCRICAO));
        int intCarga = cursorExercicios.getInt(cursorExercicios.getColumnIndexOrThrow(bancoMeuTreino.CARGA));
        int intRepet = cursorExercicios.getInt(cursorExercicios.getColumnIndexOrThrow(bancoMeuTreino.REPETICOES));

        Exercicio dadosExercicio = new Exercicio(intId, strDescr, intCarga, intRepet);

        dbMeuTreino.close();

        return dadosExercicio;
    }

    public void  editarCarga(long idExercicio, int novaCarga) {
        dbMeuTreino = bancoMeuTreino.getReadableDatabase();
        String clasulaWhere = AcademiaDB.ID_EXERCICIO + " = " +idExercicio;

        ContentValues cv = new ContentValues();
        cv.put("CARGA",  novaCarga);
        dbMeuTreino.update(bancoMeuTreino.TABLE_EXERCICIO, cv, clasulaWhere, null);

        dbMeuTreino.close();


    }

}