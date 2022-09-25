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
import com.artemisacademy.demoartemisacademy.models.ServiciosModel;
import com.artemisacademy.demoartemisacademy.models.UsuarioDetails;
import com.artemisacademy.demoartemisacademy.models.UsuariosModel;
import com.artemisacademy.demoartemisacademy.repositories.UsuariosRepository;
import com.artemisacademy.demoartemisacademy.services.CitasService;
import com.artemisacademy.demoartemisacademy.services.ServiciosService;

@Controller
@RequestMapping
public class AplicacionController {
  @Autowired
  CitasService citasService;
  @Autowired
  ServiciosService serviciosService;
  @Autowired
  UsuariosRepository usuariosRepository;

  @GetMapping("/login")
  public String abrirPrincipal(Model model, @RequestParam("credenciales") Optional<String> credencialesInvalidas) {
    return "Principal";
  }

  @GetMapping("/registro")
  public String abrirRegistroCliente(Model model) {
    UsuariosModel nuevoCliente = new UsuariosModel();
    model.addAttribute("nuevoCliente", nuevoCliente);
    return "Registro";
  }

  @GetMapping("/registroExitoso")
  public String abrirRegistroExitoso() {
    return "RegistroExitoso";
  }

  @GetMapping("/cliente")
  public String abrirPaginaCliente(Model model, @AuthenticationPrincipal UsuarioDetails user) {
    List<CitasModel> citas = citasService.buscarCitasUsuarioCliente(user.getId());
    List<ServiciosModel> servicios = serviciosService.obtenerServicios();
    CitasModel nuevaCita = new CitasModel();
    model.addAttribute("citas", citas);
    model.addAttribute("servicios", servicios);
    model.addAttribute("nuevaCita", nuevaCita);
    return "Cliente";
  }

  @GetMapping("/administrador")
  public String abrirPaginaAdministrador(Model model) {
    Integer idMicropigmentadoras = 2;

    List<ServiciosModel> servicios = serviciosService.obtenerServicios();
    List<UsuariosModel> micropigmentadoras = usuariosRepository.obtenerMicropigmentadoras(idMicropigmentadoras);
    ServiciosModel nuevoServicio = new ServiciosModel();
    UsuariosModel nuevaMicropigmentadora = new UsuariosModel();

    model.addAttribute("servicios", servicios);
    model.addAttribute("micropigmentadoras", micropigmentadoras);
    model.addAttribute("nuevoServicio", nuevoServicio);
    model.addAttribute("nuevaMicropigmentadora", nuevaMicropigmentadora);
    return "Administrador";
  }

  @GetMapping("/micropigmentadora")
  public String abrirPaginaMicropigmentadora(Model model, @AuthenticationPrincipal UsuarioDetails user) {
    List<CitasModel> citas = citasService.buscarCitasUsuarioMicropigmentadora(user.getId());
    for (CitasModel cita : citas) {
      System.out.println(cita);
    }

    model.addAttribute("citasMicro", citas);
    return "Micropigmentadora";
  }
}
