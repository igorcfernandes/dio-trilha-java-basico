package br.com.bootcamp.model.conteudo;

import br.com.bootcamp.exception.ConteudoException;

public abstract class Conteudo {
    protected static final double XP_PADRAO = (double)10.0F;
    private String titulo;
    private String descricao;

    public Conteudo(String titulo, String descricao) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            this.titulo = titulo;
        } else {
            throw new ConteudoException("O título do conteúdo não pode ser vazio.");
        }
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new ConteudoException("A descrição do conteúdo não pode ser vazia.");
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public abstract double calcularXp();
}
