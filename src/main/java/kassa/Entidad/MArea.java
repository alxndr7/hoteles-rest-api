/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author TI-AQP
 */
@Entity
@Table(name = "M_AREA", schema = "TRN_RRHH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MArea.findAll", query = "SELECT m FROM MArea m")
    , @NamedQuery(name = "MArea.findByAreaId", query = "SELECT m FROM MArea m WHERE m.areaId = :areaId")
    , @NamedQuery(name = "MArea.findByAreaNombre", query = "SELECT m FROM MArea m WHERE m.areaNombre = :areaNombre")
    , @NamedQuery(name = "MArea.findByEstado", query = "SELECT m FROM MArea m WHERE m.estado = :estado")})
public class MArea implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AREA_ID")
    private BigDecimal areaId;
    @Size(max = 50)
    @Column(name = "AREA_NOMBRE")
    private String areaNombre;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @JoinTable(name = "T_PUESTO_AREAS", schema = "TRN_RRHH", joinColumns = {
        @JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PUESTO_ID", referencedColumnName = "PUESTO_ID")})    
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<MPuesto> mPuestoCollection;
    @JoinColumn(name = "AREA_JEFE_ID", referencedColumnName = "PERS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TPersonal areaJefeId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "areaId")
    private Collection<MPuesto> mPuestoCollection1;

    public MArea() {
    }

    public MArea(BigDecimal areaId) {
        this.areaId = areaId;
    }

    public BigDecimal getAreaId() {
        return areaId;
    }

    public void setAreaId(BigDecimal areaId) {
        this.areaId = areaId;
    }

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MPuesto> getMPuestoCollection() {
        return mPuestoCollection;
    }

    public void setMPuestoCollection(Collection<MPuesto> mPuestoCollection) {
        this.mPuestoCollection = mPuestoCollection;
    }

    public TPersonal getAreaJefeId() {
        return areaJefeId;
    }

    public void setAreaJefeId(TPersonal areaJefeId) {
        this.areaJefeId = areaJefeId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MPuesto> getMPuestoCollection1() {
        return mPuestoCollection1;
    }

    public void setMPuestoCollection1(Collection<MPuesto> mPuestoCollection1) {
        this.mPuestoCollection1 = mPuestoCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MArea)) {
            return false;
        }
        MArea other = (MArea) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MArea[ areaId=" + areaId + " ]";
    }
    
}
