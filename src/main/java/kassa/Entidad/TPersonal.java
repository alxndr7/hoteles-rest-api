/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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

/**
 *
 * @author TI-AQP
 */
@Entity
@Table(name = "T_PERSONAL", schema = "TRN_RRHH")
@XmlRootElement

@NamedQueries({
    @NamedQuery(name = "TPersonal.findAll", query = "SELECT t FROM TPersonal t")
    , @NamedQuery(name = "TPersonal.findByPersId", query = "SELECT t FROM TPersonal t WHERE t.persId = :persId")
    , @NamedQuery(name = "TPersonal.findByNombre1", query = "SELECT t FROM TPersonal t WHERE t.nombre1 = :nombre1")
    , @NamedQuery(name = "TPersonal.findByNombre2", query = "SELECT t FROM TPersonal t WHERE t.nombre2 = :nombre2")
    , @NamedQuery(name = "TPersonal.findByApePat", query = "SELECT t FROM TPersonal t WHERE t.apePat = :apePat")
    , @NamedQuery(name = "TPersonal.findByApeMat", query = "SELECT t FROM TPersonal t WHERE t.apeMat = :apeMat")
    , @NamedQuery(name = "TPersonal.findByMailTrn", query = "SELECT t FROM TPersonal t WHERE t.mailTrn = :mailTrn")
    , @NamedQuery(name = "TPersonal.findByMailPersonal", query = "SELECT t FROM TPersonal t WHERE t.mailPersonal = :mailPersonal")
    , @NamedQuery(name = "TPersonal.findByNacFecha", query = "SELECT t FROM TPersonal t WHERE t.nacFecha = :nacFecha")
    , @NamedQuery(name = "TPersonal.findByNacDistritoId", query = "SELECT t FROM TPersonal t WHERE t.nacDistritoId = :nacDistritoId")
    , @NamedQuery(name = "TPersonal.findByDirDistritoId", query = "SELECT t FROM TPersonal t WHERE t.dirDistritoId = :dirDistritoId")
    , @NamedQuery(name = "TPersonal.findByDireccion", query = "SELECT t FROM TPersonal t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TPersonal.findByTelefFijo", query = "SELECT t FROM TPersonal t WHERE t.telefFijo = :telefFijo")
    , @NamedQuery(name = "TPersonal.findByTelefCelular", query = "SELECT t FROM TPersonal t WHERE t.telefCelular = :telefCelular")
    , @NamedQuery(name = "TPersonal.findByTelefTrnRpc", query = "SELECT t FROM TPersonal t WHERE t.telefTrnRpc = :telefTrnRpc")
    , @NamedQuery(name = "TPersonal.findByTipoTrabajadorId", query = "SELECT t FROM TPersonal t WHERE t.tipoTrabajadorId = :tipoTrabajadorId")
    , @NamedQuery(name = "TPersonal.findByEstadoTrabajadorId", query = "SELECT t FROM TPersonal t WHERE t.estadoTrabajadorId = :estadoTrabajadorId")
    , @NamedQuery(name = "TPersonal.findByEstadoCivilId", query = "SELECT t FROM TPersonal t WHERE t.estadoCivilId = :estadoCivilId")
    , @NamedQuery(name = "TPersonal.findBySexoId", query = "SELECT t FROM TPersonal t WHERE t.sexoId = :sexoId")
    , @NamedQuery(name = "TPersonal.findByTipoSangreId", query = "SELECT t FROM TPersonal t WHERE t.tipoSangreId = :tipoSangreId")
    , @NamedQuery(name = "TPersonal.findBySucursalId", query = "SELECT t FROM TPersonal t WHERE t.sucursalId = :sucursalId")
    , @NamedQuery(name = "TPersonal.findByProyectoId", query = "SELECT t FROM TPersonal t WHERE t.proyectoId = :proyectoId")
    , @NamedQuery(name = "TPersonal.findByObs", query = "SELECT t FROM TPersonal t WHERE t.obs = :obs")
    , @NamedQuery(name = "TPersonal.findByCreacionFecha", query = "SELECT t FROM TPersonal t WHERE t.creacionFecha = :creacionFecha")
    , @NamedQuery(name = "TPersonal.findByCreadoPor", query = "SELECT t FROM TPersonal t WHERE t.creadoPor = :creadoPor")
    , @NamedQuery(name = "TPersonal.findByModificacionFecha", query = "SELECT t FROM TPersonal t WHERE t.modificacionFecha = :modificacionFecha")
    , @NamedQuery(name = "TPersonal.findByModificadoPor", query = "SELECT t FROM TPersonal t WHERE t.modificadoPor = :modificadoPor")
    , @NamedQuery(name = "TPersonal.findByEliminacionFecha", query = "SELECT t FROM TPersonal t WHERE t.eliminacionFecha = :eliminacionFecha")
    , @NamedQuery(name = "TPersonal.findByEliminadoPor", query = "SELECT t FROM TPersonal t WHERE t.eliminadoPor = :eliminadoPor")
    , @NamedQuery(name = "TPersonal.findByDiscapacitado", query = "SELECT t FROM TPersonal t WHERE t.discapacitado = :discapacitado")
    , @NamedQuery(name = "TPersonal.findByDepositarioCts", query = "SELECT t FROM TPersonal t WHERE t.depositarioCts = :depositarioCts")
    , @NamedQuery(name = "TPersonal.findByDepositarioRemun", query = "SELECT t FROM TPersonal t WHERE t.depositarioRemun = :depositarioRemun")
    , @NamedQuery(name = "TPersonal.findByEliminado", query = "SELECT t FROM TPersonal t WHERE t.eliminado = :eliminado")
    , @NamedQuery(name = "TPersonal.findByFotoNombre", query = "SELECT t FROM TPersonal t WHERE t.fotoNombre = :fotoNombre")
    , @NamedQuery(name = "TPersonal.findByOcupacionId", query = "SELECT t FROM TPersonal t WHERE t.ocupacionId = :ocupacionId")
    , @NamedQuery(name = "TPersonal.findByProveedorId", query = "SELECT t FROM TPersonal t WHERE t.proveedorId = :proveedorId")
    , @NamedQuery(name = "TPersonal.findByTipoVia", query = "SELECT t FROM TPersonal t WHERE t.tipoVia = :tipoVia")
    , @NamedQuery(name = "TPersonal.findByNomVia", query = "SELECT t FROM TPersonal t WHERE t.nomVia = :nomVia")
    , @NamedQuery(name = "TPersonal.findByNumVia", query = "SELECT t FROM TPersonal t WHERE t.numVia = :numVia")
    , @NamedQuery(name = "TPersonal.findByMz", query = "SELECT t FROM TPersonal t WHERE t.mz = :mz")
    , @NamedQuery(name = "TPersonal.findByLt", query = "SELECT t FROM TPersonal t WHERE t.lt = :lt")
    , @NamedQuery(name = "TPersonal.findByKm", query = "SELECT t FROM TPersonal t WHERE t.km = :km")
    , @NamedQuery(name = "TPersonal.findByTipoZona", query = "SELECT t FROM TPersonal t WHERE t.tipoZona = :tipoZona")
    , @NamedQuery(name = "TPersonal.findByNomZona", query = "SELECT t FROM TPersonal t WHERE t.nomZona = :nomZona")
    , @NamedQuery(name = "TPersonal.findByReferencia", query = "SELECT t FROM TPersonal t WHERE t.referencia = :referencia")
    , @NamedQuery(name = "TPersonal.findByInterior", query = "SELECT t FROM TPersonal t WHERE t.interior = :interior")
    , @NamedQuery(name = "TPersonal.findByDepartamento", query = "SELECT t FROM TPersonal t WHERE t.departamento = :departamento")
    , @NamedQuery(name = "TPersonal.findByBlock", query = "SELECT t FROM TPersonal t WHERE t.block = :block")
    , @NamedQuery(name = "TPersonal.findByEtapa", query = "SELECT t FROM TPersonal t WHERE t.etapa = :etapa")
    , @NamedQuery(name = "TPersonal.findByFotocheckId", query = "SELECT t FROM TPersonal t WHERE t.fotocheckId = :fotocheckId")
    , @NamedQuery(name = "TPersonal.findByCondicionId", query = "SELECT t FROM TPersonal t WHERE t.condicionId = :condicionId")
    , @NamedQuery(name = "TPersonal.findByCtaCts", query = "SELECT t FROM TPersonal t WHERE t.ctaCts = :ctaCts")
    , @NamedQuery(name = "TPersonal.findByCtaRemun", query = "SELECT t FROM TPersonal t WHERE t.ctaRemun = :ctaRemun")
    , @NamedQuery(name = "TPersonal.findByTallaCamId", query = "SELECT t FROM TPersonal t WHERE t.tallaCamId = :tallaCamId")
    , @NamedQuery(name = "TPersonal.findByTallaPan", query = "SELECT t FROM TPersonal t WHERE t.tallaPan = :tallaPan")
    , @NamedQuery(name = "TPersonal.findByTallaZap", query = "SELECT t FROM TPersonal t WHERE t.tallaZap = :tallaZap")
    , @NamedQuery(name = "TPersonal.findByContEmerNom", query = "SELECT t FROM TPersonal t WHERE t.contEmerNom = :contEmerNom")
    , @NamedQuery(name = "TPersonal.findByContEmerNum", query = "SELECT t FROM TPersonal t WHERE t.contEmerNum = :contEmerNum")
    , @NamedQuery(name = "TPersonal.findByNomina", query = "SELECT t FROM TPersonal t WHERE t.nomina = :nomina")
    , @NamedQuery(name = "TPersonal.findByNomIngFecha", query = "SELECT t FROM TPersonal t WHERE t.nomIngFecha = :nomIngFecha")
    , @NamedQuery(name = "TPersonal.findByNomSalFecha", query = "SELECT t FROM TPersonal t WHERE t.nomSalFecha = :nomSalFecha")
    , @NamedQuery(name = "TPersonal.findByNomObs", query = "SELECT t FROM TPersonal t WHERE t.nomObs = :nomObs")
    , @NamedQuery(name = "TPersonal.findByRemuneracion", query = "SELECT t FROM TPersonal t WHERE t.remuneracion = :remuneracion")
    , @NamedQuery(name = "TPersonal.findByRemAuth", query = "SELECT t FROM TPersonal t WHERE t.remAuth = :remAuth")
    , @NamedQuery(name = "TPersonal.findByCtsSd", query = "SELECT t FROM TPersonal t WHERE t.ctsSd = :ctsSd")
    , @NamedQuery(name = "TPersonal.findByNominaModificadoPor", query = "SELECT t FROM TPersonal t WHERE t.nominaModificadoPor = :nominaModificadoPor")
    , @NamedQuery(name = "TPersonal.findByNomModFecha", query = "SELECT t FROM TPersonal t WHERE t.nomModFecha = :nomModFecha")
    , @NamedQuery(name = "TPersonal.findByAlergia", query = "SELECT t FROM TPersonal t WHERE t.alergia = :alergia")
    , @NamedQuery(name = "TPersonal.findByAlergiaDesc", query = "SELECT t FROM TPersonal t WHERE t.alergiaDesc = :alergiaDesc")
    , @NamedQuery(name = "TPersonal.findByReferenciaDir", query = "SELECT t FROM TPersonal t WHERE t.referenciaDir = :referenciaDir")})
