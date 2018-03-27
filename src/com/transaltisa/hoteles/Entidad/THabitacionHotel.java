package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "T_HABITACION_HOTEL",schema = "LOGISTICA")
public class THabitacionHotel implements Serializable{

    @Id
    @Column(name = "HAB_HOT_ID")
    private Long habHotId;

    @Column(name = "HOTEL_ID")
    private Long hotelId;

    @Column(name = "PISO_HOTEL_ID")
    private Long pisosHotelId;

   /* @ManyToOne()
    @JoinColumn (name="HOTEL_ID",referencedColumnName = "HOTEL_ID", insertable=false, updatable=false)
    private MHotelMap hotel;*/

 /*   @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "HOTEL_ID")
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private MHotelMap hotel;*/

    /*@ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "HOTEL_ID")
    @JoinColumn(name = "HOTEL_ID", nullable = false, referencedColumnName = "HOTEL_ID", insertable=false, updatable=false)
    private MHotelMap hotel;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "PISO_HOTEL_ID")
    @JoinColumn(name = "PISO_HOTEL_ID", nullable = false, referencedColumnName = "PISO_HOTEL_ID", insertable=false, updatable=false)
    private TPisosHotel pisosHotel;



    @Column(name = "DET_NUM_HAB")
    private String detNumHab;

    @Column(name = "TIPO_HAB")
    private String tipoHab;

    @Column(name = "ESTADO_HAB")
    private String estadoHab;

    @Column(name= "PERSONAL_RELEVO_ID")
    private Long personalRelevoId;

    @Column(name = "FECHA_INI_OCUPA")
    private String fechaIniOcupa;

    @Column(name = "FECHA_FIN_OCUPA")
    private String fechaFinOcupa;

    @Column(name = "ESTADO_OCUPA")
    private String estadoOcupa;

    public THabitacionHotel() {
    }

/*    public THabitacionHotel(Long habHotId, TPisosHotel pisosHotel, Long pisosHotelId, String detNumHab, String tipoHab, String estadoHab) {
        this.habHotId = habHotId;
        this.pisosHotel = pisosHotel;
        this.pisosHotelId = pisosHotelId;
        this.detNumHab = detNumHab;
        this.tipoHab = tipoHab;
        this.estadoHab = estadoHab;
    }*/

    public THabitacionHotel(Long habHotId, Long hotelId, Long pisosHotelId, TPisosHotel pisosHotel, String detNumHab, String tipoHab, String estadoHab, Long personalRelevoId, String fechaIniOcupa, String fechaFinOcupa, String estadoOcupa) {
        this.habHotId = habHotId;
        this.hotelId = hotelId;
        this.pisosHotelId = pisosHotelId;
        this.pisosHotel = pisosHotel;
        this.detNumHab = detNumHab;
        this.tipoHab = tipoHab;
        this.estadoHab = estadoHab;
        this.personalRelevoId = personalRelevoId;
        this.fechaIniOcupa = fechaIniOcupa;
        this.fechaFinOcupa = fechaFinOcupa;
        this.estadoOcupa = estadoOcupa;
    }

    public Long getHabHotId() {
        return habHotId;
    }

    public void setHabHotId(Long habHotId) {
        this.habHotId = habHotId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
/*
    public MHotelMap getHotel() {
        return hotel;
    }

    public void setHotel(MHotelMap hotel) {
        this.hotel = hotel;
    }
*/

    public Long getPisosHotelId() {
        return pisosHotelId;
    }

    public void setPisosHotelId(Long pisosHotelId) {
        this.pisosHotelId = pisosHotelId;
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

    public String getEstadoHab() {
        return estadoHab;
    }

    public void setEstadoHab(String estadoHab) {
        this.estadoHab = estadoHab;
    }

    public Long getPersonalRelevoId() {
        return personalRelevoId;
    }

    public void setPersonalRelevoId(Long personalRelevoId) {
        this.personalRelevoId = personalRelevoId;
    }

    public String getFechaIniOcupa() {
        return fechaIniOcupa;
    }

    public void setFechaIniOcupa(String fechaIniOcupa) {
        this.fechaIniOcupa = fechaIniOcupa;
    }

    public String getFechaFinOcupa() {
        return fechaFinOcupa;
    }

    public void setFechaFinOcupa(String fechaFinOcupa) {
        this.fechaFinOcupa = fechaFinOcupa;
    }

    public String getEstadoOcupa() {
        return estadoOcupa;
    }

    public void setEstadoOcupa(String estadoOcupa) {
        this.estadoOcupa = estadoOcupa;
    }
}
