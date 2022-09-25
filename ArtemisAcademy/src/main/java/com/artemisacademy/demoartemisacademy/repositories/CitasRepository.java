package com.artemisacademy.demoartemisacademy.repositories;

import com.artemisacademy.demoartemisacademy.models.CitasModel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasRepository extends CrudRepository<CitasModel, Integer> {
  @Query("SELECT c FROM CitasModel c INNER JOIN c.servicioModels s INNER JOIN c.micropigmentadoraModel m INNER JOIN c.clienteModel cm WHERE cm.id = ?1")
  List<CitasModel> buscarCitasUsuarioCliente(Integer idUsuarioCliente);

  @Query("SELECT c FROM CitasModel c INNER JOIN c.servicioModels s INNER JOIN c.micropigmentadoraModel m INNER JOIN c.clienteModel cm WHERE m.id = ?1")
  List<CitasModel> buscarCitasUsuarioMicropigmentadora(Integer idUsuarioMicropigmentadora);
}
