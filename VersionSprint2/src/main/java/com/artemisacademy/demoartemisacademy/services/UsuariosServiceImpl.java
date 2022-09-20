package com.artemisacademy.demoartemisacademy.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.artemisacademy.demoartemisacademy.models.UsuarioDetails;
import com.artemisacademy.demoartemisacademy.models.UsuariosModel;
import com.artemisacademy.demoartemisacademy.repositories.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {
  @Autowired
  private UsuariosRepository usuariosRepository;
  @Lazy
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public ArrayList<UsuariosModel> obtenerUsuarios() {
    return (ArrayList<UsuariosModel>) usuariosRepository.findAll();
  }

  @Override
  public UsuariosModel guardarUsuario(UsuariosModel usuario) {
    System.out.println(usuario.getClave());
    usuario.setClave(passwordEncoder.encode(usuario.getClave()));
    return usuariosRepository.save(usuario);
  }

  @Override
  public Optional<UsuariosModel> obtenerPorId(Integer id) {
    return usuariosRepository.findById(id);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UsuariosModel usuario = usuariosRepository.findByCorreo(username);
    if (usuario == null) {
      throw new UsernameNotFoundException("Usuario o contraseña incorrectas.");
    }

    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority(usuario.getTipoUsuarioModel().getTipo()));
    System.out.println(new User(usuario.getCorreo(), usuario.getClave(), authorities));
    return new UsuarioDetails(usuario);
  }

}