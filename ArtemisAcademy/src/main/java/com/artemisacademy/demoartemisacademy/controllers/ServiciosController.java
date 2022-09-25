package com.artemisacademy.demoartemisacademy.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
  public List<ServiciosModel> obtenerServicios() {
    return serviciosService.obtenerServicios();
  }

  @PostMapping()
  public void guardarServicios(@ModelAttribute("nuevoServicio") ServiciosModel servicios,
      HttpServletResponse httpResponse) throws IOException {
    this.serviciosService.guardarServicios(servicios);
    httpResponse.sendRedirect("/administrador");
  }

}
