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
import javax.persistence.Id;
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
@Table(name = "M_PERFIL_RECURSOS_TI", schema = "TRN_RRHH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MPerfilRecursosTi.findAll", query = "SELECT m FROM MPerfilRecursosTi m")
    , @NamedQuery(name = "MPerfilRecursosTi.findByPerfilRecursoId", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.perfilRecursoId = :perfilRecursoId")
    , @NamedQuery(name = "MPerfilRecursosTi.findByPerfilRecursoDesc", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.perfilRecursoDesc = :perfilRecursoDesc")
    , @NamedQuery(name = "MPerfilRecursosTi.findByEqLaptop", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.eqLaptop = :eqLaptop")
    , @NamedQuery(name = "MPerfilRecursosTi.findByEqPc", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.eqPc = :eqPc")
    , @NamedQuery(name = "MPerfilRecursosTi.findByEqSmartphone", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.eqSmartphone = :eqSmartphone")
    , @NamedQuery(name = "MPerfilRecursosTi.findByEqMovilBasico", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.eqMovilBasico = :eqMovilBasico")
    , @NamedQuery(name = "MPerfilRecursosTi.findByEqPulseraSue\u00f1o", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.eqPulseraSue\u00f1o = :eqPulseraSue\u00f1o")
    , @NamedQuery(name = "MPerfilRecursosTi.findByEqSatelital", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.eqSatelital = :eqSatelital")
    , @NamedQuery(name = "MPerfilRecursosTi.findByAccPortalIas", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.accPortalIas = :accPortalIas")
    , @NamedQuery(name = "MPerfilRecursosTi.findByAccPortalErp", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.accPortalErp = :accPortalErp")
    , @NamedQuery(name = "MPerfilRecursosTi.findByAccOracleBs", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.accOracleBs = :accOracleBs")
    , @NamedQuery(name = "MPerfilRecursosTi.findByPerfilRecursoEstado", query = "SELECT m FROM MPerfilRecursosTi m WHERE m.perfilRecursoEstado = :perfilRecursoEstado")})
public class MPerfilRecursosTi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERFIL_RECURSO_ID")
    private BigDecimal perfilRecursoId;
    @Size(max = 500)
    @Column(name = "PERFIL_RECURSO_DESC")
    private String perfilRecursoDesc;
    @Column(name = "EQ_LAPTOP")
    private Character eqLaptop;
    @Column(name = "EQ_PC")
    private Character eqPc;
    @Column(name = "EQ_SMARTPHONE")
    private Character eqSmartphone;
    @Column(name = "EQ_MOVIL_BASICO")
    private Character eqMovilBasico;
    @Column(name = "EQ_PULSERA_SUE\u00d1O")
    private Character eqPulseraSueño;
    @Column(name = "EQ_SATELITAL")
    private Character eqSatelital;
    @Column(name = "ACC_PORTAL_IAS")
    private Character accPortalIas;
    @Column(name = "ACC_PORTAL_ERP")
    private Character accPortalErp;
    @Column(name = "ACC_ORACLE_BS")
    private Character accOracleBs;
    @Column(name = "PERFIL_RECURSO_ESTADO")
    private Character perfilRecursoEstado;
    @OneToMany(mappedBy = "perfilRecursosId")
    private Collection<MPuesto> mPuestoCollection;

    public MPerfilRecursosTi() {
    }

    public MPerfilRecursosTi(BigDecimal perfilRecursoId) {
        this.perfilRecursoId = perfilRecursoId;
    }

    public BigDecimal getPerfilRecursoId() {
        return perfilRecursoId;
    }

    public void setPerfilRecursoId(BigDecimal perfilRecursoId) {
        this.perfilRecursoId = perfilRecursoId;
    }

    public String getPerfilRecursoDesc() {
        return perfilRecursoDesc;
    }

    public void setPerfilRecursoDesc(String perfilRecursoDesc) {
        this.perfilRecursoDesc = perfilRecursoDesc;
    }

    public Character getEqLaptop() {
        return eqLaptop;
    }

    public void setEqLaptop(Character eqLaptop) {
        this.eqLaptop = eqLaptop;
    }

    public Character getEqPc() {
        return eqPc;
    }

    public void setEqPc(Character eqPc) {
        this.eqPc = eqPc;
    }

    public Character getEqSmartphone() {
        return eqSmartphone;
    }

    public void setEqSmartphone(Character eqSmartphone) {
        this.eqSmartphone = eqSmartphone;
    }

    public Character getEqMovilBasico() {
        return eqMovilBasico;
    }

    public void setEqMovilBasico(Character eqMovilBasico) {
        this.eqMovilBasico = eqMovilBasico;
    }

    public Character getEqPulseraSueño() {
        return eqPulseraSueño;
    }

    public void setEqPulseraSueño(Character eqPulseraSueño) {
        this.eqPulseraSueño = eqPulseraSueño;
    }

    public Character getEqSatelital() {
        return eqSatelital;
    }

    public void setEqSatelital(Character eqSatelital) {
        this.eqSatelital = eqSatelital;
    }

    public Character getAccPortalIas() {
        return accPortalIas;
    }

    public void setAccPortalIas(Character accPortalIas) {
        this.accPortalIas = accPortalIas;
    }

    public Character getAccPortalErp() {
        return accPortalErp;
    }

    public void setAccPortalErp(Character accPortalErp) {
        this.accPortalErp = accPortalErp;
    }

    public Character getAccOracleBs() {
        return accOracleBs;
    }

    public void setAccOracleBs(Character accOracleBs) {
        this.accOracleBs = accOracleBs;
    }

    public Character getPerfilRecursoEstado() {
        return perfilRecursoEstado;
    }

    public void setPerfilRecursoEstado(Character perfilRecursoEstado) {
        this.perfilRecursoEstado = perfilRecursoEstado;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MPuesto> getMPuestoCollection() {
        return mPuestoCollection;
    }

    public void setMPuestoCollection(Collection<MPuesto> mPuestoCollection) {
        this.mPuestoCollection = mPuestoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilRecursoId != null ? perfilRecursoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MPerfilRecursosTi)) {
            return false;
        }
        MPerfilRecursosTi other = (MPerfilRecursosTi) object;
        if ((this.perfilRecursoId == null && other.perfilRecursoId != null) || (this.perfilRecursoId != null && !this.perfilRecursoId.equals(other.perfilRecursoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kassa.Entidad.MPerfilRecursosTi[ perfilRecursoId=" + perfilRecursoId + " ]";
    }
    
}
