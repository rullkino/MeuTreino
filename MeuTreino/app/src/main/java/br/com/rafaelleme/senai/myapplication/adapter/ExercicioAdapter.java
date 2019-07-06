package br.com.rafaelleme.senai.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.rafaelleme.senai.myapplication.R;
import br.com.rafaelleme.senai.myapplication.activity.CargaActivity;
import br.com.rafaelleme.senai.myapplication.model.vo.Exercicio;

    public class ExercicioAdapter extends RecyclerView.Adapter<ExercicioViewHolder> {

        private Context context;
        private List<Exercicio> exercicios;

        //Contrutor recebe o contexto e a lista a ser mostrada
        public ExercicioAdapter(Context context, List<Exercicio> exercicios) {
            this.context = context;
            this.exercicios = exercicios;
        }

        //responsável por inflar o arquivo de layout
        //retorna uma instância do viewHolder para cada linha da lista
        @Override
        public ExercicioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //infla o layout e atribui ao objeto view
            View view = LayoutInflater.from(context).
                    inflate(R.layout.adapter_exercicio, parent,false);

            //instancia o viewHolder passando o view do layout
            ExercicioViewHolder exercicioViewHolder = new ExercicioViewHolder(view);

            //retorna o viewHolder pronto
            return exercicioViewHolder;
        }

        //método responsável por colocar as informações na view
        @Override
        public void onBindViewHolder(ExercicioViewHolder holder, int position) {
            //pega o treino na lista pela posição
            final Exercicio exercicio = exercicios.get(position);

            //seta o texto no campo determinado
            holder.txtDescricao.setText(exercicio.getDescricaoExercicio());

            holder.txtCarga.setText("Carga : " + String.valueOf(exercicio.getCargaExercicio()));

            holder.txtCiclos.setText("Repetições : " + String.valueOf(exercicio.getRepeticoesExercicio()));

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent intent = new Intent(context, CargaActivity.class);
                    intent.putExtra("id",exercicio.getIdExercicio());
                    context.startActivity(intent);
                    return true;
                }
            });
        }

        //retorna o número de elementos na lista
        @Override
        public int getItemCount() {
            return exercicios != null ? exercicios.size() : 0;
        }
    }


