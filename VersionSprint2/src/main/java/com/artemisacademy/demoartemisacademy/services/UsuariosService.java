package com.artemisacademy.demoartemisacademy.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.artemisacademy.demoartemisacademy.models.UsuariosModel;

@Service
public interface UsuariosService extends UserDetailsService {
    public ArrayList<UsuariosModel> obtenerUsuarios();

    public UsuariosModel guardarUsuario(UsuariosModel usuario);

    public Optional<UsuariosModel> obtenerPorId(Integer id);

    public UsuariosModel obtenerMicropigmentadoraAleatoria(Integer idTipoUsuario);

}