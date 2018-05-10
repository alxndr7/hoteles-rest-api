package com.transaltisa.hoteles.Entidad;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "M_HOTEL",schema = "LOGISTICA")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "MHotelMap.sp_desocupar_habitacion",
                procedureName = "LOGISTICA.DESO_HAB_ANTICIPADA",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "habHotId", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "personalRelevoId", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "observacion", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "MHotelMap.sp_per_diario_histo",
                procedureName = "LOGISTICA.PRUEBA_INSERTAR")
}
)


public class MHotelMap implements Serializable {

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

  /*  @OneToMany
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private List<THabitacionHotel> habHotel;
*/
  /* @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<THabitacionHotel> habHotel;//funciona bien*/

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TPisosHotel> pisosHotel;

    public MHotelMap() {
    }

    public MHotelMap(Long hotelId, String hotelNombre, Long hotelNumHab, String flota, Long estado, Long pisos/*, List<THabitacionHotel> habHotel*/) {
        this.hotelId = hotelId;
        this.hotelNombre = hotelNombre;
        this.hotelNumHab = hotelNumHab;
        this.flota = flota;
        this.estado = estado;
        this.pisos = pisos;
        /*this.habHotel = habHotel;*/
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

    @XmlTransient
    @JsonIgnore
    public List<TPisosHotel> getPisosHotel() {
        return pisosHotel;
    }

    public void setPisosHotel(List<TPisosHotel> pisosHotel) {
        this.pisosHotel = pisosHotel;
    }


}
