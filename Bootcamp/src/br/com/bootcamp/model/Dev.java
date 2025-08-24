package br.com.bootcamp.model;

import br.com.bootcamp.exception.DevException;
import br.com.bootcamp.model.conteudo.Conteudo;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private double totalXp = 0d;

    public Dev(String nome) {
        setNome(nome);
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new DevException("O nome não pode ser vazio.");
        }

        this.nome = nome;
    }

    public void adicionarXp(double xp) {
        this.totalXp += xp;
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public double getTotalXp() {
        return totalXp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
