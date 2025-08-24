package br.com.bootcamp.model.conteudo;

import br.com.bootcamp.exception.ConteudoException;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public Conteudo(String titulo, String descricao) {
        setTitulo(titulo);
        setDescricao(descricao);
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new ConteudoException("O título do conteúdo não pode ser vazio.");
        }

        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new ConteudoException("A descrição do conteúdo não pode ser vazia.");
        }

        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract double calcularXp();
}
