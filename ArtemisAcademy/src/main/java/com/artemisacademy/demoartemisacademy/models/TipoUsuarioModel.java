package com.artemisacademy.demoartemisacademy.models;

import javax.persistence.*;

@Entity
@Table(name = "tipoUsuarios")
public class TipoUsuarioModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)

  private Integer id;
  private String tipo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}