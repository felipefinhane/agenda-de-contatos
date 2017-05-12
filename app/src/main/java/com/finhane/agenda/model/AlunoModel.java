package com.finhane.agenda.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.finhane.agenda.entity.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipe on 11/05/17.
 */

public class AlunoModel extends SQLiteOpenHelper {

    public AlunoModel(Context context) {
        super(context, "db_agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSQL = "CREATE TABLE alunos (" +
                " id INTEGER PRIMARY KEY, " +
                " nome VARCHAR(120) NOT NULL, " +
                " endereco VARCHAR(120), " +
                " telefone VARCHAR(30), " +
                " site VARCHAR(100), " +
                " nota REAL" +
                ");";
        db.execSQL(strSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strSQL = "DROP TABLE IF EXISTS alunos";
        db.execSQL(strSQL);
        onCreate(db);
//        switch (newVersion) {
//            case 2:
//                break;
//        }
    }

    public void save(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dataAluno = new ContentValues();
        dataAluno.put("nome", aluno.getNome());
        dataAluno.put("endereco", aluno.getEndereco());
        dataAluno.put("telefone", aluno.getTelefone());
        dataAluno.put("site", aluno.getSite());
        dataAluno.put("nota", aluno.getNota());

        db.insert("alunos", null, dataAluno);
    }

    public List<Aluno> getAlunos() {
        String strSQL = "SELECT * FROM alunos;";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cData = db.rawQuery(strSQL, null);

        List<Aluno> dataAluno = new ArrayList<Aluno>();
        while (cData.moveToNext()){
            Aluno aluno = new Aluno();

            aluno.setId(cData.getLong(cData.getColumnIndex("id")));
            aluno.setNome(cData.getString(cData.getColumnIndex("nome")));
            aluno.setEndereco(cData.getString(cData.getColumnIndex("endereco")));
            aluno.setTelefone(cData.getString(cData.getColumnIndex("telefone")));
            aluno.setSite(cData.getString(cData.getColumnIndex("site")));
            aluno.setNota(cData.getDouble(cData.getColumnIndex("nota")));

            dataAluno.add(aluno);
        }
        cData.close();
        return dataAluno;
    }

    public void delete(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        String[] paramsData = {aluno.getId().toString()};
        db.delete("alunos", "id = ? ", paramsData);
    }
}
