package com.certus.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMascota;

    @NotEmpty(message = "Agrege el nombre de las nascotita")
    private String nomPets;

    @NotEmpty(message = "Ingresa la raza de la mascota")
    private String raza;

    @NotEmpty(message = "Ingresa el tipo de mascota")
    private String tipo;

    @NotEmpty(message = "Ingreso la fecha de ingreso a nuestro sistema")
    private String fecha;

    @NotEmpty(message = "Ingreso de descripción")
    private String descripcion;

    @NotEmpty(message = "Seleccione si esta apto o no apto")
    private String apto;

    @NotEmpty(message = "Ingrese la imagen")
    private String imagen;

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNomPets() {
        return nomPets;
    }

    public void setNomPets(String nomPets) {
        this.nomPets = nomPets;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
