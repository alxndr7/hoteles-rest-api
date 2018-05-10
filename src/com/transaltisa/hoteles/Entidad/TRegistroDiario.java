package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "T_REGISTRO_DIARIO",schema = "LOGISTICA")
public class TRegistroDiario implements Serializable{

    @Id
    @Column(name = "ID_REG_DIAR")
    private Long idRegDiar;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "PERSONAL_RELEVO_ID")
    @JoinColumn(name = "PERSONAL_RELEVO_ID", nullable = false, insertable=false, updatable=false)
    private TPersonalRelevoDiar personalRelevoId;

    @Column(name = "REG1")
    private String reg1;

    @Column(name = "REG2")
    private String reg2;

    @Column(name = "REG3")
    private String reg3;

    @Column(name = "HOTEL_ID")
    private Long hotelId;

    @Column(name = "FECHA_REGISTRO")
    private String fechaRegistro;

    public TRegistroDiario() {
    }

    public TRegistroDiario(Long idRegDiar, TPersonalRelevoDiar personalRelevoId, String reg1, String reg2, String reg3, Long hotelId, String fechaRegistro) {
        this.idRegDiar = idRegDiar;
        this.personalRelevoId = personalRelevoId;
        this.reg1 = reg1;
        this.reg2 = reg2;
        this.reg3 = reg3;
        this.hotelId = hotelId;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getIdRegDiar() {
        return idRegDiar;
    }

    public void setIdRegDiar(Long idRegDiar) {
        this.idRegDiar = idRegDiar;
    }

    public TPersonalRelevoDiar getPersonalRelevoId() {
        return personalRelevoId;
    }

    public void setPersonalRelevoId(TPersonalRelevoDiar personalRelevoId) {
        this.personalRelevoId = personalRelevoId;
    }

    public String getReg1() {
        return reg1;
    }

    public void setReg1(String reg1) {
        this.reg1 = reg1;
    }

    public String getReg2() {
        return reg2;
    }

    public void setReg2(String reg2) {
        this.reg2 = reg2;
    }

    public String getReg3() {
        return reg3;
    }

    public void setReg3(String reg3) {
        this.reg3 = reg3;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
