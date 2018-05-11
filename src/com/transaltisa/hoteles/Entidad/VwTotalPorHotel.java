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
@Table(name = "VW_TOTAL_POR_HOTEL_D",schema = "LOGISTICA")

public class VwTotalPorHotel implements Serializable {

    @Id
    @Column(name = "HOTEL_ID")
    private Long hotelId;

    @Column(name = "HOTEL_NOMBRE")
    private String hotelNombre;

    @Column(name = "TOTAL_HABITACIONES")
    private Long totalHabitaciones;

    @Column(name = "VACIO")
    private Long vacio;

    @Column(name = "OCUPADO")
    private Long ocupado;


    public VwTotalPorHotel() {
    }

    public VwTotalPorHotel(Long hotelId, String hotelNombre, Long totalHabitaciones, Long vacio, Long ocupado) {
        this.hotelId = hotelId;
        this.hotelNombre = hotelNombre;
        this.totalHabitaciones = totalHabitaciones;
        this.vacio = vacio;
        this.ocupado = ocupado;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelNombre() {
        return hotelNombre;
    }

    public void setHotelNombre(String hotelNombre) {
        this.hotelNombre = hotelNombre;
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


