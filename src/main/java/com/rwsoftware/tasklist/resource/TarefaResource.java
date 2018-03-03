package com.rwsoftware.tasklist.resource;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rwsoftware.tasklist.model.Tarefa;
import com.rwsoftware.tasklist.repository.TarefaRepository;

@RestController
@CrossOrigin(origins = {"${origem-local}", "${origem-github}"})
public class TarefaResource {

    @Autowired
    TarefaRepository tarefaRepository;
    
    @GetMapping("/tarefa")
    public List<Tarefa> listar(){
        return tarefaRepository.findAll();
        
    }
    
    
    @PostMapping("/tarefa")
    public Tarefa adicionar(@RequestBody @Valid Tarefa item) {
        return tarefaRepository.save(item);
        
    }
}
