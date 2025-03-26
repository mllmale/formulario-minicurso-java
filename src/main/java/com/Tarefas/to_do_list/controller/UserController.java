package com.Tarefas.to_do_list.controller;

import com.Tarefas.to_do_list.domain.User;
import com.Tarefas.to_do_list.dto.UserDto;
import com.Tarefas.to_do_list.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> criarUsuario(@Valid @RequestBody UserDto userDto) {
        User novoUsuario = new User(
                null,
                userDto.getNome(),
                userDto.getCpf(),
                userDto.getEmail(),
                null // Caso o usuário tenha algum ID, você pode adicioná-lo aqui
        );
        return ResponseEntity.ok(userService.salvarUsuario(novoUsuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUsuarioPorId(@PathVariable String id) {
        Optional<User> usuario = userService.buscarUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<User> buscarUsuarioPorCpf(@PathVariable String cpf) {
        Optional<User> usuario = userService.buscarUsuarioPorCpf(cpf);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> buscarUsuarioPorEmail(@PathVariable String email) {
        Optional<User> usuario = userService.buscarUsuarioPorEmail(email);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String id) {
        userService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
