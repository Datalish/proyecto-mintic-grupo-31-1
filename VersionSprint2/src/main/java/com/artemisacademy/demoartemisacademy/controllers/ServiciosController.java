package com.artemisacademy.demoartemisacademy.controllers;

import java.util.ArrayList;

import com.artemisacademy.demoartemisacademy.models.ServiciosModel;
import com.artemisacademy.demoartemisacademy.services.ServiciosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {
  @Autowired
  ServiciosService serviciosService;

  @GetMapping()
  public ArrayList<ServiciosModel> obtenerServicios() {
    return serviciosService.obtenerServicios();
  }

  @PostMapping()
  public ServiciosModel guardarUsuario(@RequestBody ServiciosModel servicios) {
    return this.serviciosService.guardarUsuario(servicios);
  }

}
