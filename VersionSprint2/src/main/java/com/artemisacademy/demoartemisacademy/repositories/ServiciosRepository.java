package com.artemisacademy.demoartemisacademy.repositories;

import com.artemisacademy.demoartemisacademy.models.ServiciosModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends CrudRepository<ServiciosModel, Long> {

}
