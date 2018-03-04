package com.rwsoftware.tasklist.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class SituacaoTarefa {
    public static final Long PENDENTE = 1L;
    public static final Long CONCLUIDO = 2L;
    
    
    @Id
    private Long idSituacaoTarefa;
    
    @NotEmpty
    private String situacao;

    
    public Long getIdSituacaoTarefa() {
        return idSituacaoTarefa;
    }

    
    public void setIdSituacaoTarefa(Long idSituacaoTarefa) {
        this.idSituacaoTarefa = idSituacaoTarefa;
    }

    
    public String getSituacao() {
        return situacao;
    }

    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idSituacaoTarefa == null) ? 0 : idSituacaoTarefa.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SituacaoTarefa other = (SituacaoTarefa) obj;
        if (idSituacaoTarefa == null) {
            if (other.idSituacaoTarefa != null)
                return false;
        } else if (!idSituacaoTarefa.equals(other.idSituacaoTarefa))
            return false;
        return true;
    }
    
    
}
