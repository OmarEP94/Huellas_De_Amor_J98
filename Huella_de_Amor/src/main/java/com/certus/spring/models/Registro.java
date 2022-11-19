package com.certus.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reg_adopcion")
public class Registro {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRegistro;
	
	@NotEmpty(message = "Completar el sus nombres y apellidos corectamente")
	private String NomApe;
	
	@Size(min = 8, max = 8, message = "Ingrese los 8 número de su DNI")
	@NotEmpty(message = "Completar el alias del personaje")
	private int Dni;
	
	@NotEmpty(message = "Ingrese su fecha de nacimiento")
	private String Nacimiento;
	
	@NotEmpty(message = "Ingrese su direccion")
	private String Direccion;
	
	@NotEmpty(message = "Ingrese su distrito")
	private String Distrito;
	
	@NotEmpty(message = "Ingrese su estado")
	private String Estado;
	
	@NotEmpty(message = "Ingrese su trabajo actual")
	private String Trabajo;
	
	@NotEmpty(message = "Ingrese el nombre de la mascota de su preferencia")
	private String NomPets;

	@NotEmpty(message = "Active si esta seguro de sus datos")
	private String Check;
	
	public String getCheck() {
		return Check;
	}

	public void setCheck(String check) {
		Check = check;
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getNomApe() {
		return NomApe;
	}

	public void setNomApe(String nomApe) {
		NomApe = nomApe;
	}

	public int getDni() {
		return Dni;
	}

	public void setDni(int dni) {
		Dni = dni;
	}

	public String getNacimiento() {
		return Nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		Nacimiento = nacimiento;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getDistrito() {
		return Distrito;
	}

	public void setDistrito(String distrito) {
		Distrito = distrito;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getTrabajo() {
		return Trabajo;
	}

	public void setTrabajo(String trabajo) {
		Trabajo = trabajo;
	}

	public String getNomPets() {
		return NomPets;
	}

	public void setNomPets(String nomPets) {
		NomPets = nomPets;
	}
	
	
		
	
	
	

}
