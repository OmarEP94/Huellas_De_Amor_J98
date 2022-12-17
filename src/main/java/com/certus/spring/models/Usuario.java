package com.certus.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity

@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @NotEmpty(message = "Complete sus nombres y apellidos")
    private String nomape;

    @NotEmpty(message = "Ingrese su usuario")
    private String usuario;

    @NotEmpty(message = "Ingrese su correo electronico")
    private String correo;

    @Size(min = 8, max = 8, message = "El debe tener 8 números")
    // @NotEmpty(message = "Ingrese su numero de DNI")
    private String dni;

    @Size(min = 6, max = 16, message = "El debe tener 6 caracteres")
    // @NotEmpty(message = "Ingrese su numero de DNI")
    private String contrasena;

    private String fechanac;

    @NotEmpty(message = "Ingrese su dirección actual correctamente")
    private String direccion;

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
