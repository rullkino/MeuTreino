package br.com.rafaelleme.senai.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelleme.senai.myapplication.model.vo.Treino;

public class TreinoService {

    private SQLiteDatabase dbMeuTreino;
    private AcademiaDB bancoMeuTreino;

    public TreinoService(Context context) {
        bancoMeuTreino = new AcademiaDB(context);
    }

    public long inserirTreino(String strNome, int intCiclos, int intCiclosConcluidos) {
        ContentValues valoresCampos;
        long resultadoRetorno;

        dbMeuTreino = bancoMeuTreino.getWritableDatabase();
        valoresCampos = new ContentValues();
        valoresCampos.put(AcademiaDB.NOME, strNome);
        valoresCampos.put(AcademiaDB.CICLOS, intCiclos);
        valoresCampos.put (AcademiaDB.CICLOS_REALIZADOS, intCiclosConcluidos);

        resultadoRetorno = dbMeuTreino.insert(AcademiaDB.TABLE_TREINO, null, valoresCampos);
        dbMeuTreino.close();

        return resultadoRetorno;
    }

    public List<Treino> carregarTreino() {
        Cursor cursorTreinos;
        String[] camposTabela = {bancoMeuTreino.ID_TREINO, bancoMeuTreino.NOME, bancoMeuTreino.CICLOS, bancoMeuTreino.CICLOS_REALIZADOS};
        dbMeuTreino = bancoMeuTreino.getReadableDatabase();
        cursorTreinos = dbMeuTreino.query(bancoMeuTreino.TABLE_TREINO, camposTabela, null, null,
                null, null, null, null);

        if (cursorTreinos != null && cursorTreinos.getCount() > 0) {
            dbMeuTreino.close();
            cursorTreinos.moveToFirst();
            return toList(cursorTreinos);
        } else {
            dbMeuTreino.close();
            return null;
        }

    }

    private List<Treino> toList(Cursor c) {
        List<Treino> treinos = new ArrayList<>();


        do {
            Treino t = new Treino();
            t.setIdTreino(c.getInt(c.getColumnIndexOrThrow(AcademiaDB.ID_TREINO)));
            t.setNomeTreino(c.getString(c.getColumnIndexOrThrow(AcademiaDB.NOME)));
            t.setCiclosRealizados(c.getInt(c.getColumnIndexOrThrow(AcademiaDB.CICLOS_REALIZADOS)));
            t.setCicloTreino(c.getInt(c.getColumnIndexOrThrow(AcademiaDB.CICLOS)));

            treinos.add(t);
        } while (c.moveToNext());


        return treinos;
    }

    public Treino recuperarTreino(long idTreino) {
        Cursor cursorTreinos;
        String[] camposTabela = {bancoMeuTreino.ID_TREINO, bancoMeuTreino.NOME, bancoMeuTreino.CICLOS, bancoMeuTreino.CICLOS_REALIZADOS};
        String clasulaWhere = AcademiaDB.ID_TREINO + " = " + idTreino;
        dbMeuTreino = bancoMeuTreino.getReadableDatabase();
        cursorTreinos = dbMeuTreino.query(bancoMeuTreino.TABLE_TREINO, camposTabela, clasulaWhere, null, null,
                null, null, null);


        int intId = cursorTreinos.getInt(cursorTreinos.getColumnIndexOrThrow(bancoMeuTreino.ID_TREINO));
        String strNome = cursorTreinos.getString(cursorTreinos.getColumnIndexOrThrow(bancoMeuTreino.NOME));
        int intCiclos = cursorTreinos.getInt(cursorTreinos.getColumnIndexOrThrow(bancoMeuTreino.CICLOS));
        int intCiclosRealizados = cursorTreinos.getInt(cursorTreinos.getColumnIndexOrThrow(bancoMeuTreino.CICLOS_REALIZADOS));

        Treino dadosTreino = new Treino(intId, strNome, intCiclos, intCiclosRealizados, null);

        dbMeuTreino.close();

        return dadosTreino;
    }

    public void  atualizar(long idTreino) {
        Cursor cursorTreinos;
        String[] camposTabela = {bancoMeuTreino.ID_TREINO, bancoMeuTreino.NOME, bancoMeuTreino.CICLOS, bancoMeuTreino.CICLOS_REALIZADOS};
        String clasulaWhere = AcademiaDB.ID_TREINO + " = " + idTreino;
        dbMeuTreino = bancoMeuTreino.getReadableDatabase();
        cursorTreinos = dbMeuTreino.query(bancoMeuTreino.TABLE_TREINO, camposTabela, clasulaWhere, null, null,
                null, null, null);
        cursorTreinos.moveToNext();

        int intCiclosRealizados = cursorTreinos.getInt(cursorTreinos.getColumnIndexOrThrow(bancoMeuTreino.CICLOS_REALIZADOS));

        ContentValues cv = new ContentValues();
        cv.put("CICLOS_REALIZADOS", intCiclosRealizados+=1);
        dbMeuTreino.update(bancoMeuTreino.TABLE_TREINO, cv, clasulaWhere, null);

        dbMeuTreino.close();


    }




}
