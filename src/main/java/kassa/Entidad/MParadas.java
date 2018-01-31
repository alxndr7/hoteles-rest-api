/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kassa.Entidad;

/**
 *
 * @author OPE-REU
 */
public class MParadas {
    
   
    private int geo_id;
    private String veh_id;
    private int vel_min;
    private long latitud;
    private long longitud;
    private String min;
    private String max;
    private String tiempo;

    public MParadas(int geo_id, String veh_id, int vel_min, long latitud, long longitud, String min, String max, String tiempo) {
        this.geo_id = geo_id;
        this.veh_id = veh_id;
        this.vel_min = vel_min;
        this.latitud = latitud;
        this.longitud = longitud;
        this.min = min;
        this.max = max;
        this.tiempo = tiempo;
    }

    public int getGeo_id() {
        return geo_id;
    }

    public String getVeh_id() {
        return veh_id;
    }

    public int getVel_min() {
        return vel_min;
    }

    public long getLatitud() {
        return latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setGeo_id(int geo_id) {
        this.geo_id = geo_id;
    }

    public void setVeh_id(String veh_id) {
        this.veh_id = veh_id;
    }

    public void setVel_min(int vel_min) {
        this.vel_min = vel_min;
    }

    public void setLatitud(long latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "MParadas{" + "geo_id=" + geo_id + ", veh_id=" + veh_id + ", vel_min=" + vel_min + ", latitud=" + latitud + ", longitud=" + longitud + ", min=" + min + ", max=" + max + ", tiempo=" + tiempo + '}';
    }
    
    
    
}
