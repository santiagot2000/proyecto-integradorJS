package org.example.modelo;

public class servicio {
    private Integer idservicio;
    private String nombreser;
    private String observaciones;
    private Integer precio;
    private String duracion;

    public servicio() {
    }

    public servicio(Integer idservicio, String nombreser, String observaciones, Integer precio, String duracion) {
        this.idservicio = idservicio;
        this.nombreser = nombreser;
        this.observaciones = observaciones;
        this.precio = precio;
        this.duracion = duracion;
    }

    public Integer getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombreser() {
        return nombreser;
    }

    public void setNombreser(String nombreser) {
        this.nombreser = nombreser;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
