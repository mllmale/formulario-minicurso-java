package com.Tarefas.to_do_list.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String password;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "^(\\d{3}\\.){2}\\d{3}-\\d{2}$", message = "CPF inválido")
    private String cpf; // O CPF é um campo obrigatório e deve ser validado com regex

    @NotBlank(message = "O email é obrigatório")
    private String email;

    private String usuarioId; // Pode ser usado para associar o usuário à tarefa, por exemplo

    public User(Object o, String nome, String cpf, String email, Object o1) {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }
}
