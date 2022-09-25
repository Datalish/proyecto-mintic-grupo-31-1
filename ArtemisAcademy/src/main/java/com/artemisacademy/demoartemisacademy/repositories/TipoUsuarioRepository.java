package com.artemisacademy.demoartemisacademy.repositories;

import com.artemisacademy.demoartemisacademy.models.TipoUsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoUsuarioRepository extends CrudRepository<TipoUsuarioModel, Integer> {
    
}
