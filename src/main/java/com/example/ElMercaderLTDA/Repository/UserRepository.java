package com.example.ElMercaderLTDA.Repository;

import com.example.ElMercaderLTDA.Model.User;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer>{
    
    // Encontrar por email digitado
    // @Query("SELECT * FROM User WHERE EMAIL = email")
    Optional<User> getUserByEmail(String email);

    // Encontrar por email y contraseña
    // @Query("SELECT * FROM User WHERE EMAIL AND PASSWORD = email, password")
    Optional<User> getUserByEmailAndPassword(String email, String password);
    
}
