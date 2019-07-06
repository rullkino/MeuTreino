package br.com.rafaelleme.senai.myapplication.model.vo;

public class Exercicio {

    private long idExercicio;
    private String descricaoExercicio;
    private int cargaExercicio,repeticoesExercicio;

    public Exercicio(){}

    public Exercicio(long idExercicio, String descricaoExercicio, int cargaExercicio, int repeticoesExercicio) {
        this.idExercicio = idExercicio;
        this.descricaoExercicio = descricaoExercicio;
        this.cargaExercicio = cargaExercicio;
        this.repeticoesExercicio = repeticoesExercicio;
    }

    public long getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(long idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getDescricaoExercicio() {
        return descricaoExercicio;
    }

    public void setDescricaoExercicio(String descricaoExercicio) {
        this.descricaoExercicio = descricaoExercicio;
    }

    public int getCargaExercicio() {
        return cargaExercicio;
    }

    public void setCargaExercicio(int cargaExercicio) {
        this.cargaExercicio = cargaExercicio;
    }

    public int getRepeticoesExercicio() {
        return repeticoesExercicio;
    }

    public void setRepeticoesExercicio(int repeticoesExercicio) {
        this.repeticoesExercicio = repeticoesExercicio;
    }
}
