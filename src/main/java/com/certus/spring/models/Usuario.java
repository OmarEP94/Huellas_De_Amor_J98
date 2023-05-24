package com.certus.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity

@Table(name = "usuario")
public class Usuario {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @NotEmpty(message = "Ingrese sus datos correctamente")
    private String nomape;

    @NotEmpty(message = "Ingrese su usuario correctamente")
    private String usuariox;

    @NotEmpty(message = "Ingrese su contraseña correctamente")
    private String contrasena;

    // @NotEmpty(message = "Seleccione una sucursal")
    private String sucursal;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomape() {
        return nomape;
    }

    public void setNomape(String nomape) {
        this.nomape = nomape;
    }

    public String getUsuariox() {
        return usuariox;
    }

    public void setUsuariox(String usuariox) {
        this.usuariox = usuariox;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

}
