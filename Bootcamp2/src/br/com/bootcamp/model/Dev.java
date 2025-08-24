package br.com.bootcamp.model;

import br.com.bootcamp.exception.DevException;
import br.com.bootcamp.model.conteudo.Conteudo;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet();
    private double totalXp = (double)0.0F;

    public Dev(String nome) {
        this.setNome(nome);
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        } else {
            throw new DevException("O nome não pode ser vazio.");
        }
    }

    public void adicionarXp(double xp) {
        this.totalXp += xp;
    }

    public String getNome() {
        return this.nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return this.conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return this.conteudosConcluidos;
    }

    public double getTotalXp() {
        return this.totalXp;
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Dev dev = (Dev)o;
            return Objects.equals(this.nome, dev.nome) && Objects.equals(this.conteudosInscritos, dev.conteudosInscritos) && Objects.equals(this.conteudosConcluidos, dev.conteudosConcluidos);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.nome, this.conteudosInscritos, this.conteudosConcluidos});
    }
}
