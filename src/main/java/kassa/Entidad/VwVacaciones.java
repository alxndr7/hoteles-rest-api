/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CESAR-TRN
 */
@Entity
@Table(name = "VW_VACACIONES", schema = "TRN_SISTEMAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwVacaciones.findAll", query = "SELECT v FROM VwVacaciones v")
    , @NamedQuery(name = "VwVacaciones.findByPersId", query = "SELECT v FROM VwVacaciones v WHERE v.persId = :persId")
    , @NamedQuery(name = "VwVacaciones.findByPeriodo", query = "SELECT v FROM VwVacaciones v WHERE v.periodo = :periodo")
    , @NamedQuery(name = "VwVacaciones.findByFechaInicio", query = "SELECT v FROM VwVacaciones v WHERE v.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "VwVacaciones.findByFechaFin", query = "SELECT v FROM VwVacaciones v WHERE v.fechaFin = :fechaFin")
    , @NamedQuery(name = "VwVacaciones.findByDias", query = "SELECT v FROM VwVacaciones v WHERE v.dias = :dias")
    , @NamedQuery(name = "VwVacaciones.findByTipoVacacion", query = "SELECT v FROM VwVacaciones v WHERE v.tipoVacacion = :tipoVacacion")})
public class VwVacaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERS_ID")
    @Id
    private BigInteger persId;
    @Column(name = "PERIODO")
    private BigInteger periodo;
    @Size(max = 10)
    @Column(name = "FECHA_INICIO")
    private String fechaInicio;
    @Size(max = 10)
    @Column(name = "FECHA_FIN")
    private String fechaFin;
    @Column(name = "DIAS")
    private BigInteger dias;
    @Size(max = 200)
    @Column(name = "TIPO_VACACION")
    private String tipoVacacion;

    public VwVacaciones() {
    }

    public BigInteger getPersId() {
        return persId;
    }

    public void setPersId(BigInteger persId) {
        this.persId = persId;
    }

    public BigInteger getPeriodo() {
        return periodo;
    }

    public void setPeriodo(BigInteger periodo) {
        this.periodo = periodo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigInteger getDias() {
        return dias;
    }

    public void setDias(BigInteger dias) {
        this.dias = dias;
    }

    public String getTipoVacacion() {
        return tipoVacacion;
    }

    public void setTipoVacacion(String tipoVacacion) {
        this.tipoVacacion = tipoVacacion;
    }
    
}
