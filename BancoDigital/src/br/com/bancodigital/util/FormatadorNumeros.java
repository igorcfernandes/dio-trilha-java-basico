package br.com.bancodigital.util;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorNumeros {

    public static String formatarComZeros(int numero, int tamanho) {
        return String.format("%0" + tamanho + "d", numero);
    }

    public static String formatarValorMonetario(double valor) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formato.format(valor);
    }
}
