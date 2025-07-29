package br.com.bancodigital.model.conta;

import br.com.bancodigital.model.Agencia;
import br.com.bancodigital.model.Cliente;
import br.com.bancodigital.service.BancoService;
import br.com.bancodigital.util.FormatadorNumeros;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Agencia agencia, Cliente cliente) {
        super(agencia, cliente);
    }

    @Override
    public void imprimirExtrato() {
        String numeroBancoFormatado = BancoService.getNumeroFormatado(agencia.getBanco());
        String nomeBanco = agencia.getBanco().getNome();
        String saldoFormatado = FormatadorNumeros.formatarValorMonetario(saldo);

        System.out.println("Extrato da Conta Poupança");
        System.out.println("  Banco: " + numeroBancoFormatado + " - " + nomeBanco);
        System.out.println("  Agência: " + agencia.getNumero());
        System.out.println("  Número da conta: " + numero);
        System.out.println("  Cliente: " + cliente.getNome());
        System.out.println("  CPF: " + cliente.getCpf());
        System.out.println("  Saldo: " + saldoFormatado);
    }
}
