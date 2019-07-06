package br.com.rafaelleme.senai.myapplication.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.rafaelleme.senai.myapplication.R;
import br.com.rafaelleme.senai.myapplication.adapter.ExercicioAdapter;
import br.com.rafaelleme.senai.myapplication.adapter.TreinoAdapter;
import br.com.rafaelleme.senai.myapplication.model.ExercicioService;
import br.com.rafaelleme.senai.myapplication.model.TreinoService;
import br.com.rafaelleme.senai.myapplication.model.vo.Exercicio;
import br.com.rafaelleme.senai.myapplication.model.vo.Treino;

public class ExercicioActivity extends AppCompatActivity implements View.OnClickListener  {

    FloatingActionButton fbNovoExercicio, fbAtualizar;
    RecyclerView rvListaExercicios;

    List<Exercicio> exercicios;
    ExercicioService exercicioService;
    ExercicioAdapter exercicioAdapter;
    TreinoService treinoService;
    long codigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);

        codigo = getIntent().getLongExtra("id",0);
        rvListaExercicios = findViewById(R.id.rvListaExercicio);
        fbNovoExercicio = findViewById(R.id.fbNovoExercicio);
        fbNovoExercicio.setOnClickListener(this);
        treinoService = new TreinoService(this);

        fbAtualizar = findViewById(R.id.fbAtualizar);
        fbAtualizar.setOnClickListener(this);



    }

    @Override
    protected void onResume() {
        exercicioService = new ExercicioService(this);

        exercicios = exercicioService.carregarExercicio(codigo);

        exercicioAdapter = new ExercicioAdapter(this,exercicios);
        rvListaExercicios.setLayoutManager(new LinearLayoutManager(this));
        rvListaExercicios.setAdapter(exercicioAdapter);

        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fbNovoExercicio:
                Intent intent = new Intent(this, NovoExercicioActivity.class);
                intent.putExtra("id",getIntent().getLongExtra("id",0));
                startActivity(intent);
                break;

            case R.id.fbAtualizar:
                treinoService.atualizar(codigo);
                finish();
                break;
        }
    }
    }

