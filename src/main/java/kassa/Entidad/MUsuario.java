/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
import kassa.Entidad.MParadas;
/**
 *
 * @author Admin
 */

@Entity
@Table(name = "trn_sistemas.m_usuario")
@XmlRootElement
@NamedNativeQueries({
    @NamedNativeQuery(name = "MUsuario.findByUsuUsuarioN",query="select t.* from TRN_SISTEMAS.M_USUARIO t where t.usu_usuario=:usuUsuario ",resultClass = MUsuario.class),
    @NamedNativeQuery(name = "MUsuario.updatePassword",query="update trN_sistemas.m_usuario SET USU_PASSWORD = :password where usuario_id = :id_usuario"),
    @NamedNativeQuery(name = "MUsuario.allUsers",query="select * from TRN_SISTEMAS.M_USUARIO",resultClass = MUsuario.class),
    @NamedNativeQuery(name = "MUsuario.getPausasEnGeocercas", query ="select * from TRN_SISTEMAS.M_USUARIO",resultClass = MUsuario.class)
})

@NamedQueries({
    @NamedQuery(name = "MUsuario.findAll", query = "SELECT m FROM MUsuario m"),
    @NamedQuery(name = "MUsuario.findByUsuarioId", query = "SELECT m FROM MUsuario m WHERE m.mUsuarioPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "MUsuario.findByPersId", query = "SELECT m FROM MUsuario m WHERE m.mUsuarioPK.persId = :persId"),
    @NamedQuery(name = "MUsuario.findByUsuUsuario", query = "SELECT m FROM MUsuario m WHERE m.usuUsuario = :usuUsuario"),
    @NamedQuery(name = "MUsuario.findByUsuPassword", query = "SELECT m FROM MUsuario m WHERE m.usuPassword = :usuPassword"),
    @NamedQuery(name = "MUsuario.findByUsuActivoDesde", query = "SELECT m FROM MUsuario m WHERE m.usuActivoDesde = :usuActivoDesde"),
    @NamedQuery(name = "MUsuario.findByUsuActivoHasta", query = "SELECT m FROM MUsuario m WHERE m.usuActivoHasta = :usuActivoHasta"),
    @NamedQuery(name = "MUsuario.findByCreacionFecha", query = "SELECT m FROM MUsuario m WHERE m.creacionFecha = :creacionFecha"),
    @NamedQuery(name = "MUsuario.findByCreadoPor", query = "SELECT m FROM MUsuario m WHERE m.creadoPor = :creadoPor"),
    @NamedQuery(name = "MUsuario.findByModificacionFecha", query = "SELECT m FROM MUsuario m WHERE m.modificacionFecha = :modificacionFecha"),
    @NamedQuery(name = "MUsuario.findByModificadoPor", query = "SELECT m FROM MUsuario m WHERE m.modificadoPor = :modificadoPor"),
    @NamedQuery(name = "MUsuario.findByUsuTokenIphon", query = "SELECT m FROM MUsuario m WHERE m.usuTokenIphon = :usuTokenIphon"),
    @NamedQuery(name = "MUsuario.findByUsuProyExterno", query = "SELECT m FROM MUsuario m WHERE m.usuProyExterno = :usuProyExterno")})
public class MUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MUsuarioPK mUsuarioPK;
    @Size(max = 60)
    @Column(name = "USU_USUARIO")
    private String usuUsuario;
    @Size(max = 300)
    @Column(name = "USU_PASSWORD")
    private String usuPassword;
    @Column(name = "USU_ACTIVO_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuActivoDesde;
    @Column(name = "USU_ACTIVO_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuActivoHasta;
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
    @Size(max = 128)
    @Column(name = "USU_TOKEN_IPHON")
    private String usuTokenIphon;
    @Size(max = 10)
    @Column(name = "USU_PROY_EXTERNO")
    private String usuProyExterno;
    
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mUsuario", fetch = FetchType.LAZY)
//    private List<TUsuarioXRol> tUsuarioXRolList;

    public MUsuario() {
    }
    
    public MUsuario(MUsuario user) {
        super();
        this.mUsuarioPK= user.mUsuarioPK;
        this.usuActivoDesde = user.usuActivoDesde;
        this.usuActivoHasta = user.usuActivoHasta;
        this.usuPassword = user.usuPassword;
        this.usuProyExterno = user.usuProyExterno;
        
        this.usuTokenIphon = user.usuTokenIphon;
        this.usuUsuario = user.usuUsuario;
        
    }
    

    public MUsuario(MUsuarioPK mUsuarioPK) {
        this.mUsuarioPK = mUsuarioPK;
    }

    public MUsuario(BigInteger usuarioId, BigInteger persId) {
        this.mUsuarioPK = new MUsuarioPK(usuarioId, persId);
    }

    public MUsuarioPK getMUsuarioPK() {
        return mUsuarioPK;
    }

    public void setMUsuarioPK(MUsuarioPK mUsuarioPK) {
        this.mUsuarioPK = mUsuarioPK;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public Date getUsuActivoDesde() {
        return usuActivoDesde;
    }

    public void setUsuActivoDesde(Date usuActivoDesde) {
        this.usuActivoDesde = usuActivoDesde;
    }

    public Date getUsuActivoHasta() {
        return usuActivoHasta;
    }

    public void setUsuActivoHasta(Date usuActivoHasta) {
        this.usuActivoHasta = usuActivoHasta;
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

    public String getUsuTokenIphon() {
        return usuTokenIphon;
    }

    public void setUsuTokenIphon(String usuTokenIphon) {
        this.usuTokenIphon = usuTokenIphon;
    }

    public String getUsuProyExterno() {
        return usuProyExterno;
    }

    public void setUsuProyExterno(String usuProyExterno) {
        this.usuProyExterno = usuProyExterno;
    }

//    @XmlTransient
//    @JsonIgnore
//    public List<TUsuarioXRol> getTUsuarioXRolList() {
//        return tUsuarioXRolList;
//    }
//
//    public void setTUsuarioXRolList(List<TUsuarioXRol> tUsuarioXRolList) {
//        this.tUsuarioXRolList = tUsuarioXRolList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mUsuarioPK != null ? mUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MUsuario)) {
            return false;
        }
        MUsuario other = (MUsuario) object;
        if ((this.mUsuarioPK == null && other.mUsuarioPK != null) || (this.mUsuarioPK != null && !this.mUsuarioPK.equals(other.mUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MUsuario[ mUsuarioPK=" + mUsuarioPK + " ]";
    }
    
}
