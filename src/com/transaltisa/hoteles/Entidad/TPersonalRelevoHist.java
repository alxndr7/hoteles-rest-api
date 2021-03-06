package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "T_PERSONAL_RELEVO_HIST",schema = "LOGISTICA")
public class TPersonalRelevoHist implements Serializable{

    @Id
    @Column(name = "PERSONAL_RELEVO_ID")
    private Long personalRelevoId;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "PUESTO")
    private String puesto;

    @Column(name = "FLOTA")
    private String flota;

    @Column(name = "FECHA_INGRESO")
    private String fechaIngreso;

    @Column(name = "FECHA_SALIDA")
    private String fechaSalida;

    @Column(name = "HAB_HOT_ID")
    private Long habHotId;


    public TPersonalRelevoHist() {
    }

    public TPersonalRelevoHist(Long personalRelevoId, String dni, String nombreCompleto, String puesto, String flota, String fechaIngreso, String fechaSalida, Long habHotId, THabitacionHotelDet habDet) {
        this.personalRelevoId = personalRelevoId;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.flota = flota;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.habHotId = habHotId;
    }

    public Long getPersonalRelevoId() {
        return personalRelevoId;
    }

    public void setPersonalRelevoId(Long personalRelevoId) {
        this.personalRelevoId = personalRelevoId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
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

}
