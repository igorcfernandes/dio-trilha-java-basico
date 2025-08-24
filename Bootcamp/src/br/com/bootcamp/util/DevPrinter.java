package br.com.bootcamp.util;

import br.com.bootcamp.model.Dev;
import br.com.bootcamp.model.conteudo.Conteudo;

import java.util.Set;

public class DevPrinter {

    public static void imprimir(Dev dev) {
        System.out.println(dev.getNome());
        imprimirConteudo("Conteúdos inscritos", dev.getConteudosInscritos());
        imprimirConteudo("Conteúdos concluidos", dev.getConteudosConcluidos());
        System.out.println("\tTotal XP: " + dev.getTotalXp());
    }

    public static void imprimirConteudo(String titulo, Set<Conteudo> conteudos) {
        System.out.println("\t" + titulo + ":");

        for (Conteudo conteudo : conteudos)
            System.out.println("\t\t- " + conteudo.getTitulo() + " (" + conteudo.getClass().getSimpleName() + ")");
    }
}
