package com.Tarefas.to_do_list.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank
    private String password;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "^(\\d{3}\\.){2}\\d{3}-\\d{2}$", message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "O email é obrigatório")
    private String email;

    public String getCpf() {
        return this.cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String pass) {
         this.password = pass;
    }
}
