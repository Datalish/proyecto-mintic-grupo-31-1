package com.artemisacademy.demoartemisacademy.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioDetails implements UserDetails {
  private UsuariosModel usuariosModel;

  public UsuarioDetails(UsuariosModel usuariosModel) {
    this.usuariosModel = usuariosModel;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    String tipoUsuario = usuariosModel.getTipoUsuarioModel().getTipo();
    Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority(tipoUsuario));

    return authorities;
  }

  @Override
  public String getPassword() {
    return usuariosModel.getClave();
  }

  @Override
  public String getUsername() {
    return usuariosModel.getCorreo();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public String getNombres() {
    return usuariosModel.getNombres();
  }

  public String getApellidos() {
    return usuariosModel.getApellidos();
  }

  public Integer getId() {
    return usuariosModel.getId();
  }

}
