package com.Tarefas.to_do_list.domain;

import jakarta.validation.constraints.Email;
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

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "^(\\d{3}\\.){2}\\d{3}-\\d{2}$", message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    private String cep;
    private String rua;
    private String cidade;
    private String estado;
    private String sexo;
}