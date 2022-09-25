package com.artemisacademy.demoartemisacademy.models;

import javax.persistence.*;

@Entity
@Table(name = "servicios")
public class ServiciosModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)

  private Integer id;
  private String descripcion;
  private Integer precio;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setPrecio(Integer precio) {
    this.precio = precio;
  }

  public Integer getPrecio() {
    return precio;
  }

}