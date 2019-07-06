package br.com.rafaelleme.senai.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.rafaelleme.senai.myapplication.R;

public class TreinoViewHolder extends RecyclerView.ViewHolder {


    TextView txtNomeTreino, txtCiclos;

    public TreinoViewHolder(View itemView) {
        super(itemView);

        txtNomeTreino = itemView.findViewById(R.id.txtNomeTreino);
        txtCiclos = itemView.findViewById(R.id.txtCiclos);
    }
}
