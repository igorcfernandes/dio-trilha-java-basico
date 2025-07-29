package br.com.bancodigital.app;

import br.com.bancodigital.model.*;
import br.com.bancodigital.model.conta.*;
import br.com.bancodigital.service.*;

public class BancoDigitalApp {

    public static void main(String[] args) {
        Banco banco = new Banco("Meu Banco S.A.", 22);
        Agencia agencia = new Agencia(111, banco);
        Cliente cliente = new Cliente("Nome do Cliente", "123.321.123-32");
        Conta contaCorrente = new ContaCorrente(agencia, cliente);
        Conta contaPoupanca = new ContaPoupanca(agencia, cliente);

        contaCorrente.depositar(1000);

        ContaService contaService = new ContaService();
        contaService.transferir(contaCorrente, contaPoupanca, 200);

        System.out.println();
        contaCorrente.imprimirExtrato();
        System.out.println();
        contaPoupanca.imprimirExtrato();
    }
}
