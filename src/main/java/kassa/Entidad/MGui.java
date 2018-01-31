/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
 
/**
 *
 * @author TI-AQP
 */
@Entity
@Table(name = "M_GUI", schema = "TRN_SISTEMAS")
@XmlRootElement
@NamedNativeQueries({
    @NamedNativeQuery(name = "MGui.allGui",query="select * from TRN_SISTEMAS.M_GUI where GUI_ID >2000",resultClass = MGui.class)
})
@NamedQueries({
    @NamedQuery(name = "MGui.findAll", query = "SELECT m FROM MGui m")
    , @NamedQuery(name = "MGui.findByGuiId", query = "SELECT m FROM MGui m WHERE m.mGuiPK.guiId = :guiId")
    , @NamedQuery(name = "MGui.findByNodoId", query = "SELECT m FROM MGui m WHERE m.mGuiPK.nodoId = :nodoId")
    , @NamedQuery(name = "MGui.findByModuloId", query = "SELECT m FROM MGui m WHERE m.mGuiPK.moduloId = :moduloId")
    , @NamedQuery(name = "MGui.findByGuiNombre", query = "SELECT m FROM MGui m WHERE m.guiNombre = :guiNombre")
    , @NamedQuery(name = "MGui.findByGuiUrl", query = "SELECT m FROM MGui m WHERE m.guiUrl = :guiUrl")
    , @NamedQuery(name = "MGui.findByGuiDescripcion", query = "SELECT m FROM MGui m WHERE m.guiDescripcion = :guiDescripcion")
    , @NamedQuery(name = "MGui.findByGuiActivoDesde", query = "SELECT m FROM MGui m WHERE m.guiActivoDesde = :guiActivoDesde")
    , @NamedQuery(name = "MGui.findByGuiActivoHasta", query = "SELECT m FROM MGui m WHERE m.guiActivoHasta = :guiActivoHasta")
    , @NamedQuery(name = "MGui.findByCreacionFecha", query = "SELECT m FROM MGui m WHERE m.creacionFecha = :creacionFecha")
    , @NamedQuery(name = "MGui.findByCreadoPor", query = "SELECT m FROM MGui m WHERE m.creadoPor = :creadoPor")
    , @NamedQuery(name = "MGui.findByModificacionFecha", query = "SELECT m FROM MGui m WHERE m.modificacionFecha = :modificacionFecha")
    , @NamedQuery(name = "MGui.findByModificadoPor", query = "SELECT m FROM MGui m WHERE m.modificadoPor = :modificadoPor")})
public class MGui implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MGuiPK mGuiPK;
    @Size(max = 50)
    @Column(name = "GUI_NOMBRE")
    private String guiNombre;
    @Size(max = 300)
    @Column(name = "GUI_URL")
    private String guiUrl;
    @Size(max = 300)
    @Column(name = "GUI_DESCRIPCION")
    private String guiDescripcion;
    @Column(name = "GUI_ACTIVO_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guiActivoDesde;
    @Column(name = "GUI_ACTIVO_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guiActivoHasta;
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
    @JoinColumns({
        @JoinColumn(name = "NODO_ID", referencedColumnName = "NODO_ID", insertable = false, updatable = false)
        , @JoinColumn(name = "MODULO_ID", referencedColumnName = "MODULO_ID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MNodo mNodo;

    public MGui() {
    }

    public MGui(MGuiPK mGuiPK) {
        this.mGuiPK = mGuiPK;
    }

    public MGui(BigInteger guiId, BigInteger nodoId, BigInteger moduloId) {
        this.mGuiPK = new MGuiPK(guiId, nodoId, moduloId);
    }

    public MGuiPK getMGuiPK() {
        return mGuiPK;
    }

    public void setMGuiPK(MGuiPK mGuiPK) {
        this.mGuiPK = mGuiPK;
    }

    public String getGuiNombre() {
        return guiNombre;
    }

    public void setGuiNombre(String guiNombre) {
        this.guiNombre = guiNombre;
    }

    public String getGuiUrl() {
        return guiUrl;
    }

    public void setGuiUrl(String guiUrl) {
        this.guiUrl = guiUrl;
    }

    public String getGuiDescripcion() {
        return guiDescripcion;
    }

    public void setGuiDescripcion(String guiDescripcion) {
        this.guiDescripcion = guiDescripcion;
    }

    public Date getGuiActivoDesde() {
        return guiActivoDesde;
    }

    public void setGuiActivoDesde(Date guiActivoDesde) {
        this.guiActivoDesde = guiActivoDesde;
    }

    public Date getGuiActivoHasta() {
        return guiActivoHasta;
    }

    public void setGuiActivoHasta(Date guiActivoHasta) {
        this.guiActivoHasta = guiActivoHasta;
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

    public MNodo getMNodo() {
        return mNodo;
    }

    public void setMNodo(MNodo mNodo) {
        this.mNodo = mNodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mGuiPK != null ? mGuiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MGui)) {
            return false;
        }
        MGui other = (MGui) object;
        if ((this.mGuiPK == null && other.mGuiPK != null) || (this.mGuiPK != null && !this.mGuiPK.equals(other.mGuiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MGui[ mGuiPK=" + mGuiPK + " ]";
    }
    
}
