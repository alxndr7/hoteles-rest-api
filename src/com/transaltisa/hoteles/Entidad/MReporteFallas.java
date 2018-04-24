package com.transaltisa.hoteles.Entidad;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "M_REPORTE_FALLAS",schema = "TRN_SISTEMAS")
public class MReporteFallas implements Serializable{

    @Id
    @Column(name = "ID_REPORTE_FALLA")
    private Long idReporteFalla;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "REPORTE_FECHA")
    private String reporteFecha;

    @Column(name = "EMPRESA")
    private String empresa;

    @Column(name = "CONVOY")
    private String convoy;

    @Column(name = "PLACA_TRACTO")
    private String placaTracto;

    @Column(name = "PLACA_CARRETA")
    private String placaCarreta;

    @Column(name = "KILOMETRAJE")
    private String kilometraje;

    @Column(name = "UBICACION")
    private String ubicacion;

    @Column(name = "DESC_FALLA")
    private String descFalla;

    @Column(name = "USUARIO_ID")
    private String usuarioId;

    @Column(name = "RUTA")
    private String ruta;

    @Column(name = "FLOTA")
    private String flota;

    @Column(name = "IMAGEN_1")
    private byte[] imagen1;

    @Column(name = "IMAGEN_2")
    private byte[] imagen2;

    @Column(name = "IMAGEN_3")
    private byte[] imagen3;

    @Column(name = "ESTADO_REPORTE")
    private String estadoReporte;




    public MReporteFallas() {
    }

    public MReporteFallas(Long idReporteFalla, String titulo, String reporteFecha, String empresa, String convoy, String placaTracto, String placaCarreta, String kilometraje, String ubicacion, String descFalla, String usuarioId, String ruta, String flota, byte[] imagen1, String estadoReporte) {
        this.idReporteFalla = idReporteFalla;
        this.titulo = titulo;
        this.reporteFecha = reporteFecha;
        this.empresa = empresa;
        this.convoy = convoy;
        this.placaTracto = placaTracto;
        this.placaCarreta = placaCarreta;
        this.kilometraje = kilometraje;
        this.ubicacion = ubicacion;
        this.descFalla = descFalla;
        this.usuarioId = usuarioId;
        this.ruta = ruta;
        this.flota = flota;
        this.imagen1 = imagen1;
        this.estadoReporte = estadoReporte;
    }


    public MReporteFallas(Long idReporteFalla, String titulo, String reporteFecha, String empresa, String convoy, String placaTracto, String placaCarreta, String kilometraje, String ubicacion, String descFalla, String usuarioId, String ruta, String flota, byte[] imagen1, byte[] imagen2, byte[] imagen3, String estadoReporte) {
        this.idReporteFalla = idReporteFalla;
        this.titulo = titulo;
        this.reporteFecha = reporteFecha;
        this.empresa = empresa;
        this.convoy = convoy;
        this.placaTracto = placaTracto;
        this.placaCarreta = placaCarreta;
        this.kilometraje = kilometraje;
        this.ubicacion = ubicacion;
        this.descFalla = descFalla;
        this.usuarioId = usuarioId;
        this.ruta = ruta;
        this.flota = flota;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.estadoReporte = estadoReporte;
    }

    public Long getIdReporteFalla() {
        return idReporteFalla;
    }

    public void setIdReporteFalla(Long idReporteFalla) {
        this.idReporteFalla = idReporteFalla;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getReporteFecha() {
        return reporteFecha;
    }

    public void setReporteFecha(String reporteFecha) {
        this.reporteFecha = reporteFecha;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getConvoy() {
        return convoy;
    }

    public void setConvoy(String convoy) {
        this.convoy = convoy;
    }

    public String getPlacaTracto() {
        return placaTracto;
    }

    public void setPlacaTracto(String placaTracto) {
        this.placaTracto = placaTracto;
    }

    public String getPlacaCarreta() {
        return placaCarreta;
    }

    public void setPlacaCarreta(String placaCarreta) {
        this.placaCarreta = placaCarreta;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescFalla() {
        return descFalla;
    }

    public void setDescFalla(String descFalla) {
        this.descFalla = descFalla;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getFlota() {
        return flota;
    }

    public void setFlota(String flota) {
        this.flota = flota;
    }

    public byte[] getImagen1() {
        return imagen1;
    }

    public void setImagen1(byte[] imagen1) {
        this.imagen1 = imagen1;
    }

    public String getEstadoReporte() {
        return estadoReporte;
    }

    public void setEstadoReporte(String estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    public byte[] getImagen2() {
        return imagen2;
    }

    public void setImagen2(byte[] imagen2) {
        this.imagen2 = imagen2;
    }

    public byte[] getImagen3() {
        return imagen3;
    }

    public void setImagen3(byte[] imagen3) {
        this.imagen3 = imagen3;
    }
}
