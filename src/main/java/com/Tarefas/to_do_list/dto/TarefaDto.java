package com.Tarefas.to_do_list.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TarefaDto {

    @NotBlank(message = "O título não pode estar vazio")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres")
    private String titulo;

    private String descricao;
    private boolean concluido;
    private LocalDateTime dataConclusao;
    private String usuarioId;
}
