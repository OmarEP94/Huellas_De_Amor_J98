package com.certus.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity

@Table(name = "sucursal")

public class Sucursal {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSucursal;

    @Size(min = 1, max = 2, message = "La Identidad debe tener de 1 a 2 numeros")
    private String identi;

    @NotEmpty(message = "Agregue la sucursal correcta")
    private String sucur;

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getIdenti() {
        return identi;
    }

    public void setIdenti(String identi) {
        this.identi = identi;
    }

    public String getSucur() {
        return sucur;
    }

    public void setSucur(String sucur) {
        this.sucur = sucur;
    }

}
