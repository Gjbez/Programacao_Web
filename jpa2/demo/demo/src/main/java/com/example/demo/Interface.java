package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class Interface {

    @Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> { }
    
}
