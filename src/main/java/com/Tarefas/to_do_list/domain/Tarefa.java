package com.Tarefas.to_do_list.domain;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "tarefas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
    @Id
    private String id;

    private String titulo;
    private String descricao;
    private boolean concluido;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private String idUser; //para se relacionar com o usuário

}
