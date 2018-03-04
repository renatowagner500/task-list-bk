package com.rwsoftware.tasklist.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefa;

    @NotEmpty
    private String titulo;

    private String descricao;

    private LocalDate dataCriacao;

    private LocalDate dataEdicao;

    private LocalDate dataConclusao;

    @ManyToOne
    private SituacaoTarefa situacaoTarefa;

    public Long getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(LocalDate dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTarefa == null) ? 0 : idTarefa.hashCode());
        return result;
    }

    public SituacaoTarefa getSituacaoTarefa() {
        return situacaoTarefa;
    }
    
    public void setSituacaoTarefa(SituacaoTarefa situacaoTarefa) {
        this.situacaoTarefa = situacaoTarefa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefa other = (Tarefa) obj;
        if (idTarefa == null) {
            if (other.idTarefa != null)
                return false;
        } else if (!idTarefa.equals(other.idTarefa))
            return false;
        return true;
    }


}
