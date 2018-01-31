/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "trn_sistemas.M_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRol.findAll", query = "SELECT m FROM MRol m"),
    @NamedQuery(name = "MRol.findByRolId", query = "SELECT m FROM MRol m WHERE m.rolId = :rolId"),
    @NamedQuery(name = "MRol.findByRolDescripcion", query = "SELECT m FROM MRol m WHERE m.rolDescripcion = :rolDescripcion"),
    @NamedQuery(name = "MRol.findByRolActivoDesde", query = "SELECT m FROM MRol m WHERE m.rolActivoDesde = :rolActivoDesde"),
    @NamedQuery(name = "MRol.findByRolActivoHasta", query = "SELECT m FROM MRol m WHERE m.rolActivoHasta = :rolActivoHasta"),
    @NamedQuery(name = "MRol.findByCreadoDesde", query = "SELECT m FROM MRol m WHERE m.creadoDesde = :creadoDesde"),
    @NamedQuery(name = "MRol.findByCreadoHasta", query = "SELECT m FROM MRol m WHERE m.creadoHasta = :creadoHasta"),
    @NamedQuery(name = "MRol.findByCreacionFecha", query = "SELECT m FROM MRol m WHERE m.creacionFecha = :creacionFecha"),
    @NamedQuery(name = "MRol.findByCreadoPor", query = "SELECT m FROM MRol m WHERE m.creadoPor = :creadoPor"),
    @NamedQuery(name = "MRol.findByModificacionFecha", query = "SELECT m FROM MRol m WHERE m.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "MRol.findByModificadoPor", query = "SELECT m FROM MRol m WHERE m.modificadoPor = :modificadoPor"),
    @NamedQuery(name = "MRol.findByOpcionCrear", query = "SELECT m FROM MRol m WHERE m.opcionCrear = :opcionCrear"),
    @NamedQuery(name = "MRol.findByOpcionEditar", query = "SELECT m FROM MRol m WHERE m.opcionEditar = :opcionEditar"),
    @NamedQuery(name = "MRol.findByOpcionEliminar", query = "SELECT m FROM MRol m WHERE m.opcionEliminar = :opcionEliminar")})
public class MRol implements Serializable, GrantedAuthority {

    public static MRol ROL_ADMIN = new MRol(new BigDecimal("1"), "ADMIN");
    
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID")
    private BigDecimal rolId;
    @Size(max = 100)
    @Column(name = "ROL_DESCRIPCION")
    private String rolDescripcion;
    @Column(name = "ROL_ACTIVO_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolActivoDesde;
    @Column(name = "ROL_ACTIVO_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rolActivoHasta;
    @Column(name = "CREADO_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoDesde;
    @Column(name = "CREADO_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoHasta;
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
    @Column(name = "OPCION_CREAR")
    private BigInteger opcionCrear;
    @Column(name = "OPCION_EDITAR")
    private BigInteger opcionEditar;
    @Column(name = "OPCION_ELIMINAR")
    private BigInteger opcionEliminar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mRol", fetch = FetchType.LAZY)
    private List<TUsuarioXRol> tUsuarioXRolList;

    public MRol() {
    }

    public MRol(BigDecimal rolId, String rolDescripcion) {
        this.rolId = rolId;
        this.rolDescripcion = rolDescripcion;
    }

    
    public MRol(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public BigDecimal getRolId() {
        return rolId;
    }

    public void setRolId(BigDecimal rolId) {
        this.rolId = rolId;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public Date getRolActivoDesde() {
        return rolActivoDesde;
    }

    public void setRolActivoDesde(Date rolActivoDesde) {
        this.rolActivoDesde = rolActivoDesde;
    }

    public Date getRolActivoHasta() {
        return rolActivoHasta;
    }

    public void setRolActivoHasta(Date rolActivoHasta) {
        this.rolActivoHasta = rolActivoHasta;
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

    public BigInteger getOpcionCrear() {
        return opcionCrear;
    }

    public void setOpcionCrear(BigInteger opcionCrear) {
        this.opcionCrear = opcionCrear;
    }

    public BigInteger getOpcionEditar() {
        return opcionEditar;
    }

    public void setOpcionEditar(BigInteger opcionEditar) {
        this.opcionEditar = opcionEditar;
    }

    public BigInteger getOpcionEliminar() {
        return opcionEliminar;
    }

    public void setOpcionEliminar(BigInteger opcionEliminar) {
        this.opcionEliminar = opcionEliminar;
    }

    @XmlTransient
    @JsonIgnore
    public List<TUsuarioXRol> getTUsuarioXRolList() {
        return tUsuarioXRolList;
    }

    public void setTUsuarioXRolList(List<TUsuarioXRol> tUsuarioXRolList) {
        this.tUsuarioXRolList = tUsuarioXRolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRol)) {
            return false;
        }
        MRol other = (MRol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MRol[ rolId=" + rolId + " ]";
    }

    @Override
    public String getAuthority() {
        return rolDescripcion;
    }
    
}
