package com.finhane.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.finhane.agenda.entity.Aluno;
import com.finhane.agenda.model.AlunoModel;

import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    ListView listAlunos;
    Button btNovoContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        listAlunos = (ListView) findViewById(R.id.lista_alunos_listAlunos);
        btNovoContato = (Button) findViewById(R.id.lista_alunos_btNovo);

        loadAlunos();
        loadActions();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadAlunos();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        //PODE REALIZAR O INFLATE AQUI TAMBEM
        //FAZENDO MENU NA "MAO"
        MenuItem menuDeletar = menu.add("DELETAR");
        menuDeletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Aluno aluno = (Aluno) listAlunos.getItemAtPosition(info.position);

                AlunoModel alunoModel = new AlunoModel(ListaAlunosActivity.this);
                alunoModel.delete(aluno);
                alunoModel.close();

                Toast.makeText(ListaAlunosActivity.this, "APAGANDO O ALUNO " + aluno.getNome() + "...", Toast.LENGTH_SHORT).show();
                loadAlunos();
                return false;
            }
        });
    }

    private void loadAlunos(){
        AlunoModel alunoModel = new AlunoModel(this);
        List<Aluno> dataAlunos = alunoModel.getAlunos();
        alunoModel.close();

        ArrayAdapter<Aluno> adapterListAlunos = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, dataAlunos);

        listAlunos.setAdapter(adapterListAlunos);
    }

    private void loadActions(){
        btNovoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNovoContato = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intentNovoContato);
            }
        });
        registerForContextMenu(listAlunos);
    }

}
