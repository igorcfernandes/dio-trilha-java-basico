package br.com.bootcamp.model.conteudo;

import br.com.bootcamp.exception.ConteudoException;
import java.time.LocalDate;

public class Mentoria extends Conteudo {
    private LocalDate data;

    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        this.setData(data);
    }

    public void setData(LocalDate data) {
        if (data != null && !data.isBefore(LocalDate.now())) {
            this.data = data;
        } else {
            throw new ConteudoException("A data da mentoria deve ser futura.");
        }
    }

    public double calcularXp() {
        return (double)30.0F;
    }

    public LocalDate getData() {
        return this.data;
    }
}
