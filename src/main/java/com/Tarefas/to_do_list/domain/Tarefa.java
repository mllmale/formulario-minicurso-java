
package com.Tarefas.to_do_list.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    private String id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    private String descricao;
    private boolean concluido;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private String usuarioId;
}

