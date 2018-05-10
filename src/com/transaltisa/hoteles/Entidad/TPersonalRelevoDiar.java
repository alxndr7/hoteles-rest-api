package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "T_PERSONAL_RELEVO_HIST",schema = "LOGISTICA")
public class TPersonalRelevoDiar implements Serializable{

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

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "HAB_HOT_ID")
    @JoinColumn(name = "HAB_HOT_ID", nullable = false, insertable=false, updatable=false)
    @OrderBy("DET_NUM_HAB")
    private THabitacionHotelSimple habDet;

    public TPersonalRelevoDiar() {
    }

    public TPersonalRelevoDiar(Long personalRelevoId, String dni, String nombreCompleto, String puesto, String flota, String fechaIngreso, String fechaSalida, THabitacionHotelSimple habDet) {
        this.personalRelevoId = personalRelevoId;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.flota = flota;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
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

    public THabitacionHotelSimple getHabDet() {
        return habDet;
    }

    public void setHabDet(THabitacionHotelSimple habDet) {
        this.habDet = habDet;
    }
}
