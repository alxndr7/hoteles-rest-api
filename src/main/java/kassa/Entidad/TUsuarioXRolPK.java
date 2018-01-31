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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Admin
 */
@Embeddable
public class TUsuarioXRolPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ROL_ID")
    private BigInteger rolId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERS_ID")
    private BigInteger persId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID")
    private BigInteger usuarioId;

    public TUsuarioXRolPK() {
    }

    public TUsuarioXRolPK(BigInteger rolId, BigInteger persId, BigInteger usuarioId) {
        this.rolId = rolId;
        this.persId = persId;
        this.usuarioId = usuarioId;
    }

    public BigInteger getRolId() {
        return rolId;
    }

    public void setRolId(BigInteger rolId) {
        this.rolId = rolId;
    }

    public BigInteger getPersId() {
        return persId;
    }

    public void setPersId(BigInteger persId) {
        this.persId = persId;
    }

    public BigInteger getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigInteger usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        hash += (persId != null ? persId.hashCode() : 0);
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUsuarioXRolPK)) {
            return false;
        }
        TUsuarioXRolPK other = (TUsuarioXRolPK) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        if ((this.persId == null && other.persId != null) || (this.persId != null && !this.persId.equals(other.persId))) {
            return false;
        }
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.TUsuarioXRolPK[ rolId=" + rolId + ", persId=" + persId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
