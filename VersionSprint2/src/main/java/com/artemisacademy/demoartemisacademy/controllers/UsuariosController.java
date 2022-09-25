package com.artemisacademy.demoartemisacademy.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.artemisacademy.demoartemisacademy.models.TipoUsuarioModel;
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

    @PostMapping("/micropigmentadora")
    public void guardarUsuarioMicropigmentadora(@ModelAttribute("nuevaMicropigmentadora") UsuariosModel usuario,
            HttpServletResponse httpResponse) throws IOException {
        TipoUsuarioModel tipoUsuarioModel = new TipoUsuarioModel();
        Integer idMicropigmentadoras = 2;
        tipoUsuarioModel.setId(idMicropigmentadoras);
        usuario.setTipoUsuarioModel(tipoUsuarioModel);

        this.usuariosService.guardarUsuario(usuario);
        httpResponse.sendRedirect("/administrador");
    }

    @PostMapping("/cliente")
    public void guardarUsuarioCliente(@ModelAttribute("nuevoCliente") UsuariosModel usuario,
            HttpServletResponse httpResponse) throws IOException {
        TipoUsuarioModel tipoUsuarioModel = new TipoUsuarioModel();
        Integer idCliente = 1;
        tipoUsuarioModel.setId(idCliente);
        usuario.setTipoUsuarioModel(tipoUsuarioModel);

        this.usuariosService.guardarUsuario(usuario);
        httpResponse.sendRedirect("/registroExitoso");
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuariosModel> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        return this.usuariosService.obtenerPorId(id);
    }
}
