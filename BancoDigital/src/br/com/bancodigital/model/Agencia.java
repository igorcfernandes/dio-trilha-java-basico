package br.com.bancodigital.model;

public class Agencia {

    private final int numero;
    private final Banco banco;

    public Agencia(int numero, Banco banco) {
        this.numero = numero;
        this.banco = banco;
    }

    public int getNumero() {
        return numero;
    }

    public Banco getBanco() {
        return banco;
    }
}
