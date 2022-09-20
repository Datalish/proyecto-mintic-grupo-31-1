package com.artemisacademy.demoartemisacademy.controllers;

import java.util.ArrayList;

import com.artemisacademy.demoartemisacademy.models.TipoUsuarioModel;
import com.artemisacademy.demoartemisacademy.services.TipoUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TipoUsuario")
@CrossOrigin(origins = "")
public class TipoUsuarioController {
    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @GetMapping()
    public ArrayList<TipoUsuarioModel> obtenertipousuario() {
        return tipoUsuarioService.obtenertipousuario();
    }

    @PostMapping()
    public TipoUsuarioModel guardartipousuario(@RequestBody TipoUsuarioModel tipousuario) {
        return this.tipoUsuarioService.guardartipousuario(tipousuario);

    }

}
