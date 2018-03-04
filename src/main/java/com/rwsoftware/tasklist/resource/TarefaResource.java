package com.rwsoftware.tasklist.resource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rwsoftware.tasklist.model.SituacaoTarefa;
import com.rwsoftware.tasklist.model.Tarefa;
import com.rwsoftware.tasklist.repository.TarefaRepository;

@RestController
@CrossOrigin(origins = { "${origem-local}", "${origem-github}" })
public class TarefaResource {

    @Autowired
    TarefaRepository tarefaRepository;

    @GetMapping("/tarefa")
    public List<Tarefa> listar() {
        return tarefaRepository.findAll();

    }

    @GetMapping("/tarefa/{id}")
    public Optional<Tarefa> pesquisarPorId(@PathVariable Long id) {
        return tarefaRepository.findById(id);

    }

    @DeleteMapping("/tarefa/{id}")
    public void excluirPorId(@PathVariable Long id) {
        Tarefa tarefa = new Tarefa();
        tarefa.setIdTarefa(id);
        tarefaRepository.delete(tarefa);

    }

    @PutMapping("/tarefaConcluir")
    public void concluir(@RequestBody @Valid Tarefa tarefa) {
        SituacaoTarefa situacaoTarefa = new SituacaoTarefa();
        situacaoTarefa.setIdSituacaoTarefa(SituacaoTarefa.CONCLUIDO);
        tarefa.setDataConclusao(LocalDate.now());
        tarefa.setSituacaoTarefa(situacaoTarefa);
        tarefaRepository.save(tarefa);
    }
    @PutMapping("/tarefa")
    public void alterar(@RequestBody @Valid Tarefa tarefa) {
        tarefa.setDataEdicao(LocalDate.now());
        tarefaRepository.save(tarefa);
    }

    @PostMapping("/tarefa")
    public Tarefa adicionar(@RequestBody @Valid Tarefa tarefa) {
        SituacaoTarefa situacaoTarefa = new SituacaoTarefa();
        situacaoTarefa.setIdSituacaoTarefa(SituacaoTarefa.PENDENTE);
        tarefa.setSituacaoTarefa(situacaoTarefa);
        tarefa.setDataCriacao(LocalDate.now());
        return tarefaRepository.save(tarefa);

    }
}
