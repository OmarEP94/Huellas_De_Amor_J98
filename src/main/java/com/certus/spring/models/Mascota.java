package com.certus.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mascota")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascota;

	@NotEmpty(message = "Completar el nombre del mascota")
	private String nombrepets;

	@Size(min = 1, max = 3, message = "El alias debe tener 1 caracter y maximo de 3")
	@NotEmpty(message = "Ingrese la edad de la mascota")
	private String edad;

	private String edadtipo;

	private String fecha;

	@NotEmpty(message = "Ingrese la raza")
	private String raza;

	@NotEmpty(message = "Ingrese la tipo de mascota (Perro, Gato, Etc.)")
	private String tipo;

	@NotEmpty(message = "Ingrese la descripción de la mascota")
	private String descripcion;

	private String estado;

	private String uriImagen;

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombrepets() {
		return nombrepets;
	}

	public void setNombrepets(String nombrepets) {
		this.nombrepets = nombrepets;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUriImagen() {
		return uriImagen;
	}

	public void setUriImagen(String uriImagen) {
		this.uriImagen = uriImagen;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEdadtipo() {
		return edadtipo;
	}

	public void setEdadtipo(String edadtipo) {
		this.edadtipo = edadtipo;
	}

}
