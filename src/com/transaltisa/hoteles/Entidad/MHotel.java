package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "M_HOTEL",schema = "LOGISTICA")
public class MHotel implements Serializable{

    @Id
    @Column(name = "HOTEL_ID")
    private Long hotelId;

    @Column(name = "HOTEL_NOMBRE")
    private String hotelNombre;

    @Column(name = "HOTEL_NUM_HAB")
    private Long hotelNumHab;

    @Column(name = "FLOTA")
    private String flota;

    @Column(name = "ESTADO")
    private Long estado;

    @Column(name = "PISOS")
    private Long pisos;

    public MHotel() {
    }

    public MHotel(Long hotelId, String hotelNombre, Long hotelNumHab, String flota, Long estado, Long pisos) {
        this.hotelId = hotelId;
        this.hotelNombre = hotelNombre;
        this.hotelNumHab = hotelNumHab;
        this.flota = flota;
        this.estado = estado;
        this.pisos = pisos;
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

    public Long getHotelNumHab() {
        return hotelNumHab;
    }

    public void setHotelNumHab(Long hotelNumHab) {
        this.hotelNumHab = hotelNumHab;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Long getPisos() {
        return pisos;
    }

    public void setPisos(Long pisos) {
        this.pisos = pisos;
    }
}
