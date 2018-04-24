package com.transaltisa.hoteles.Entidad;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@Entity
@Table(name = "M_USUARIOS_TERCEROS",schema = "LOGISTICA")
public class MUsuarioTerceros implements Serializable{

    @Id
    @Column(name = "ID_USUARIO_T")
    private Long idUsuarioT;

    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @Column(name = "APELLIDO_USUARIO")
    private String apellidoUsuario;

    @Column(name = "DNI_USUARIO")
    private String dniUsuario;

    @Column(name = "ROL_USUARIO")
    private String rolUsuario;

    @Column(name = "USU_USUARIO")
    private String usuUsuario;

    @Column(name = "PASSW_USUARIO")
    private String passwUsuario;

    @Column(name = "HOTEL_ID")
    private Long hotelId;

    public MUsuarioTerceros() {
    }

    public MUsuarioTerceros(Long idUsuarioT, String nombreUsuario, String apellidoUsuario, String dniUsuario, String rolUsuario, String usuUsuario, String passwUsuario, Long hotelId) {
        this.idUsuarioT = idUsuarioT;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.dniUsuario = dniUsuario;
        this.rolUsuario = rolUsuario;
        this.usuUsuario = usuUsuario;
        this.passwUsuario = passwUsuario;
        this.hotelId = hotelId;
    }

    public Long getIdUsuarioT() {
        return idUsuarioT;
    }

    public void setIdUsuarioT(Long idUsuarioT) {
        this.idUsuarioT = idUsuarioT;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getPasswUsuario() {
        return passwUsuario;
    }

    public void setPasswUsuario(String passwUsuario) {
        this.passwUsuario = passwUsuario;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
}
