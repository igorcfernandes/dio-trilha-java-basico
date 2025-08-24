package br.com.bootcamp.service;

import br.com.bootcamp.model.Bootcamp;
import br.com.bootcamp.model.Dev;
import br.com.bootcamp.model.conteudo.Conteudo;
import java.util.Optional;

public class DevService {
    public void inscreverBootcamp(Dev dev, Bootcamp bootcamp) {
        bootcamp.getDevs().add(dev);
        dev.getConteudosInscritos().addAll(bootcamp.getConteudos());
    }

    public void progredir(Dev dev) {
        Optional<Conteudo> conteudo = dev.getConteudosInscritos().stream().findFirst();
        if (conteudo.isPresent()) {
            dev.getConteudosConcluidos().add((Conteudo)conteudo.get());
            dev.getConteudosInscritos().remove(conteudo.get());
            dev.adicionarXp(((Conteudo)conteudo.get()).calcularXp());
        } else {
            System.out.println("Você não está matriculado em nenhum curso.");
        }
    }
}