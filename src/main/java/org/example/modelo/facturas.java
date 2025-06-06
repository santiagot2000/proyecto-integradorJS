package org.example.modelo;

import java.time.LocalDate;

public class facturas {
    private Integer nrofactura;
    private String nombreser;
    private Integer idusuario;
    private LocalDate fecha;
    private Integer valor;

    public facturas() {
    }

    public facturas(Integer nrofactura, String nombreser, Integer idusuario, LocalDate fecha, Integer valor) {
        this.nrofactura = nrofactura;
        this.nombreser = nombreser;
        this.idusuario = idusuario;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Integer getNrofactura() {
        return nrofactura;
    }

    public void setNrofactura(Integer nrofactura) {
        this.nrofactura = nrofactura;
    }

    public String getNombreser() {
        return nombreser;
    }

    public void setNombreser(String nombreser) {
        this.nombreser = nombreser;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idpusuario) {
        this.idusuario = idpusuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
