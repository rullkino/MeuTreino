package br.com.rafaelleme.senai.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rafaelleme.senai.myapplication.R;
import br.com.rafaelleme.senai.myapplication.model.ExercicioService;

public class NovoExercicioActivity extends AppCompatActivity {

    ExercicioService exercicioService;
    EditText edtNomeExercicio, edtCarga, edtCiclosRealizados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_exercicio);

        edtNomeExercicio = findViewById(R.id.edtNomeExercicio);
        edtCarga = findViewById(R.id.edtCarga);
        edtCiclosRealizados = findViewById(R.id.edtCiclosRealizados);

        exercicioService = new ExercicioService(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar,menu);
        return super.onCreateOptionsMenu(menu);
    }

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
        if(!edtNomeExercicio.getText().toString().equals("")
                && !edtCarga.getText().toString().equals("") && !edtCiclosRealizados.getText().equals("")) {

            //pegar as informações
            String descricao = edtNomeExercicio.getText().toString();
            int carga = Integer.valueOf(edtCarga.getText().toString());
            int ciclos = Integer.valueOf(edtCiclosRealizados.getText().toString());

            //insere no banco de dados
            if(exercicioService.inserirExercicio(descricao,carga,ciclos,getIntent().getLongExtra("id",0)) > 0){
                Toast.makeText(this,
                        "Exercicio incluído com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this,
                        "Erro ao incluir o exercicio", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,
                    "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
        }

    }

}
