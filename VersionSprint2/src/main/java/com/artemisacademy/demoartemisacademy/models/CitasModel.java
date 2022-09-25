package com.artemisacademy.demoartemisacademy.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "citas")
public class CitasModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Integer id;

  private Date fecha;
  private String hora;

  @OneToOne
  @JoinColumn(name = "idCliente", referencedColumnName = "id")
  private UsuariosModel clienteModel;

  @OneToOne
  @JoinColumn(name = "idMicropigmentadora", referencedColumnName = "id")
  private UsuariosModel micropigmentadoraModel;

  @OneToOne
  @JoinColumn(name = "idServicio", referencedColumnName = "id")
  private ServiciosModel servicioModels;

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Date getFecha() {
    return fecha;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public void setServicioModels(ServiciosModel servicioModels) {
    this.servicioModels = servicioModels;
  }

  public void setClienteModels(UsuariosModel clientesModel) {
    this.clienteModel = clientesModel;
  }

  public void setMicropigmentadoraModel(UsuariosModel micropigmentadoraModel) {
    this.micropigmentadoraModel = micropigmentadoraModel;
  }

  public ServiciosModel getServicioModels() {
    return servicioModels;
  }

  public UsuariosModel getMicropigmentadoraModel() {
    return micropigmentadoraModel;
  }

  public UsuariosModel getClienteModel() {
    return clienteModel;
  }

}
