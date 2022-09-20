package com.artemisacademy.demoartemisacademy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artemisacademy.demoartemisacademy.models.CitasModel;
import com.artemisacademy.demoartemisacademy.repositories.CitasRepository;

@Service
public class CitasService {

  @Autowired
  CitasRepository citasRepository;

  public ArrayList<CitasModel> obtenerCitas() {
    return (ArrayList<CitasModel>) citasRepository.findAll();
  }

  public CitasModel guardarCitas(CitasModel citas) {
    return citasRepository.save(citas);
  }

  public Optional<CitasModel> obtenerPorId(Integer id) {
    return citasRepository.findById(id);
  }

  public List<CitasModel> buscarCitasUsuario(Integer idUsuario) {
    return citasRepository.buscarCitasUsuario(idUsuario);
  }

}