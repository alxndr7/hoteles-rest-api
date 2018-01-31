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
 * @author TI-AQP
 */
@Embeddable
public class MGuiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "GUI_ID")
    private BigInteger guiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NODO_ID")
    private BigInteger nodoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODULO_ID")
    private BigInteger moduloId;

    public MGuiPK() {
    }

    public MGuiPK(BigInteger guiId, BigInteger nodoId, BigInteger moduloId) {
        this.guiId = guiId;
        this.nodoId = nodoId;
        this.moduloId = moduloId;
    }

    public BigInteger getGuiId() {
        return guiId;
    }

    public void setGuiId(BigInteger guiId) {
        this.guiId = guiId;
    }

    public BigInteger getNodoId() {
        return nodoId;
    }

    public void setNodoId(BigInteger nodoId) {
        this.nodoId = nodoId;
    }

    public BigInteger getModuloId() {
        return moduloId;
    }

    public void setModuloId(BigInteger moduloId) {
        this.moduloId = moduloId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guiId != null ? guiId.hashCode() : 0);
        hash += (nodoId != null ? nodoId.hashCode() : 0);
        hash += (moduloId != null ? moduloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MGuiPK)) {
            return false;
        }
        MGuiPK other = (MGuiPK) object;
        if ((this.guiId == null && other.guiId != null) || (this.guiId != null && !this.guiId.equals(other.guiId))) {
            return false;
        }
        if ((this.nodoId == null && other.nodoId != null) || (this.nodoId != null && !this.nodoId.equals(other.nodoId))) {
            return false;
        }
        if ((this.moduloId == null && other.moduloId != null) || (this.moduloId != null && !this.moduloId.equals(other.moduloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MGuiPK[ guiId=" + guiId + ", nodoId=" + nodoId + ", moduloId=" + moduloId + " ]";
    }
    
}
