package br.com.bancodigital.model.conta;

import br.com.bancodigital.model.Agencia;
import br.com.bancodigital.model.Cliente;

public abstract class Conta implements IConta {

    private static int sequencial = 1;

    protected final int numero;
    protected final Agencia agencia;
    protected final Cliente cliente;
    protected double saldo;

    public Conta(Agencia agencia, Cliente cliente) {
        this.numero = sequencial++;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    public abstract void imprimirExtrato();
}
