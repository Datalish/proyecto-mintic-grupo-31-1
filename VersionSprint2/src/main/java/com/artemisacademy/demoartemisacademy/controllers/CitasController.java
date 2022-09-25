package com.artemisacademy.demoartemisacademy.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.artemisacademy.demoartemisacademy.models.CitasModel;
import com.artemisacademy.demoartemisacademy.models.UsuarioDetails;
import com.artemisacademy.demoartemisacademy.models.UsuariosModel;
import com.artemisacademy.demoartemisacademy.services.CitasService;
import com.artemisacademy.demoartemisacademy.services.UsuariosService;

@RestController
@RequestMapping("/citas")
public class CitasController {

  @Autowired
  CitasService citasService;

  @Autowired
  UsuariosService usuariosService;

  @GetMapping()
  public ArrayList<CitasModel> obtenerCitas() {
    return citasService.obtenerCitas();
  }

  @PostMapping()
  public void guardarCitas(@ModelAttribute("nuevaCita") CitasModel citas,
      @AuthenticationPrincipal UsuarioDetails user, HttpServletResponse httpResponse) throws IOException {
    UsuariosModel clienteModel = new UsuariosModel();
    UsuariosModel micropigmentadoraModel = new UsuariosModel();

    Integer idMicropigmentadora = 2;
    micropigmentadoraModel = usuariosService.obtenerMicropigmentadoraAleatoria(idMicropigmentadora);
    citas.setClienteModels(clienteModel);
    citas.setMicropigmentadoraModel(micropigmentadoraModel);

    citas.getClienteModel().setId(user.getId()); /* Aqui se registra el ID del cliente que reservo una cita */
    this.citasService.guardarCitas(citas);
    httpResponse.sendRedirect("/cliente");
  }

  @GetMapping(path = "/{id}")
  public Optional<CitasModel> obtenerCitaPorId(@PathVariable("id") Integer id) {
    return this.citasService.obtenerPorId(id);
  }
}
