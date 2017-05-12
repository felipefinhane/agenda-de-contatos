package com.finhane.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import com.finhane.agenda.entity.Aluno;

/**
 * Created by felipe on 11/05/17.
 */

public class FormularioHelper{

    private EditText txtNome, txtEndereco, txtTelefone, txtSite;
    private RatingBar ratingBarNota;

    public FormularioHelper(FormularioActivity activity){
        txtNome = (EditText) activity.findViewById(R.id.formulario_txtNome);
        txtEndereco = (EditText) activity.findViewById(R.id.formulario_txtEndereco);
        txtTelefone = (EditText) activity.findViewById(R.id.formulario_txtTelefone);
        txtSite = (EditText) activity.findViewById(R.id.formulario_txtSite);
        ratingBarNota = (RatingBar) activity.findViewById(R.id.formulario_nota);
    }

    public Aluno getAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(txtNome.getText().toString());
        aluno.setEndereco(txtEndereco.getText().toString());
        aluno.setTelefone(txtTelefone.getText().toString());
        aluno.setSite(txtSite.getText().toString());
        aluno.setNota(Double.valueOf(ratingBarNota.getProgress()));
        return aluno;
    }
}
