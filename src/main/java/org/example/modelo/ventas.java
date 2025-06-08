package org.example.modelo;

import java.time.LocalDate;

public class ventas {
    private Integer idventa;
    private LocalDate fecha;
    private Integer valor;
    private String estado;
    private String canaldeventa;

    public ventas() {
    }

    public ventas(Integer idventa, LocalDate fecha, Integer valor, String estado, String canaldeventa) {
        this.idventa = idventa;
        this.fecha = fecha;
        this.valor = valor;
        this.estado = estado;
        this.canaldeventa = canaldeventa;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCanaldeventa() {
        return canaldeventa;
    }

    public void setCanaldeventa(String canaldeventa) {
        this.canaldeventa = canaldeventa;
    }
}
