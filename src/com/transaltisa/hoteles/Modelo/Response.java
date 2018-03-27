package com.transaltisa.hoteles.Modelo;

/**
 * Created by CESAR-TRN on 26/03/2018.
 */
public class Response {

    String mensaje;

    public Response(String mensaje) {
        this.mensaje = mensaje;
    }

    public Response() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
