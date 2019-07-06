package br.com.rafaelleme.senai.myapplication.model.vo;

import java.util.List;

public class Treino {

    private long idTreino;
    private String nomeTreino;
    private int cicloTreino, ciclosRealizados;
    private List<Exercicio> exercicios;

    public Treino(){}

    public Treino(long idTreino, String nomeTreino, int cicloTreino, int ciclo_concluidoTreino, List<Exercicio> exercicios){
        this.idTreino = idTreino;
        this.nomeTreino = nomeTreino;
        this.cicloTreino = cicloTreino;
        this.ciclosRealizados = ciclo_concluidoTreino;
        this.exercicios = exercicios;
    }

    public long getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(long idTreino) {
        this.idTreino = idTreino;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public int getCicloTreino() {
        return cicloTreino;
    }

    public void setCicloTreino(int cicloTreino) {
        this.cicloTreino = cicloTreino;
    }

    public int getCiclosRealizados() {
        return ciclosRealizados;
    }

    public void setCiclosRealizados(int ciclosRealizados) {
        this.ciclosRealizados = ciclosRealizados;
    }

}