package com.artemisacademy.demoartemisacademy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artemisacademy.demoartemisacademy.models.CitasModel;
import com.artemisacademy.demoartemisacademy.models.UsuarioDetails;
import com.artemisacademy.demoartemisacademy.services.CitasService;

@Controller
@RequestMapping
public class AplicacionController {
  @Autowired
  CitasService citasService;

  @GetMapping("/login")
  public String abrirPrincipal(Model model, @RequestParam("credenciales") Optional<String> credencialesInvalidas) {

    return "Principal";
  }

  @GetMapping("/cliente")
  public String abrirPaginaCliente(Model model, @AuthenticationPrincipal UsuarioDetails user) {
    List<CitasModel> citas = citasService.buscarCitasUsuario(user.getId());
    model.addAttribute("citas", citas);
    return "Cliente";
  }

  @GetMapping("/administrador")
  public String abrirPaginaAdministrador() {
    return "Administrador";
  }

  @GetMapping("/micropigmentadora")
  public String abrirPaginaMicropigmentadora() {
    return "Micropigmentadora";
  }
}
