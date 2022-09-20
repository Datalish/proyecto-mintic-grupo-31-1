package com.artemisacademy.demoartemisacademy.services;

import java.util.ArrayList;

import com.artemisacademy.demoartemisacademy.models.ServiciosModel;
import com.artemisacademy.demoartemisacademy.repositories.ServiciosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosService {
  @Autowired
  ServiciosRepository serviciosRepository;

  public ArrayList<ServiciosModel> obtenerServicios() {
    return (ArrayList<ServiciosModel>) serviciosRepository.findAll();
  }

  public ServiciosModel guardarUsuario(ServiciosModel servicios) {
    return serviciosRepository.save(servicios);
  }

}
