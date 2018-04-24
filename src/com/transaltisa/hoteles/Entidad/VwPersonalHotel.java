package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "VW_PERSONAL_HOTEL",schema = "LOGISTICA")

public class VwPersonalHotel implements Serializable{

    @Id
    @Column(name = "PERSONAL_RELEVO_ID")
    private Long personalRelevoId;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "HOTEL_NOMBRE")
    private String hotelNombre;

    @Column(name = "HOTEL_ID")
    private String hotelId;

    @Column(name = "FECHA_INGRESO")
    private String fechaIngreso;

    @Column(name = "FECHA_SALIDA")
    private String fechaSalida;

    @Column(name = "HAB_HOT_ID")
    private Long habHotId;

    @Column(name = "DET_NUM_HAB")
    private String detNumHab;

    @Column(name = "TIPO_HAB")
    private String tipoHab;

    public VwPersonalHotel() {
    }

    public VwPersonalHotel(Long personalRelevoId, String nombreCompleto, String dni, String hotelNombre, String hotelId, String fechaIngreso, String fechaSalida, Long habHotId, String detNumHab, String tipoHab) {
        this.personalRelevoId = personalRelevoId;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.hotelNombre = hotelNombre;
        this.hotelId = hotelId;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.habHotId = habHotId;
        this.detNumHab = detNumHab;
        this.tipoHab = tipoHab;
    }

    public Long getPersonalRelevoId() {
        return personalRelevoId;
    }

    public void setPersonalRelevoId(Long personalRelevoId) {
        this.personalRelevoId = personalRelevoId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getHotelNombre() {
        return hotelNombre;
    }

    public void setHotelNombre(String hotelNombre) {
        this.hotelNombre = hotelNombre;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Long getHabHotId() {
        return habHotId;
    }

    public void setHabHotId(Long habHotId) {
        this.habHotId = habHotId;
    }

    public String getDetNumHab() {
        return detNumHab;
    }

    public void setDetNumHab(String detNumHab) {
        this.detNumHab = detNumHab;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
