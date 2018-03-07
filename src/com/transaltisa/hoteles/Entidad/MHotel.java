package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
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

    public MHotel() {
    }

    public MHotel(Long hotelId, String hotelNombre, Long hotelNumHab) {
        this.hotelId = hotelId;
        this.hotelNombre = hotelNombre;
        this.hotelNumHab = hotelNumHab;
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
}
