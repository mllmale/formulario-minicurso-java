package com.Tarefas.to_do_list.controller;

import com.Tarefas.to_do_list.domain.Tarefa;
import com.Tarefas.to_do_list.dto.TarefaDto;
import com.Tarefas.to_do_list.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody TarefaDto tarefaDto) {
        Tarefa novaTarefa = new Tarefa(
                null,
                tarefaDto.getTitulo(),
                tarefaDto.getDescricao(),
                tarefaDto.isConcluido(), // Agora respeita o valor enviado no DTO
                LocalDateTime.now(), // Define a data de criação automaticamente
                tarefaDto.getDataConclusao(),
                tarefaDto.getUsuarioId()
        );
        return ResponseEntity.ok(tarefaService.salvarTarefa(novaTarefa));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable String id) {
        Optional<Tarefa> tarefa = tarefaService.buscarTarefaPorId(id);
        return tarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Page<Tarefa>> listarTarefasPorUsuario(@PathVariable String usuarioId, Pageable pageable) {
        return ResponseEntity.ok(tarefaService.listarTarefasPorUsuario(usuarioId, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable String id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
