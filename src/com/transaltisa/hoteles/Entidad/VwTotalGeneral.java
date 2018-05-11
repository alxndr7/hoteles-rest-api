package com.transaltisa.hoteles.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "VW_TOTAL_GENERAL_D",schema = "LOGISTICA")

public class VwTotalGeneral implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TOTAL_HABITACIONES")
    private Long totalHabitaciones;

    @Column(name = "VACIO")
    private Long vacio;

    @Column(name = "OCUPADO")
    private Long ocupado;

    public VwTotalGeneral() {
    }

    public VwTotalGeneral(Long id, Long totalHabitaciones, Long vacio, Long ocupado) {
        this.id = id;
        this.totalHabitaciones = totalHabitaciones;
        this.vacio = vacio;
        this.ocupado = ocupado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalHabitaciones() {
        return totalHabitaciones;
    }

    public void setTotalHabitaciones(Long totalHabitaciones) {
        this.totalHabitaciones = totalHabitaciones;
    }

    public Long getVacio() {
        return vacio;
    }

    public void setVacio(Long vacio) {
        this.vacio = vacio;
    }

    public Long getOcupado() {
        return ocupado;
    }

    public void setOcupado(Long ocupado) {
        this.ocupado = ocupado;
    }

}


