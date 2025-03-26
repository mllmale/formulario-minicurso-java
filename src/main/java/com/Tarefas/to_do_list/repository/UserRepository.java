package com.Tarefas.to_do_list.repository;

import com.Tarefas.to_do_list.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByCpf(String cpf); // Método para buscar usuário por CPF
    Optional<User> findByEmail(String email); // Método para buscar usuário por Email
}
