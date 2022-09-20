package com.artemisacademy.demoartemisacademy.models;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String correo;
    private String clave;

    @OneToOne()
    @JoinColumn(name = "idTipoUsuario", referencedColumnName = "id")
    private TipoUsuarioModel tipoUsuarioModel;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public TipoUsuarioModel getTipoUsuarioModel() {
        return tipoUsuarioModel;
    }
}