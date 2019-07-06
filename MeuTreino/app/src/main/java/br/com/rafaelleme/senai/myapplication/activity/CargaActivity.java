package br.com.rafaelleme.senai.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import br.com.rafaelleme.senai.myapplication.R;
import br.com.rafaelleme.senai.myapplication.adapter.ExercicioAdapter;
import br.com.rafaelleme.senai.myapplication.model.ExercicioService;
import br.com.rafaelleme.senai.myapplication.model.vo.Exercicio;

public class CargaActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txNomeExercicio;
    EditText  edtCarga;
    Button btEditar;

    ExercicioService exercicioService;
    Exercicio exercicio;
    Long codigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);
         exercicioService = new ExercicioService(this);
        btEditar = findViewById(R.id.btEditar);
        txNomeExercicio = findViewById(R.id.txNomeExercicio);
        edtCarga = findViewById(R.id.edtCarga);

        codigo = getIntent().getLongExtra("id",0);

        exercicio = exercicioService.recuperarExercicio(codigo);

        btEditar.setOnClickListener(this);

        txNomeExercicio.setText(exercicio.getDescricaoExercicio());
        edtCarga.setText(String.valueOf(exercicio.getCargaExercicio()));

    }

    @Override
    public void onClick(View v) {
        exercicioService.editarCarga(codigo, Integer.valueOf (edtCarga.getText().toString()));
        finish();
    }
}
