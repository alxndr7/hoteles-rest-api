/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transaltisa.hoteles.Entidad;

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
public class MUsuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID")
    private BigInteger usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERS_ID")
    private BigInteger persId;

    public MUsuarioPK() {
    }

    public MUsuarioPK(BigInteger usuarioId, BigInteger persId) {
        this.usuarioId = usuarioId;
        this.persId = persId;
    }

    public BigInteger getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(BigInteger usuarioId) {
        this.usuarioId = usuarioId;
    }

    public BigInteger getPersId() {
        return persId;
    }

    public void setPersId(BigInteger persId) {
        this.persId = persId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        hash += (persId != null ? persId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MUsuarioPK)) {
            return false;
        }
        MUsuarioPK other = (MUsuarioPK) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        if ((this.persId == null && other.persId != null) || (this.persId != null && !this.persId.equals(other.persId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.transaltisa.hoteles.Entidad.MUsuarioPK[ usuarioId=" + usuarioId + ", persId=" + persId + " ]";
    }
    
}
