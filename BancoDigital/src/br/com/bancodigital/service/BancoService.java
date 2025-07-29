package br.com.bancodigital.service;

import br.com.bancodigital.model.Banco;
import br.com.bancodigital.util.FormatadorNumeros;

public class BancoService {
    public static String getNumeroFormatado(Banco banco) {
        return FormatadorNumeros.formatarComZeros(banco.getNumero(), 3);
    }
}
