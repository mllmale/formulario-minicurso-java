package com.Tarefas.to_do_list.controller;

import com.Tarefas.to_do_list.domain.User;
import com.Tarefas.to_do_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> cadastrarUsuario(@RequestBody User user) {
        User novoUsuario = userService.salvarUsuario(user);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> buscarTodosUsuarios() {
        List<User> usuarios = userService.buscarTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<User> buscarUsuarioPorCpf(@PathVariable String cpf) {
        Optional<User> usuario = userService.buscarUsuarioPorCpf(cpf);
        return usuario
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/cpf/{cpf}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String cpf) {
        userService.deletarUsuario(cpf);
        return ResponseEntity.noContent().build();
    }
    
}