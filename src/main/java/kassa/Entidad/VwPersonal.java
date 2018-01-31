/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CESAR-TRN
 */
@Entity
@Table(name = "VW_PERSONAL", schema = "TRN_SISTEMAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwPersonal.findAll", query = "SELECT v FROM VwPersonal v")
    , @NamedQuery(name = "VwPersonal.findByUsuarioId", query = "SELECT v FROM VwPersonal v WHERE v.usuarioId = :usuarioId")
    , @NamedQuery(name = "VwPersonal.findByPersId", query = "SELECT v FROM VwPersonal v WHERE v.persId = :persId")
    , @NamedQuery(name = "VwPersonal.findByUsuUsuario", query = "SELECT v FROM VwPersonal v WHERE v.usuUsuario = :usuUsuario")
    , @NamedQuery(name = "VwPersonal.findByUsuPassword", query = "SELECT v FROM VwPersonal v WHERE v.usuPassword = :usuPassword")
    , @NamedQuery(name = "VwPersonal.findByNombre1", query = "SELECT v FROM VwPersonal v WHERE v.nombre1 = :nombre1")
    , @NamedQuery(name = "VwPersonal.findByNombre2", query = "SELECT v FROM VwPersonal v WHERE v.nombre2 = :nombre2")
    , @NamedQuery(name = "VwPersonal.findByApePat", query = "SELECT v FROM VwPersonal v WHERE v.apePat = :apePat")
    , @NamedQuery(name = "VwPersonal.findByApeMat", query = "SELECT v FROM VwPersonal v WHERE v.apeMat = :apeMat")
    , @NamedQuery(name = "VwPersonal.findByMailTrn", query = "SELECT v FROM VwPersonal v WHERE v.mailTrn = :mailTrn")
    , @NamedQuery(name = "VwPersonal.findByMailPersonal", query = "SELECT v FROM VwPersonal v WHERE v.mailPersonal = :mailPersonal")
    , @NamedQuery(name = "VwPersonal.findByNacFecha", query = "SELECT v FROM VwPersonal v WHERE v.nacFecha = :nacFecha")
    , @NamedQuery(name = "VwPersonal.findByNacDist", query = "SELECT v FROM VwPersonal v WHERE v.nacDist = :nacDist")
    , @NamedQuery(name = "VwPersonal.findByDirDist", query = "SELECT v FROM VwPersonal v WHERE v.dirDist = :dirDist")
    , @NamedQuery(name = "VwPersonal.findByDireccion", query = "SELECT v FROM VwPersonal v WHERE v.direccion = :direccion")
    , @NamedQuery(name = "VwPersonal.findByTelefFijo", query = "SELECT v FROM VwPersonal v WHERE v.telefFijo = :telefFijo")
    , @NamedQuery(name = "VwPersonal.findByTelefCelular", query = "SELECT v FROM VwPersonal v WHERE v.telefCelular = :telefCelular")
    , @NamedQuery(name = "VwPersonal.findByPuestoNombre", query = "SELECT v FROM VwPersonal v WHERE v.puestoNombre = :puestoNombre")
    , @NamedQuery(name = "VwPersonal.findBySexo", query = "SELECT v FROM VwPersonal v WHERE v.sexo = :sexo")
    , @NamedQuery(name = "VwPersonal.findByEstado", query = "SELECT v FROM VwPersonal v WHERE v.estado = :estado")
    , @NamedQuery(name = "VwPersonal.findByReferenciaDir", query = "SELECT v FROM VwPersonal v WHERE v.referenciaDir = :referenciaDir")})
public class VwPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID")
    @Id
    private BigInteger usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERS_ID")
    private BigInteger persId;
    @Size(max = 60)
    @Column(name = "USU_USUARIO")
    private String usuUsuario;
    @Size(max = 300)
    @Column(name = "USU_PASSWORD")
    private String usuPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE1")
    private String nombre1;
    @Size(max = 40)
    @Column(name = "NOMBRE2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "APE_PAT")
    private String apePat;
    @Size(max = 40)
    @Column(name = "APE_MAT")
    private String apeMat;
    @Size(max = 40)
    @Column(name = "MAIL_TRN")
    private String mailTrn;
    @Size(max = 40)
    @Column(name = "MAIL_PERSONAL")
    private String mailPersonal;
    @Column(name = "NAC_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nacFecha;
    @Size(max = 50)
    @Column(name = "NAC_DIST")
    private String nacDist;
    @Size(max = 50)
    @Column(name = "DIR_DIST")
    private String dirDist;
    @Size(max = 150)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 10)
    @Column(name = "TELEF_FIJO")
    private String telefFijo;
    @Size(max = 15)
    @Column(name = "TELEF_CELULAR")
    private String telefCelular;
    @Size(max = 60)
    @Column(name = "PUESTO_NOMBRE")
    private String puestoNombre;
    @Size(max = 200)
    @Column(name = "SEXO")
    private String sexo;
    @Size(max = 200)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 250)
    @Column(name = "REFERENCIA_DIR")
    private String referenciaDir;

    public VwPersonal() {
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

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public String getMailTrn() {
        return mailTrn;
    }

    public void setMailTrn(String mailTrn) {
        this.mailTrn = mailTrn;
    }

    public String getMailPersonal() {
        return mailPersonal;
    }

    public void setMailPersonal(String mailPersonal) {
        this.mailPersonal = mailPersonal;
    }

    public Date getNacFecha() {
        return nacFecha;
    }

    public void setNacFecha(Date nacFecha) {
        this.nacFecha = nacFecha;
    }

    public String getNacDist() {
        return nacDist;
    }

    public void setNacDist(String nacDist) {
        this.nacDist = nacDist;
    }

    public String getDirDist() {
        return dirDist;
    }

    public void setDirDist(String dirDist) {
        this.dirDist = dirDist;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefFijo() {
        return telefFijo;
    }

    public void setTelefFijo(String telefFijo) {
        this.telefFijo = telefFijo;
    }

    public String getTelefCelular() {
        return telefCelular;
    }

    public void setTelefCelular(String telefCelular) {
        this.telefCelular = telefCelular;
    }

    public String getPuestoNombre() {
        return puestoNombre;
    }

    public void setPuestoNombre(String puestoNombre) {
        this.puestoNombre = puestoNombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferenciaDir() {
        return referenciaDir;
    }

    public void setReferenciaDir(String referenciaDir) {
        this.referenciaDir = referenciaDir;
    }
    
}
