package com.pba.invex.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entidad para guardado en la en base de datos
 */
@Entity
@Table(name = "EMPLEADO")
public class Empleado {

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long id_registro;
    @Column(name="priNombre")
    private String priNombre;
    @Column(name="segNombre")
    private String segNombre;
    @Column(name="aPaterno")
    private String aPaterno;
    @Column(name="aMaterno")
    private String aMaterno;
    @Column(name="edad")
    private int edad;
    @Column(name="sexo")
    private String sexo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="fecNacimieno")
    private LocalDate fecNacimieno;
    @Column(name="puesto")
    private String puesto;

    public Long getId_registro() {
        return id_registro;
    }

    public void setId_registro(Long id_registro) {
        this.id_registro = id_registro;
    }

    public String getPriNombre() {
        return priNombre;
    }

    public void setPriNombre(String priNombre) {
        this.priNombre = priNombre;
    }

    public String getSegNombre() {
        return segNombre;
    }

    public void setSegNombre(String segNombre) {
        this.segNombre = segNombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFecNacimieno() {
        return fecNacimieno;
    }

    public void setFecNacimieno(LocalDate fecNacimieno) {
        this.fecNacimieno = fecNacimieno;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
