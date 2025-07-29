package br.com.bancodigital.model;

public class Banco {

    private String nome;
    private final int numero;

    public Banco(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }
}
