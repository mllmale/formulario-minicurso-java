package com.Tarefas.to_do_list.service;

import com.Tarefas.to_do_list.domain.Tarefa;
import com.Tarefas.to_do_list.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvarTarefa(@Valid Tarefa tarefa) {
        if (tarefa.getDataCriacao() == null) {
            tarefa.setDataCriacao(LocalDateTime.now());
        }
        return tarefaRepository.save(tarefa);
    }

    public Optional<Tarefa> buscarTarefaPorId(String id) {
        return tarefaRepository.findById(id);
    }

    public Page<Tarefa> listarTarefasPorUsuario(String usuarioId, Pageable pageable) {
        return tarefaRepository.findByUsuarioId(usuarioId, pageable);
    }

    public Page<Tarefa> listarTarefasPorConclusao(boolean concluido, Pageable pageable) {
        return tarefaRepository.findByConcluido(concluido, pageable);
    }

    public void deletarTarefa(String id) {
        tarefaRepository.deleteById(id);
    }
}