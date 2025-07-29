## Desafio - Banco Digital

O objetivo deste projeto prático hands-on é reforçar o conhecimento em Programação Orientada a Objetos (POO) em Java, através da implementação de um sistema de banco digital.
Serão trabalhados, na prática, os quatro pilares da POO:

- Abstração
- Encapsulamento
- Herança
- Polimorfismo

<br>

### Descrição

Este repositório contém um projeto de referência desenvolvido em Java, modelando um banco digital com:
- Criação de **bancos**, **agências**, **clientes** e **contas**
- Dois tipos de conta: **Conta Corrente** e **Conta Poupança**, ambas herdando de uma classe abstrata `Conta`
- Interface `IConta` para garantir um contrato comum às contas
- Serviços para transferência entre contas
- Utilitários para formatação de números e valores monetários
- Exibição de extrato formatado (ex.: `R$ 1.234,56`)

<br>

### Diagrama UML

```mermaid
classDiagram
direction TB
    class Banco {
	    - String nome
	    - final int numero
	    + getNome()
	    + setNome()
	    + getNumero()
    }

    class Agencia {
	    - final int numero
	    - final Banco banco
	    + getNumero()
	    + getBanco()
    }

    class Cliente {
	    - String nome
	    - String cpf
	    + getNome()
	    + getCpf()
    }

    class ContaCorrente {
	    + ContaCorrente(Cliente cliente, Agencia agencia)
	    + imprimirExtrato()
    }

    class ContaPoupanca {
	    + ContaPoupanca(Cliente cliente, Agencia agencia)
	    + imprimirExtrato()
    }

    class ContaService {
	    + transferir(IConta origem, IConta destino, double valor)
    }

    class BancoService {
	    + getNumeroFormatado(Banco banco)
    }

    class FormatadorNumeros {
	    + formatarComZeros(int numero, int tamanho)
	    + formatarValorMonetario(double valor)
    }

    class IConta {
	    + depositar(double valor)
	    + sacar(double valor)
	    + imprimirExtrato()
	    + getSaldo() double
    }

    class Conta {
	    - static int sequencial
	    - final int numero
	    - final Agencia agencia
	    - final Cliente cliente
	    - double saldo
	    + Conta(Cliente cliente, Agencia agencia)
	    + getNumero()
	    + getAgencia()
	    + getCliente()
	    + getSaldo()
	    + depositar(double valor)
	    + sacar(double valor)
	    + imprimirExtrato()
    }

	<<Interface>> IConta
	<<Abstract>> Conta

    Agencia --> Banco : pertence
    Conta --> Agencia : pertence
    Conta --> Cliente : pertence
    ContaCorrente --|> Conta
    ContaPoupanca --|> Conta
    Conta ..|> IConta
    ContaService --> IConta : usa
    BancoService --> Banco : usa
```