public class TPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERS_ID")
    private BigDecimal persId;
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
    @Size(max = 6)
    @Column(name = "NAC_DISTRITO_ID")
    private String nacDistritoId;
    @Size(max = 6)
    @Column(name = "DIR_DISTRITO_ID")
    private String dirDistritoId;
    @Size(max = 150)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 10)
    @Column(name = "TELEF_FIJO")
    private String telefFijo;
    @Size(max = 15)
    @Column(name = "TELEF_CELULAR")
    private String telefCelular;
    @Size(max = 10)
    @Column(name = "TELEF_TRN_RPC")
    private String telefTrnRpc;
    @Column(name = "TIPO_TRABAJADOR_ID")
    private BigInteger tipoTrabajadorId;
    @Column(name = "ESTADO_TRABAJADOR_ID")
    private BigInteger estadoTrabajadorId;
    @Column(name = "ESTADO_CIVIL_ID")
    private BigInteger estadoCivilId;
    @Column(name = "SEXO_ID")
    private BigInteger sexoId;
    @Column(name = "TIPO_SANGRE_ID")
    private BigInteger tipoSangreId;
    @Column(name = "SUCURSAL_ID")
    private BigInteger sucursalId;
    @Size(max = 10)
    @Column(name = "PROYECTO_ID")
    private String proyectoId;
    @Size(max = 200)
    @Column(name = "OBS")
    private String obs;
    @Column(name = "CREACION_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creacionFecha;
    @Column(name = "CREADO_POR")
    private BigInteger creadoPor;
    @Column(name = "MODIFICACION_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacionFecha;
    @Column(name = "MODIFICADO_POR")
    private BigInteger modificadoPor;
    @Column(name = "ELIMINACION_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eliminacionFecha;
    @Column(name = "ELIMINADO_POR")
    private BigInteger eliminadoPor;
    @Column(name = "DISCAPACITADO")
    private Character discapacitado;
    @Column(name = "DEPOSITARIO_CTS")
    private BigInteger depositarioCts;
    @Column(name = "DEPOSITARIO_REMUN")
    private BigInteger depositarioRemun;
    @Column(name = "ELIMINADO")
    private Character eliminado;
    @Column(name = "FOTO_NOMBRE")
    private BigInteger fotoNombre;
    @Size(max = 10)
    @Column(name = "OCUPACION_ID")
    private String ocupacionId;
    @Size(max = 10)
    @Column(name = "PROVEEDOR_ID")
    private String proveedorId;
    @Column(name = "TIPO_VIA")
    private BigInteger tipoVia;
    @Size(max = 20)
    @Column(name = "NOM_VIA")
    private String nomVia;
    @Size(max = 4)
    @Column(name = "NUM_VIA")
    private String numVia;
    @Size(max = 4)
    @Column(name = "MZ")
    private String mz;
    @Size(max = 4)
    @Column(name = "LT")
    private String lt;
    @Size(max = 4)
    @Column(name = "KM")
    private String km;
    @Column(name = "TIPO_ZONA")
    private BigInteger tipoZona;
    @Size(max = 20)
    @Column(name = "NOM_ZONA")
    private String nomZona;
    @Size(max = 40)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Size(max = 4)
    @Column(name = "INTERIOR")
    private String interior;
    @Size(max = 4)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Size(max = 4)
    @Column(name = "BLOCK")
    private String block;
    @Size(max = 4)
    @Column(name = "ETAPA")
    private String etapa;
    @Size(max = 10)
    @Column(name = "FOTOCHECK_ID")
    private String fotocheckId;
    @Column(name = "CONDICION_ID")
    private BigInteger condicionId;
    @Size(max = 50)
    @Column(name = "CTA_CTS")
    private String ctaCts;
    @Size(max = 50)
    @Column(name = "CTA_REMUN")
    private String ctaRemun;
    @Column(name = "TALLA_CAM_ID")
    private BigInteger tallaCamId;
    @Size(max = 20)
    @Column(name = "TALLA_PAN")
    private String tallaPan;
    @Size(max = 20)
    @Column(name = "TALLA_ZAP")
    private String tallaZap;
    @Size(max = 150)
    @Column(name = "CONT_EMER_NOM")
    private String contEmerNom;
    @Size(max = 50)
    @Column(name = "CONT_EMER_NUM")
    private String contEmerNum;
    @Size(max = 200)
    @Column(name = "NOMINA")
    private String nomina;
    @Column(name = "NOM_ING_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nomIngFecha;
    @Column(name = "NOM_SAL_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nomSalFecha;
    @Size(max = 250)
    @Column(name = "NOM_OBS")
    private String nomObs;
    @Size(max = 250)
    @Column(name = "REMUNERACION")
    private String remuneracion;
    @Column(name = "REM_AUTH")
    private Character remAuth;
    @Column(name = "CTS_SD")
    private Character ctsSd;
    @Column(name = "NOMINA_MODIFICADO_POR")
    private BigInteger nominaModificadoPor;
    @Column(name = "NOM_MOD_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nomModFecha;
    @Column(name = "ALERGIA")
    private Character alergia;
    @Size(max = 250)
    @Column(name = "ALERGIA_DESC")
    private String alergiaDesc;
    @Size(max = 250)
    @Column(name = "REFERENCIA_DIR")
    private String referenciaDir;
    @OneToMany(mappedBy = "areaJefeId")
    private Collection<MArea> mAreaCollection;
    @JoinColumn(name = "PUESTO_ID", referencedColumnName = "PUESTO_ID")
    @ManyToOne
    private MPuesto puestoId;

    public TPersonal() {
    }

    public TPersonal(BigDecimal persId) {
        this.persId = persId;
    }

    public TPersonal(BigDecimal persId, String nombre1, String apePat) {
        this.persId = persId;
        this.nombre1 = nombre1;
        this.apePat = apePat;
    }

    public BigDecimal getPersId() {
        return persId;
    }

    public void setPersId(BigDecimal persId) {
        this.persId = persId;
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

    public String getNacDistritoId() {
        return nacDistritoId;
    }

    public void setNacDistritoId(String nacDistritoId) {
        this.nacDistritoId = nacDistritoId;
    }

    public String getDirDistritoId() {
        return dirDistritoId;
    }

    public void setDirDistritoId(String dirDistritoId) {
        this.dirDistritoId = dirDistritoId;
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

    public String getTelefTrnRpc() {
        return telefTrnRpc;
    }

    public void setTelefTrnRpc(String telefTrnRpc) {
        this.telefTrnRpc = telefTrnRpc;
    }

    public BigInteger getTipoTrabajadorId() {
        return tipoTrabajadorId;
    }

    public void setTipoTrabajadorId(BigInteger tipoTrabajadorId) {
        this.tipoTrabajadorId = tipoTrabajadorId;
    }

    public BigInteger getEstadoTrabajadorId() {
        return estadoTrabajadorId;
    }

    public void setEstadoTrabajadorId(BigInteger estadoTrabajadorId) {
        this.estadoTrabajadorId = estadoTrabajadorId;
    }

    public BigInteger getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(BigInteger estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public BigInteger getSexoId() {
        return sexoId;
    }

    public void setSexoId(BigInteger sexoId) {
        this.sexoId = sexoId;
    }

    public BigInteger getTipoSangreId() {
        return tipoSangreId;
    }

    public void setTipoSangreId(BigInteger tipoSangreId) {
        this.tipoSangreId = tipoSangreId;
    }

    public BigInteger getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(BigInteger sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getCreacionFecha() {
        return creacionFecha;
    }

    public void setCreacionFecha(Date creacionFecha) {
        this.creacionFecha = creacionFecha;
    }

    public BigInteger getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(BigInteger creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getModificacionFecha() {
        return modificacionFecha;
    }

    public void setModificacionFecha(Date modificacionFecha) {
        this.modificacionFecha = modificacionFecha;
    }

    public BigInteger getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(BigInteger modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getEliminacionFecha() {
        return eliminacionFecha;
    }

    public void setEliminacionFecha(Date eliminacionFecha) {
        this.eliminacionFecha = eliminacionFecha;
    }

    public BigInteger getEliminadoPor() {
        return eliminadoPor;
    }

    public void setEliminadoPor(BigInteger eliminadoPor) {
        this.eliminadoPor = eliminadoPor;
    }

    public Character getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(Character discapacitado) {
        this.discapacitado = discapacitado;
    }

    public BigInteger getDepositarioCts() {
        return depositarioCts;
    }

    public void setDepositarioCts(BigInteger depositarioCts) {
        this.depositarioCts = depositarioCts;
    }

    public BigInteger getDepositarioRemun() {
        return depositarioRemun;
    }

    public void setDepositarioRemun(BigInteger depositarioRemun) {
        this.depositarioRemun = depositarioRemun;
    }

    public Character getEliminado() {
        return eliminado;
    }

    public void setEliminado(Character eliminado) {
        this.eliminado = eliminado;
    }

    public BigInteger getFotoNombre() {
        return fotoNombre;
    }

    public void setFotoNombre(BigInteger fotoNombre) {
        this.fotoNombre = fotoNombre;
    }

    public String getOcupacionId() {
        return ocupacionId;
    }

    public void setOcupacionId(String ocupacionId) {
        this.ocupacionId = ocupacionId;
    }

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    public BigInteger getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(BigInteger tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNomVia() {
        return nomVia;
    }

    public void setNomVia(String nomVia) {
        this.nomVia = nomVia;
    }

    public String getNumVia() {
        return numVia;
    }

    public void setNumVia(String numVia) {
        this.numVia = numVia;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public BigInteger getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(BigInteger tipoZona) {
        this.tipoZona = tipoZona;
    }

    public String getNomZona() {
        return nomZona;
    }

    public void setNomZona(String nomZona) {
        this.nomZona = nomZona;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getFotocheckId() {
        return fotocheckId;
    }

    public void setFotocheckId(String fotocheckId) {
        this.fotocheckId = fotocheckId;
    }

    public BigInteger getCondicionId() {
        return condicionId;
    }

    public void setCondicionId(BigInteger condicionId) {
        this.condicionId = condicionId;
    }

    public String getCtaCts() {
        return ctaCts;
    }

    public void setCtaCts(String ctaCts) {
        this.ctaCts = ctaCts;
    }

    public String getCtaRemun() {
        return ctaRemun;
    }

    public void setCtaRemun(String ctaRemun) {
        this.ctaRemun = ctaRemun;
    }

    public BigInteger getTallaCamId() {
        return tallaCamId;
    }

    public void setTallaCamId(BigInteger tallaCamId) {
        this.tallaCamId = tallaCamId;
    }

    public String getTallaPan() {
        return tallaPan;
    }

    public void setTallaPan(String tallaPan) {
        this.tallaPan = tallaPan;
    }

    public String getTallaZap() {
        return tallaZap;
    }

    public void setTallaZap(String tallaZap) {
        this.tallaZap = tallaZap;
    }

    public String getContEmerNom() {
        return contEmerNom;
    }

    public void setContEmerNom(String contEmerNom) {
        this.contEmerNom = contEmerNom;
    }

    public String getContEmerNum() {
        return contEmerNum;
    }

    public void setContEmerNum(String contEmerNum) {
        this.contEmerNum = contEmerNum;
    }

    public String getNomina() {
        return nomina;
    }

    public void setNomina(String nomina) {
        this.nomina = nomina;
    }

    public Date getNomIngFecha() {
        return nomIngFecha;
    }

    public void setNomIngFecha(Date nomIngFecha) {
        this.nomIngFecha = nomIngFecha;
    }

    public Date getNomSalFecha() {
        return nomSalFecha;
    }

    public void setNomSalFecha(Date nomSalFecha) {
        this.nomSalFecha = nomSalFecha;
    }

    public String getNomObs() {
        return nomObs;
    }

    public void setNomObs(String nomObs) {
        this.nomObs = nomObs;
    }

    public String getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(String remuneracion) {
        this.remuneracion = remuneracion;
    }

    public Character getRemAuth() {
        return remAuth;
    }

    public void setRemAuth(Character remAuth) {
        this.remAuth = remAuth;
    }

    public Character getCtsSd() {
        return ctsSd;
    }

    public void setCtsSd(Character ctsSd) {
        this.ctsSd = ctsSd;
    }

    public BigInteger getNominaModificadoPor() {
        return nominaModificadoPor;
    }

    public void setNominaModificadoPor(BigInteger nominaModificadoPor) {
        this.nominaModificadoPor = nominaModificadoPor;
    }

    public Date getNomModFecha() {
        return nomModFecha;
    }

    public void setNomModFecha(Date nomModFecha) {
        this.nomModFecha = nomModFecha;
    }

    public Character getAlergia() {
        return alergia;
    }

    public void setAlergia(Character alergia) {
        this.alergia = alergia;
    }

    public String getAlergiaDesc() {
        return alergiaDesc;
    }

    public void setAlergiaDesc(String alergiaDesc) {
        this.alergiaDesc = alergiaDesc;
    }

    public String getReferenciaDir() {
        return referenciaDir;
    }

    public void setReferenciaDir(String referenciaDir) {
        this.referenciaDir = referenciaDir;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<MArea> getMAreaCollection() {
        return mAreaCollection;
    }

    public void setMAreaCollection(Collection<MArea> mAreaCollection) {
        this.mAreaCollection = mAreaCollection;
    }

    public MPuesto getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(MPuesto puestoId) {
        this.puestoId = puestoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persId != null ? persId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPersonal)) {
            return false;
        }
        TPersonal other = (TPersonal) object;
        if ((this.persId == null && other.persId != null) || (this.persId != null && !this.persId.equals(other.persId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TPersonal{" + "persId=" + persId + ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", apePat=" + apePat + ", apeMat=" + apeMat + ", mailTrn=" + mailTrn + ", mailPersonal=" + mailPersonal + ", nacFecha=" + nacFecha + ", nacDistritoId=" + nacDistritoId + ", dirDistritoId=" + dirDistritoId + ", direccion=" + direccion + ", telefFijo=" + telefFijo + ", telefCelular=" + telefCelular + ", telefTrnRpc=" + telefTrnRpc + ", tipoTrabajadorId=" + tipoTrabajadorId + ", estadoTrabajadorId=" + estadoTrabajadorId + ", estadoCivilId=" + estadoCivilId + ", sexoId=" + sexoId + ", tipoSangreId=" + tipoSangreId + ", sucursalId=" + sucursalId + ", proyectoId=" + proyectoId + ", obs=" + obs + ", creacionFecha=" + creacionFecha + ", creadoPor=" + creadoPor + ", modificacionFecha=" + modificacionFecha + ", modificadoPor=" + modificadoPor + ", eliminacionFecha=" + eliminacionFecha + ", eliminadoPor=" + eliminadoPor + ", discapacitado=" + discapacitado + ", depositarioCts=" + depositarioCts + ", depositarioRemun=" + depositarioRemun + ", eliminado=" + eliminado + ", fotoNombre=" + fotoNombre + ", ocupacionId=" + ocupacionId + ", proveedorId=" + proveedorId + ", tipoVia=" + tipoVia + ", nomVia=" + nomVia + ", numVia=" + numVia + ", mz=" + mz + ", lt=" + lt + ", km=" + km + ", tipoZona=" + tipoZona + ", nomZona=" + nomZona + ", referencia=" + referencia + ", interior=" + interior + ", departamento=" + departamento + ", block=" + block + ", etapa=" + etapa + ", fotocheckId=" + fotocheckId + ", condicionId=" + condicionId + ", ctaCts=" + ctaCts + ", ctaRemun=" + ctaRemun + ", tallaCamId=" + tallaCamId + ", tallaPan=" + tallaPan + ", tallaZap=" + tallaZap + ", contEmerNom=" + contEmerNom + ", contEmerNum=" + contEmerNum + ", nomina=" + nomina + ", nomIngFecha=" + nomIngFecha + ", nomSalFecha=" + nomSalFecha + ", nomObs=" + nomObs + ", remuneracion=" + remuneracion + ", remAuth=" + remAuth + ", ctsSd=" + ctsSd + ", nominaModificadoPor=" + nominaModificadoPor + ", nomModFecha=" + nomModFecha + ", alergia=" + alergia + ", alergiaDesc=" + alergiaDesc + ", referenciaDir=" + referenciaDir + ", mAreaCollection=" + mAreaCollection + ", puestoId=" + puestoId + '}';
    }

    
    
}
