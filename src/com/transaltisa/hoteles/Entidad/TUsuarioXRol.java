/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transaltisa.hoteles.Entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "trn_sistemas.T_USUARIO_X_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUsuarioXRol.findAll", query = "SELECT t FROM TUsuarioXRol t"),
    @NamedQuery(name = "TUsuarioXRol.findByRolId", query = "SELECT t FROM TUsuarioXRol t WHERE t.tUsuarioXRolPK.rolId = :rolId"),
    @NamedQuery(name = "TUsuarioXRol.findByPersId", query = "SELECT t FROM TUsuarioXRol t WHERE t.tUsuarioXRolPK.persId = :persId"),
    @NamedQuery(name = "TUsuarioXRol.findByUsuarioId", query = "SELECT t FROM TUsuarioXRol t WHERE t.tUsuarioXRolPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "TUsuarioXRol.findByCreadoDesde", query = "SELECT t FROM TUsuarioXRol t WHERE t.creadoDesde = :creadoDesde"),
    @NamedQuery(name = "TUsuarioXRol.findByCreadoHasta", query = "SELECT t FROM TUsuarioXRol t WHERE t.creadoHasta = :creadoHasta"),
    @NamedQuery(name = "TUsuarioXRol.findByCreacionFecha", query = "SELECT t FROM TUsuarioXRol t WHERE t.creacionFecha = :creacionFecha"),
    @NamedQuery(name = "TUsuarioXRol.findByCreadoPor", query = "SELECT t FROM TUsuarioXRol t WHERE t.creadoPor = :creadoPor")})
public class TUsuarioXRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TUsuarioXRolPK tUsuarioXRolPK;
    @Column(name = "CREADO_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoDesde;
    @Column(name = "CREADO_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoHasta;
    @Column(name = "CREACION_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creacionFecha;
    @Size(max = 30)
    @Column(name = "CREADO_POR")
    private String creadoPor;
    @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MRol mRol;
    @JoinColumns({
        @JoinColumn(name = "USUARIO_ID", referencedColumnName = "USUARIO_ID", insertable = false, updatable = false),
        @JoinColumn(name = "PERS_ID", referencedColumnName = "PERS_ID", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MUsuario mUsuario;

    public TUsuarioXRol() {
    }

    public TUsuarioXRol(TUsuarioXRolPK tUsuarioXRolPK) {
        this.tUsuarioXRolPK = tUsuarioXRolPK;
    }

    public TUsuarioXRol(BigInteger rolId, BigInteger persId, BigInteger usuarioId) {
        this.tUsuarioXRolPK = new TUsuarioXRolPK(rolId, persId, usuarioId);
    }

    public TUsuarioXRolPK getTUsuarioXRolPK() {
        return tUsuarioXRolPK;
    }

    public void setTUsuarioXRolPK(TUsuarioXRolPK tUsuarioXRolPK) {
        this.tUsuarioXRolPK = tUsuarioXRolPK;
    }

    public Date getCreadoDesde() {
        return creadoDesde;
    }

    public void setCreadoDesde(Date creadoDesde) {
        this.creadoDesde = creadoDesde;
    }

    public Date getCreadoHasta() {
        return creadoHasta;
    }

    public void setCreadoHasta(Date creadoHasta) {
        this.creadoHasta = creadoHasta;
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

    public MRol getMRol() {
        return mRol;
    }

    public void setMRol(MRol mRol) {
        this.mRol = mRol;
    }

    public MUsuario getMUsuario() {
        return mUsuario;
    }

    public void setMUsuario(MUsuario mUsuario) {
        this.mUsuario = mUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tUsuarioXRolPK != null ? tUsuarioXRolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUsuarioXRol)) {
            return false;
        }
        TUsuarioXRol other = (TUsuarioXRol) object;
        if ((this.tUsuarioXRolPK == null && other.tUsuarioXRolPK != null) || (this.tUsuarioXRolPK != null && !this.tUsuarioXRolPK.equals(other.tUsuarioXRolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.transaltisa.hoteles.Entidad.TUsuarioXRol[ tUsuarioXRolPK=" + tUsuarioXRolPK + " ]";
    }
    
}
