package org.example.modelo;

import java.time.LocalDate;

public class facturas {
    private Integer nrofactura;
    private String nombreser;
    private String idpusuario;
    private LocalDate fecha;
    private Integer valor;

    public facturas() {
    }

    public facturas(Integer nrofactura, String nombreser, String idpusuario, LocalDate fecha, Integer valor) {
        this.nrofactura = nrofactura;
        this.nombreser = nombreser;
        this.idpusuario = idpusuario;
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

    public String getIdpusuario() {
        return idpusuario;
    }

    public void setIdpusuario(String idpusuario) {
        this.idpusuario = idpusuario;
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
