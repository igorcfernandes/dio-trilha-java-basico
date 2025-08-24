package br.com.bootcamp.application;

import br.com.bootcamp.model.Bootcamp;
import br.com.bootcamp.model.conteudo.Curso;
import br.com.bootcamp.model.Dev;
import br.com.bootcamp.model.conteudo.Mentoria;
import br.com.bootcamp.service.DevService;
import br.com.bootcamp.util.DevPrinter;

import java.time.LocalDate;

public class BootcampApp {

    public static void main(String[] args) {

        // Criação dos conteúdos
        Curso cursoJava = new Curso("Estruturas condicionais em Java", "Descrição...", 10);
        Curso cursoSpring = new Curso("Introdução ao Spring Framework com Spring Boot", "Descrição...", 5);
        Mentoria mentoriaJava = new Mentoria("POO em Java", "Descrição...", LocalDate.now());

        // Criação do bootcamp
        Bootcamp bootcamp = new Bootcamp("Java Developer", "Descrição do bootcamp...");
        bootcamp.adicionarConteudo(cursoJava);
        bootcamp.adicionarConteudo(cursoSpring);
        bootcamp.adicionarConteudo(mentoriaJava);

        // Criação dos devs
        Dev devJoao = new Dev("\nJoão das Tantas");
        Dev devMaria = new Dev("\nMaria de Jesus");

        // Instanciando o serviço
        DevService devService = new DevService();

        // Inscrições e progresso
        devService.inscreverBootcamp(devJoao, bootcamp);
        devService.inscreverBootcamp(devMaria, bootcamp);

        devService.progredir(devJoao); // João conclui 1 conteúdo
        devService.progredir(devJoao); // João conclui 1 conteúdo
        devService.progredir(devMaria); // Maria conclui 1 conteúdo

        // Impressão dos conteúdos
        bootcamp.getDevs().forEach(DevPrinter::imprimir);
    }
}
