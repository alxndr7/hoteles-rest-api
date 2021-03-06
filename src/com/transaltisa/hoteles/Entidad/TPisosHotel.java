package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "T_PISOS_HOTEL",schema = "LOGISTICA")
public class TPisosHotel implements Serializable{

    @Id
    @Column(name = "PISO_HOTEL_ID")
    private Long pisosHotelId;

   /* @Column(name = "HOTEL_ID")
    private Long hotelId;*/

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "HOTEL_ID")
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private MHotelMap hotel;

    @OneToMany(mappedBy = "pisosHotel",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<THabitacionHotel> habHotel;

    @Column(name = "PISO")
    private Long piso;

    @Column(name = "NUM_HAB_PISO")
    private Long numHabPiso;

    public TPisosHotel() {
    }

    public TPisosHotel(Long pisosHotelId/*, Long hotelId*/, Long piso, Long numHabPiso) {
        this.pisosHotelId = pisosHotelId;
       /* this.hotelId = hotelId;*/
        this.piso = piso;
        this.numHabPiso = numHabPiso;
    }

    public Long getPisosHotelId() {
        return pisosHotelId;
    }

    public void setPisosHotelId(Long pisosHotelId) {
        this.pisosHotelId = pisosHotelId;
    }

 /*   public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }*/

    public Long getPiso() {
        return piso;
    }

    public void setPiso(Long piso) {
        this.piso = piso;
    }

    public Long getNumHabPiso() {
        return numHabPiso;
    }

    public void setNumHabPiso(Long numHabPiso) {
        this.numHabPiso = numHabPiso;
    }

    public List<THabitacionHotel> getHabHotel() {
        return habHotel;
    }

    public void setHabHotel(List<THabitacionHotel> habHotel) {
        this.habHotel = habHotel;
    }

    /*public MHotelMap getHotel() {
        return hotel;
    }

    public void setHotel(MHotelMap hotel) {
        this.hotel = hotel;
    }*/
}
