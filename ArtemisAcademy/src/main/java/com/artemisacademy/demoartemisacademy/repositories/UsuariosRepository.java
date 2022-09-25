package com.artemisacademy.demoartemisacademy.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artemisacademy.demoartemisacademy.models.UsuariosModel;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel, Integer> {
  public UsuariosModel findByCorreo(String correo);

  @Query("SELECT u FROM UsuariosModel u WHERE u.tipoUsuarioModel.id = ?1")
  public ArrayList<UsuariosModel> obtenerMicropigmentadoras(Integer idTipoUsuario);
}