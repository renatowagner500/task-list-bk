package com.rwsoftware.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rwsoftware.tasklist.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    Tarefa findByIdTarefa(Long idTarefa);
}
