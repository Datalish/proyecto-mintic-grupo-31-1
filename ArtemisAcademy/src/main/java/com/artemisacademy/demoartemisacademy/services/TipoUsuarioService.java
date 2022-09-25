package com.artemisacademy.demoartemisacademy.services;

import java.util.ArrayList;

import com.artemisacademy.demoartemisacademy.models.TipoUsuarioModel;
import com.artemisacademy.demoartemisacademy.repositories.TipoUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {
    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;
    
    public ArrayList<TipoUsuarioModel> obtenertipousuario(){
       return(ArrayList<TipoUsuarioModel>) tipoUsuarioRepository.findAll();
    }

    public TipoUsuarioModel guardartipousuario(TipoUsuarioModel usuario){
        return tipoUsuarioRepository.save(usuario);
    }
    
}
