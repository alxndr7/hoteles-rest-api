package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "T_PERSONAL_RELEVO_DIARIO",schema = "LOGISTICA")
public class TPersonalRelevo implements Serializable{

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

    @Column(name = "ORDEN")
    private Long orden;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "HAB_HOT_ID")
    @JoinColumn(name = "HAB_HOT_ID", nullable = false, insertable=false, updatable=false)
    private THabitacionHotelDet habDet;

    public TPersonalRelevo() {
    }

    public TPersonalRelevo(THabitacionHotelDet habDet, Long personalRelevoId, String dni, String nombreCompleto, String puesto, String flota, String fechaIngreso, String fechaSalida, Long habHotId, Long orden) {
        this.habDet = habDet;
        this.personalRelevoId = personalRelevoId;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.flota = flota;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.habHotId = habHotId;
        this.orden = orden;
    }

    public THabitacionHotelDet getHabDet() {
        return habDet;
    }

    public void setHabDet(THabitacionHotelDet habDet) {
        this.habDet = habDet;
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
