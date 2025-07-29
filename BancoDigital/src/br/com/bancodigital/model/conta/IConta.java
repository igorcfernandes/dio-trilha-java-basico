package br.com.bancodigital.model.conta;

public interface IConta {

    void depositar(double valor);
    void sacar(double valor);
    void imprimirExtrato();
    double getSaldo();
}
