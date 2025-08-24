package br.com.bootcamp.model.conteudo;

import br.com.bootcamp.exception.ConteudoException;

public class Curso extends Conteudo {
    private int cargaHoraria;

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        this.setCargaHoraria(cargaHoraria);
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            throw new ConteudoException("A carga horária deve ser maior que zero.");
        } else {
            this.cargaHoraria = cargaHoraria;
        }
    }

    public double calcularXp() {
        return (double)10.0F * (double)this.cargaHoraria;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }
}
