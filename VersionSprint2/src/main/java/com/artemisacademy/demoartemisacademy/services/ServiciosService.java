package com.artemisacademy.demoartemisacademy.services;

import java.util.List;

import com.artemisacademy.demoartemisacademy.models.ServiciosModel;
import com.artemisacademy.demoartemisacademy.repositories.ServiciosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosService {
  @Autowired
  ServiciosRepository serviciosRepository;

  public List<ServiciosModel> obtenerServicios() {
    return (List<ServiciosModel>) serviciosRepository.findAll();
  }

  public ServiciosModel guardarServicios(ServiciosModel servicios) {
    return serviciosRepository.save(servicios);
  }

}
