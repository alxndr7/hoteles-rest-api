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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "M_PUESTO", schema = "TRN_RRHH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MPuesto.findAll", query = "SELECT m FROM MPuesto m")
    , @NamedQuery(name = "MPuesto.findByPuestoId", query = "SELECT m FROM MPuesto m WHERE m.puestoId = :puestoId")
    , @NamedQuery(name = "MPuesto.findByPuestoNombre", query = "SELECT m FROM MPuesto m WHERE m.puestoNombre = :puestoNombre")
    , @NamedQuery(name = "MPuesto.findByJefatura", query = "SELECT m FROM MPuesto m WHERE m.jefatura = :jefatura")
    , @NamedQuery(name = "MPuesto.findByPuestoEstado", query = "SELECT m FROM MPuesto m WHERE m.puestoEstado = :puestoEstado")
    , @NamedQuery(name = "MPuesto.findByRemuneracionDef", query = "SELECT m FROM MPuesto m WHERE m.remuneracionDef = :remuneracionDef")})
public class MPuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUESTO_ID")
    private BigDecimal puestoId;
    @Size(max = 60)
    @Column(name = "PUESTO_NOMBRE")
    private String puestoNombre;
    @Column(name = "JEFATURA")
    private Character jefatura;
    @Column(name = "PUESTO_ESTADO")
    private Character puestoEstado;
    @Size(max = 50)
    @Column(name = "REMUNERACION_DEF")
    private String remuneracionDef;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "mPuestoCollection")
    private Collection<MArea> mAreaCollection;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "puestoId")
    private Collection<TPersonal> tPersonalCollection;
    @JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID")
    @ManyToOne(optional = false)
    private MArea areaId;
    @JoinColumn(name = "PERFIL_RECURSOS_ID", referencedColumnName = "PERFIL_RECURSO_ID")
    @ManyToOne()
    private MPerfilRecursosTi perfilRecursosId;

    public MPuesto() {
    }

    public MPuesto(BigDecimal puestoId) {
        this.puestoId = puestoId;
    }

    public BigDecimal getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(BigDecimal puestoId) {
        this.puestoId = puestoId;
    }

    public String getPuestoNombre() {
        return puestoNombre;
    }

    public void setPuestoNombre(String puestoNombre) {
        this.puestoNombre = puestoNombre;
    }

    public Character getJefatura() {
        return jefatura;
    }

    public void setJefatura(Character jefatura) {
        this.jefatura = jefatura;
    }

    public Character getPuestoEstado() {
        return puestoEstado;
    }

    public void setPuestoEstado(Character puestoEstado) {
        this.puestoEstado = puestoEstado;
    }

    public String getRemuneracionDef() {
        return remuneracionDef;
    }

    public void setRemuneracionDef(String remuneracionDef) {
        this.remuneracionDef = remuneracionDef;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MArea> getMAreaCollection() {
        return mAreaCollection;
    }

    public void setMAreaCollection(Collection<MArea> mAreaCollection) {
        this.mAreaCollection = mAreaCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TPersonal> getTPersonalCollection() {
        return tPersonalCollection;
    }

    public void setTPersonalCollection(Collection<TPersonal> tPersonalCollection) {
        this.tPersonalCollection = tPersonalCollection;
    }

    public MArea getAreaId() {
        return areaId;
    }

    public void setAreaId(MArea areaId) {
        this.areaId = areaId;
    }

    public MPerfilRecursosTi getPerfilRecursosId() {
        return perfilRecursosId;
    }

    public void setPerfilRecursosId(MPerfilRecursosTi perfilRecursosId) {
        this.perfilRecursosId = perfilRecursosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puestoId != null ? puestoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MPuesto)) {
            return false;
        }
        MPuesto other = (MPuesto) object;
        if ((this.puestoId == null && other.puestoId != null) || (this.puestoId != null && !this.puestoId.equals(other.puestoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MPuesto[ puestoId=" + puestoId + " ]";
    }
    
}
