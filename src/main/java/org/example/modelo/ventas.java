package org.example.modelo;

import java.time.LocalDate;

public class ventas {
    private Integer idventa;
    private LocalDate fechaventa;
    private Integer montototal;
    private String estado;
    private String canaldeventa;

    public ventas() {
    }

    public ventas(Integer idventa, LocalDate fechaventa, Integer montototal, String estado, String canaldeventa) {
        this.idventa = idventa;
        this.fechaventa = fechaventa;
        this.montototal = montototal;
        this.estado = estado;
        this.canaldeventa = canaldeventa;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public LocalDate getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(LocalDate fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Integer getMontototal() {
        return montototal;
    }

    public void setMontototal(Integer montototal) {
        this.montototal = montototal;
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
