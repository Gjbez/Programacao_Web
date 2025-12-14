package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Interface.UsuarioRepositorio;

public class controller {
    @RestController
    @RequestMapping("/v1/usuarios")
    public class UsuarioController {

        private UsuarioRepositorio usuarioRepositorio;

        public UsuarioController(UsuarioRepositorio usuarioRepositorio) {
            this.usuarioRepositorio = usuarioRepositorio;
        }

        @GetMapping()
        public ResponseEntity getUsuarios() {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepositorio.findAll());
        }
    }
}
