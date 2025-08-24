package br.com.bootcamp.model.conteudo;

import br.com.bootcamp.exception.ConteudoException;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        setData(data);
    }

    public void setData(LocalDate data) {
        if (data == null || data.isBefore(LocalDate.now())) {
            throw new ConteudoException("A data da mentoria deve ser futura.");
        }

        this.data = data;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() {
        return data;
    }
}
