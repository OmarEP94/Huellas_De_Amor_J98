
/*
 * package com.certus.spring.models;
 * 
 * import javax.persistence.Entity;
 * import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType;
 * import javax.persistence.Id;
 * import javax.persistence.Table;
 * import javax.validation.constraints.NotEmpty;
 * import javax.validation.constraints.Size;
 * 
 * @Entity
 * 
 * @Table(name = "registro")
 * public class Registro {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * private int idRegistro;
 * 
 * @NotEmpty(message = "Complete sus nombres y apellidos")
 * private String nomape;
 * 
 * @Size(min = 8, max = 8, message = "El debe tener 8 números")
 * 
 * @NotEmpty(message = "Ingrese su numero de DNI")
 * private String dni;
 * 
 * @NotEmpty(message = "Ingrese su edad")
 * private String edad;
 * 
 * private String fechanac;
 * 
 * @NotEmpty(message = "Ingrese su correo electronico")
 * private String correo;
 * 
 * @NotEmpty(message = "Ingrese su direccion actual correctamente")
 * private String direccion;
 * 
 * @NotEmpty(message = "Ingrese su estado (Aptop o No Apto)")
 * private String estado;
 * 
 * @NotEmpty(message = "Ingrese cual es su trabajo actual")
 * private String trabajo;
 * 
 * @NotEmpty(message = "Ingrese el nombre de la mascota de su preferencia")
 * private String nompets;
 * 
 * @NotEmpty(message = "Seleccione si esta conforme toda la informacion")
 * private String check;
 * 
 * public int getIdRegistro() {
 * return idRegistro;
 * }
 * 
 * public void setIdRegistro(int idRegistro) {
 * this.idRegistro = idRegistro;
 * }
 * 
 * public String getNomape() {
 * return nomape;
 * }
 * 
 * public void setNomape(String nomape) {
 * this.nomape = nomape;
 * }
 * 
 * public String getDni() {
 * return dni;
 * }
 * 
 * public void setDni(String dni) {
 * this.dni = dni;
 * }
 * 
 * public String getEdad() {
 * return edad;
 * }
 * 
 * public void setEdad(String edad) {
 * this.edad = edad;
 * }
 * 
 * public String getFechanac() {
 * return fechanac;
 * }
 * 
 * public void setFechanac(String fechanac) {
 * this.fechanac = fechanac;
 * }
 * 
 * public String getCorreo() {
 * return correo;
 * }
 * 
 * public void setCorreo(String correo) {
 * this.correo = correo;
 * }
 * 
 * public String getDireccion() {
 * return direccion;
 * }
 * 
 * public void setDireccion(String direccion) {
 * this.direccion = direccion;
 * }
 * 
 * public String getEstado() {
 * return estado;
 * }
 * 
 * public void setEstado(String estado) {
 * this.estado = estado;
 * }
 * 
 * public String getTrabajo() {
 * return trabajo;
 * }
 * 
 * public void setTrabajo(String trabajo) {
 * this.trabajo = trabajo;
 * }
 * 
 * public String getNompets() {
 * return nompets;
 * }
 * 
 * public void setNompets(String nompets) {
 * this.nompets = nompets;
 * }
 * 
 * public String getCheck() {
 * return check;
 * }
 * 
 * public void setCheck(String check) {
 * this.check = check;
 * }
 * 
 * }
 */