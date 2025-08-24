package br.com.bootcamp.model;

import br.com.bootcamp.exception.BootcampException;
import br.com.bootcamp.exception.ConteudoException;
import br.com.bootcamp.model.conteudo.Conteudo;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Set<Conteudo> conteudos = new LinkedHashSet<>();
    private Set<Dev> devs = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        setNome(nome);
        setDescricao(descricao);
        setDatas(LocalDate.now(), LocalDate.now().plusDays(45));
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new BootcampException("O nome do bootcamp não pode ser vazio.");
        }

        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new BootcampException("A descrição do bootcamp não pode ser vazia.");
        }

        this.descricao = descricao;
    }

    public void setDatas(LocalDate inicio, LocalDate fim) {
        if (inicio == null || fim == null) {
            throw new BootcampException("As datas de início e fim não podem ser nulas.");
        }

        if (inicio.isBefore(LocalDate.now())) {
            throw new BootcampException("A data de início deve ser maior que a data atual.");
        }

        if (fim.isEqual(inicio) || fim.isBefore(inicio)) {
            throw new BootcampException("A data de fim não pode ser anterior ou igual à data de início.");
        }

        this.dataInicio = inicio;
        this.dataFim = fim;
    }

    public void adicionarConteudo(Conteudo conteudo) {
        if (!conteudos.add(conteudo)) {
            throw new BootcampException("Este conteúdo já foi adicionado ao bootcamp.");
        }

        conteudos.add(conteudo);
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public Set<Dev> getDevs() {
        return devs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicio, bootcamp.dataInicio) && Objects.equals(dataFim, bootcamp.dataFim) && Objects.equals(conteudos, bootcamp.conteudos) && Objects.equals(devs, bootcamp.devs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicio, dataFim, conteudos, devs);
    }
}
