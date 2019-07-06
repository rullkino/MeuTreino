package br.com.rafaelleme.senai.myapplication.adapter;

import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import br.com.rafaelleme.senai.myapplication.R;
import br.com.rafaelleme.senai.myapplication.model.vo.Exercicio;

public class ExercicioViewHolder extends RecyclerView.ViewHolder {

    TextView txtDescricao, txtCarga , txtCiclos;

    public ExercicioViewHolder(View itemView) {
        super(itemView);

        txtDescricao = itemView.findViewById(R.id.txtDescricao);
        txtCarga = itemView.findViewById(R.id.txtCarga);
        txtCiclos = itemView.findViewById(R.id.txtCiclos);
    }
}
