package br.com.bootcamp.model;

import br.com.bootcamp.exception.BootcampException;
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
    private Set<Conteudo> conteudos = new LinkedHashSet();
    private Set<Dev> devs = new LinkedHashSet();

    public Bootcamp(String nome, String descricao) {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setDatas(LocalDate.now(), LocalDate.now().plusDays(45L));
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        } else {
            throw new BootcampException("O nome do bootcamp não pode ser vazio.");
        }
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.isBlank()) {
            this.descricao = descricao;
        } else {
            throw new BootcampException("A descrição do bootcamp não pode ser vazia.");
        }
    }

    public void setDatas(LocalDate inicio, LocalDate fim) {
        if (inicio != null && fim != null) {
            if (inicio.isBefore(LocalDate.now())) {
                throw new BootcampException("A data de início deve ser maior que a data atual.");
            } else if (!fim.isEqual(inicio) && !fim.isBefore(inicio)) {
                this.dataInicio = inicio;
                this.dataFim = fim;
            } else {
                throw new BootcampException("A data de fim não pode ser anterior ou igual à data de início.");
            }
        } else {
            throw new BootcampException("As datas de início e fim não podem ser nulas.");
        }
    }

    public void adicionarConteudo(Conteudo conteudo) {
        if (!this.conteudos.add(conteudo)) {
            throw new BootcampException("Este conteúdo já foi adicionado ao bootcamp.");
        } else {
            this.conteudos.add(conteudo);
        }
    }

    public String getDescricao() {
        return this.descricao;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public Set<Conteudo> getConteudos() {
        return this.conteudos;
    }

    public Set<Dev> getDevs() {
        return this.devs;
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Bootcamp bootcamp = (Bootcamp)o;
            return Objects.equals(this.nome, bootcamp.nome) && Objects.equals(this.descricao, bootcamp.descricao) && Objects.equals(this.dataInicio, bootcamp.dataInicio) && Objects.equals(this.dataFim, bootcamp.dataFim) && Objects.equals(this.conteudos, bootcamp.conteudos) && Objects.equals(this.devs, bootcamp.devs);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.nome, this.descricao, this.dataInicio, this.dataFim, this.conteudos, this.devs});
    }
}
