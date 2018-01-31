/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "M_MODULO", schema = "TRN_SISTEMAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MModulo.findAll", query = "SELECT m FROM MModulo m")
    , @NamedQuery(name = "MModulo.findByModuloId", query = "SELECT m FROM MModulo m WHERE m.moduloId = :moduloId")
    , @NamedQuery(name = "MModulo.findByModuloNombre", query = "SELECT m FROM MModulo m WHERE m.moduloNombre = :moduloNombre")
    , @NamedQuery(name = "MModulo.findByModuloUrl", query = "SELECT m FROM MModulo m WHERE m.moduloUrl = :moduloUrl")
    , @NamedQuery(name = "MModulo.findByDescripcion", query = "SELECT m FROM MModulo m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "MModulo.findByModActivoDesde", query = "SELECT m FROM MModulo m WHERE m.modActivoDesde = :modActivoDesde")
    , @NamedQuery(name = "MModulo.findByModActivoHasta", query = "SELECT m FROM MModulo m WHERE m.modActivoHasta = :modActivoHasta")
    , @NamedQuery(name = "MModulo.findByModNivel", query = "SELECT m FROM MModulo m WHERE m.modNivel = :modNivel")
    , @NamedQuery(name = "MModulo.findByCreacionFecha", query = "SELECT m FROM MModulo m WHERE m.creacionFecha = :creacionFecha")
    , @NamedQuery(name = "MModulo.findByCreadoPor", query = "SELECT m FROM MModulo m WHERE m.creadoPor = :creadoPor")
    , @NamedQuery(name = "MModulo.findByModificacionFecha", query = "SELECT m FROM MModulo m WHERE m.modificacionFecha = :modificacionFecha")
    , @NamedQuery(name = "MModulo.findByModificadoPor", query = "SELECT m FROM MModulo m WHERE m.modificadoPor = :modificadoPor")})
public class MModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODULO_ID")
    private BigDecimal moduloId;
    @Size(max = 50)
    @Column(name = "MODULO_NOMBRE")
    private String moduloNombre;
    @Size(max = 300)
    @Column(name = "MODULO_URL")
    private String moduloUrl;
    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "MOD_ACTIVO_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modActivoDesde;
    @Column(name = "MOD_ACTIVO_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modActivoHasta;
    @Column(name = "MOD_NIVEL")
    private BigInteger modNivel;
    @Column(name = "CREACION_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creacionFecha;
    @Size(max = 10)
    @Column(name = "CREADO_POR")
    private String creadoPor;
    @Column(name = "MODIFICACION_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Size(max = 10)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mModulo")
    private Collection<MNodo> mNodoCollection;

    public MModulo() {
    }

    public MModulo(BigDecimal moduloId) {
        this.moduloId = moduloId;
    }

    public BigDecimal getModuloId() {
        return moduloId;
    }

    public void setModuloId(BigDecimal moduloId) {
        this.moduloId = moduloId;
    }

    public String getModuloNombre() {
        return moduloNombre;
    }

    public void setModuloNombre(String moduloNombre) {
        this.moduloNombre = moduloNombre;
    }

    public String getModuloUrl() {
        return moduloUrl;
    }

    public void setModuloUrl(String moduloUrl) {
        this.moduloUrl = moduloUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getModActivoDesde() {
        return modActivoDesde;
    }

    public void setModActivoDesde(Date modActivoDesde) {
        this.modActivoDesde = modActivoDesde;
    }

    public Date getModActivoHasta() {
        return modActivoHasta;
    }

    public void setModActivoHasta(Date modActivoHasta) {
        this.modActivoHasta = modActivoHasta;
    }

    public BigInteger getModNivel() {
        return modNivel;
    }

    public void setModNivel(BigInteger modNivel) {
        this.modNivel = modNivel;
    }

    public Date getCreacionFecha() {
        return creacionFecha;
    }

    public void setCreacionFecha(Date creacionFecha) {
        this.creacionFecha = creacionFecha;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getModificacionFecha() {
        return modificacionFecha;
    }

    public void setModificacionFecha(Date modificacionFecha) {
        this.modificacionFecha = modificacionFecha;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MNodo> getMNodoCollection() {
        return mNodoCollection;
    }

    public void setMNodoCollection(Collection<MNodo> mNodoCollection) {
        this.mNodoCollection = mNodoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduloId != null ? moduloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MModulo)) {
            return false;
        }
        MModulo other = (MModulo) object;
        if ((this.moduloId == null && other.moduloId != null) || (this.moduloId != null && !this.moduloId.equals(other.moduloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MModulo[ moduloId=" + moduloId + " ]";
    }
    
}
