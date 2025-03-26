package com.Tarefas.to_do_list.service;

import com.Tarefas.to_do_list.domain.User;
import com.Tarefas.to_do_list.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User salvarUsuario(@Valid User user) {
        return userRepository.save(user);
    }

    public Optional<User> buscarUsuarioPorId(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> buscarUsuarioPorCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public Optional<User> buscarUsuarioPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deletarUsuario(String id) {
        userRepository.deleteById(id);
    }
}
