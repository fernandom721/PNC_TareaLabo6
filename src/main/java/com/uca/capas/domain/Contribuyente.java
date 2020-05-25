package com.uca.capas.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {

    @Id()
    @Column(name = "c_contribuyentes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_contribuyente;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_importancia")
    private Importancia importancia;

    @Column(name = "s_nombre")
    @Size(max= 30, message = "El campo no debe de tener mas de 30 caracteres")
    private String s_nombre;

    @Column(name = "s_apellido")
    @Size(max= 30, message = "El campo no debe de tener mas de 30 caracteres")
    private String s_apellido;

    @Column(name = "s_nit")
    @Size(max= 14, message = "El campo no debe de tener mas de 14 caracteres")
    private int s_nit;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "f_fecha_ingreso")
    private Date f_fecha_ingreso;

    public Contribuyente () { }

    public Integer getC_contribuyente() {
        return c_contribuyente;
    }

    public void setC_contribuyente(Integer c_contribuyente) {
        this.c_contribuyente = c_contribuyente;
    }
/*
    public int getC_importancia() {
        return c_importancia;
    }

    public void setC_importancia(int c_importancia) {
        this.c_importancia = c_importancia;
    }*/

    public Importancia getImportancia() {
        return importancia;
    }

    public void setImportancia(Importancia importancia) {
        this.importancia = importancia;
    }

    public String getS_nombre() {
        return s_nombre;
    }

    public void setS_nombre(String s_nombre) {
        this.s_nombre = s_nombre;
    }

    public String getS_apellido() {
        return s_apellido;
    }

    public void setS_apellido(String s_apellido) {
        this.s_apellido = s_apellido;
    }

    public int getS_nit() {
        return s_nit;
    }

    public void setS_nit(int s_nit) {
        this.s_nit = s_nit;
    }

    public Date getF_fecha_ingreso() {
        return f_fecha_ingreso;
    }

    public void setF_fecha_ingreso(Date f_fecha_ingreso) {
        this.f_fecha_ingreso = f_fecha_ingreso;
    }
}
