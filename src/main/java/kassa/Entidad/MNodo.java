/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author TI-AQP
 */
@Entity
@Table(name = "M_NODO", schema = "TRN_SISTEMAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MNodo.findAll", query = "SELECT m FROM MNodo m")
    , @NamedQuery(name = "MNodo.findByNodoId", query = "SELECT m FROM MNodo m WHERE m.mNodoPK.nodoId = :nodoId")
    , @NamedQuery(name = "MNodo.findByModuloId", query = "SELECT m FROM MNodo m WHERE m.mNodoPK.moduloId = :moduloId")
    , @NamedQuery(name = "MNodo.findByNodoNombre", query = "SELECT m FROM MNodo m WHERE m.nodoNombre = :nodoNombre")
    , @NamedQuery(name = "MNodo.findByNodoUrl", query = "SELECT m FROM MNodo m WHERE m.nodoUrl = :nodoUrl")
    , @NamedQuery(name = "MNodo.findByNodoDescripcion", query = "SELECT m FROM MNodo m WHERE m.nodoDescripcion = :nodoDescripcion")
    , @NamedQuery(name = "MNodo.findByNodoActivoDesde", query = "SELECT m FROM MNodo m WHERE m.nodoActivoDesde = :nodoActivoDesde")
    , @NamedQuery(name = "MNodo.findByNodoActivoHasta", query = "SELECT m FROM MNodo m WHERE m.nodoActivoHasta = :nodoActivoHasta")
    , @NamedQuery(name = "MNodo.findByCreacionFecha", query = "SELECT m FROM MNodo m WHERE m.creacionFecha = :creacionFecha")
    , @NamedQuery(name = "MNodo.findByCreadoPor", query = "SELECT m FROM MNodo m WHERE m.creadoPor = :creadoPor")
    , @NamedQuery(name = "MNodo.findByModificacionFecha", query = "SELECT m FROM MNodo m WHERE m.modificacionFecha = :modificacionFecha")
    , @NamedQuery(name = "MNodo.findByModificadoPor", query = "SELECT m FROM MNodo m WHERE m.modificadoPor = :modificadoPor")})
public class MNodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MNodoPK mNodoPK;
    @Size(max = 50)
    @Column(name = "NODO_NOMBRE")
    private String nodoNombre;
    @Size(max = 300)
    @Column(name = "NODO_URL")
    private String nodoUrl;
    @Size(max = 300)
    @Column(name = "NODO_DESCRIPCION")
    private String nodoDescripcion;
    @Column(name = "NODO_ACTIVO_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nodoActivoDesde;
    @Column(name = "NODO_ACTIVO_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nodoActivoHasta;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mNodo")
    private Collection<MGui> mGuiCollection;
    @JoinColumn(name = "MODULO_ID", referencedColumnName = "MODULO_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MModulo mModulo;

    public MNodo() {
    }

    public MNodo(MNodoPK mNodoPK) {
        this.mNodoPK = mNodoPK;
    }

    public MNodo(BigInteger nodoId, BigInteger moduloId) {
        this.mNodoPK = new MNodoPK(nodoId, moduloId);
    }

    public MNodoPK getMNodoPK() {
        return mNodoPK;
    }

    public void setMNodoPK(MNodoPK mNodoPK) {
        this.mNodoPK = mNodoPK;
    }

    public String getNodoNombre() {
        return nodoNombre;
    }

    public void setNodoNombre(String nodoNombre) {
        this.nodoNombre = nodoNombre;
    }

    public String getNodoUrl() {
        return nodoUrl;
    }

    public void setNodoUrl(String nodoUrl) {
        this.nodoUrl = nodoUrl;
    }

    public String getNodoDescripcion() {
        return nodoDescripcion;
    }

    public void setNodoDescripcion(String nodoDescripcion) {
        this.nodoDescripcion = nodoDescripcion;
    }

    public Date getNodoActivoDesde() {
        return nodoActivoDesde;
    }

    public void setNodoActivoDesde(Date nodoActivoDesde) {
        this.nodoActivoDesde = nodoActivoDesde;
    }

    public Date getNodoActivoHasta() {
        return nodoActivoHasta;
    }

    public void setNodoActivoHasta(Date nodoActivoHasta) {
        this.nodoActivoHasta = nodoActivoHasta;
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
    public Collection<MGui> getMGuiCollection() {
        return mGuiCollection;
    }

    public void setMGuiCollection(Collection<MGui> mGuiCollection) {
        this.mGuiCollection = mGuiCollection;
    }

    public MModulo getMModulo() {
        return mModulo;
    }

    public void setMModulo(MModulo mModulo) {
        this.mModulo = mModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mNodoPK != null ? mNodoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MNodo)) {
            return false;
        }
        MNodo other = (MNodo) object;
        if ((this.mNodoPK == null && other.mNodoPK != null) || (this.mNodoPK != null && !this.mNodoPK.equals(other.mNodoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MNodo[ mNodoPK=" + mNodoPK + " ]";
    }
    
}
