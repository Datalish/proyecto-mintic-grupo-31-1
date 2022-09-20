package com.artemisacademy.demoartemisacademy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artemisacademy.demoartemisacademy.models.UsuariosModel;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel, Integer> {
  public UsuariosModel findByCorreo(String correo);
}