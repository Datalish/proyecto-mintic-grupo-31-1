package com.artemisacademy.demoartemisacademy.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.artemisacademy.demoartemisacademy.models.UsuariosModel;
import com.artemisacademy.demoartemisacademy.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UsuariosService usuariosService;

    @GetMapping()
    public ArrayList<UsuariosModel> obtenerUsuarios() {
        return usuariosService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuariosModel guardarUsuario(@RequestBody UsuariosModel usuario) {
        return this.usuariosService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuariosModel> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        return this.usuariosService.obtenerPorId(id);
    }
}
