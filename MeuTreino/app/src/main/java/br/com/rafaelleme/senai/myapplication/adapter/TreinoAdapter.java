package br.com.rafaelleme.senai.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import br.com.rafaelleme.senai.myapplication.R;
import br.com.rafaelleme.senai.myapplication.activity.ExercicioActivity;
import br.com.rafaelleme.senai.myapplication.model.vo.Treino;

//Adapter da recycler view deve herdar de RecyclerView.Adapter
//Pode-se passar um objeto que extenda ViewHolder
public class TreinoAdapter extends RecyclerView.Adapter<TreinoViewHolder> {

    private Context context;
    private List<Treino> treinos;

    //Contrutor recebe o contexto e a lista a ser mostrada
    public TreinoAdapter(Context context, List<Treino> treinos) {
        this.context = context;
        this.treinos = treinos;
    }

    //responsável por inflar o arquivo de layout
    //retorna uma instância do viewHolder para cada linha da lista
    @Override
    public TreinoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //infla o layout e atribui ao objeto view
        View view = LayoutInflater.from(context).
                inflate(R.layout.adapter_treino, parent,false);

        //instancia o viewHolder passando o view do layout
        TreinoViewHolder treinoViewHolder = new TreinoViewHolder(view);

        //retorna o viewHolder pronto
        return treinoViewHolder;
    }

    //método responsável por colocar as informações na view
    @Override
    public void onBindViewHolder(TreinoViewHolder holder, int position) {
        //pega o treino na lista pela posição
        final Treino treino = treinos.get(position);

        //seta o texto no campo determinado
        holder.txtNomeTreino.setText(treino.getNomeTreino());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ExercicioActivity.class);
                intent.putExtra("id",treino.getIdTreino());
                context.startActivity(intent);
            }
        });

        String treinosRealizados = treino.getCiclosRealizados()
                + " de " + treino.getCicloTreino();

        holder.txtCiclos.setText(treinosRealizados);
    }

    //retorna o número de elementos na lista
    @Override
    public int getItemCount() {
        return treinos != null ? treinos.size() : 0;
    }
}
