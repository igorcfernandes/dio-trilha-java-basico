package br.com.bancodigital.service;

import br.com.bancodigital.model.conta.Conta;

public class ContaService {
    public void transferir(Conta origem, Conta destino, double valor) {
        origem.sacar(valor);
        destino.depositar(valor);
    }
}
