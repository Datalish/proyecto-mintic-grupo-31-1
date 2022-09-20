package com.artemisacademy.demoartemisacademy.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.artemisacademy.demoartemisacademy.models.CitasModel;

import com.artemisacademy.demoartemisacademy.services.CitasService;

@RestController
@RequestMapping("/citas")
public class CitasController {

  @Autowired
  CitasService citasService;

  @GetMapping()
  public ArrayList<CitasModel> obtenerCitas() {
    return citasService.obtenerCitas();
  }

  @PostMapping()
  public CitasModel guardarCitas(@RequestBody CitasModel citas) {
    return this.citasService.guardarCitas(citas);
  }

  @GetMapping(path = "/{id}")
  public Optional<CitasModel> obtenerCitaPorId(@PathVariable("id") Integer id) {
    return this.citasService.obtenerPorId(id);
  }
}
