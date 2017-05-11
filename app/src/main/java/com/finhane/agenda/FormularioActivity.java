package com.finhane.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    EditText txtNome, txtEndereco, txtTelefone, txtSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button btSalvarFormulario = (Button) findViewById(R.id.formulario_btSalvarFormulario);
        txtNome = (EditText) findViewById(R.id.formulario_txtNome);
        txtEndereco = (EditText) findViewById(R.id.formulario_txtEndereco);
        txtTelefone = (EditText) findViewById(R.id.formulario_txtTelefone);
        txtSite = (EditText) findViewById(R.id.formulario_txtSite);
        RatingBar nota = (RatingBar) findViewById(R.id.formulario_nota);

        btSalvarFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormularioActivity.this, "Botão clicado, nome: " + txtNome.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
