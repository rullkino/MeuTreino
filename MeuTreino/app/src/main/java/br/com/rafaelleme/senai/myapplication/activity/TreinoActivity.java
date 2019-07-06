package br.com.rafaelleme.senai.myapplication.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelleme.senai.myapplication.R;
import br.com.rafaelleme.senai.myapplication.adapter.TreinoAdapter;
import br.com.rafaelleme.senai.myapplication.model.TreinoService;
import br.com.rafaelleme.senai.myapplication.model.vo.Treino;

public class TreinoActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fbNovoTreino;
    RecyclerView rvListaTreinos;

    List<Treino> treinos;
    TreinoService treinoService;
    TreinoAdapter treinoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino);

        rvListaTreinos = findViewById(R.id.rvListaTreinos);
        fbNovoTreino = findViewById(R.id.fbNovoTreino);
        fbNovoTreino.setOnClickListener(this);


    }

    @Override
    protected void onResume() {
        //pega a lista de treinos do banco de dados
        treinoService = new TreinoService(this);
        treinos = treinoService.carregarTreino();

        //instancia o adapter e coloca dentro do recyclerView
        treinoAdapter = new TreinoAdapter(this,treinos);
        rvListaTreinos.setLayoutManager(new LinearLayoutManager(this));
        rvListaTreinos.setAdapter(treinoAdapter);
        super.onResume();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fbNovoTreino:
                Intent intent = new Intent(this, NovoTreinoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
