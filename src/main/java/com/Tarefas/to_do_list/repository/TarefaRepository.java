package com.Tarefas.to_do_list.repository;

import com.Tarefas.to_do_list.domain.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TarefaRepository extends MongoRepository<Tarefa, String> {
    Page<Tarefa> findByUsuarioId(String usuarioId, Pageable pageable);
    Page<Tarefa> findByConcluido(boolean concluido, Pageable pageable);
    Page<Tarefa> findByNaoConcluido(boolean concluido, Pageable pageable);
}
