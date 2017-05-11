package com.finhane.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] arrAlunos = {"Daniel", "Ronaldo", "Francisco", "Felipe"};
        ArrayAdapter<String> adapterListAlunos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrAlunos);

        ListView listAlunos = (ListView) findViewById(R.id.listAlunos);
        listAlunos.setAdapter(adapterListAlunos);


    }
}
