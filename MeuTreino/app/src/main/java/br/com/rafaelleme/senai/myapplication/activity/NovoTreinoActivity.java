package br.com.rafaelleme.senai.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafaelleme.senai.myapplication.R;
import br.com.rafaelleme.senai.myapplication.model.TreinoService;

public class NovoTreinoActivity extends AppCompatActivity {

    TreinoService treinoService;
    EditText edtNome, edtCiclos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_treino);

        edtNome = findViewById(R.id.edtNome);
        edtCiclos = findViewById(R.id.edtCiclos);

        treinoService = new TreinoService(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.btnSalvar:
                salvar();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvar() {
        //verifica se os campos não estão vazios
        if(!edtNome.getText().toString().equals("")
                && !edtCiclos.getText().toString().equals("")) {

            //pegar as informações
            String nome = edtNome.getText().toString();
            int ciclos = Integer.valueOf(edtCiclos.getText().toString());

            //insere no banco de dados
            if(treinoService.inserirTreino(nome,ciclos,0) > 0){
                Toast.makeText(this,
                        "Treino incluído com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this,
                        "Erro ao incluir o treino", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,
                    "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
        }

    }
}
