package com.transaltisa.hoteles.Controlador;

import com.transaltisa.hoteles.Dao.HotelRepository;
import com.transaltisa.hoteles.Entidad.*;
import com.transaltisa.hoteles.Modelo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

@RestController
public class HotelesController {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelesController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @RequestMapping("/hoteles")
    public List<MHotel> get_all_hoteles() {
        return hotelRepository.getallHoteles();
    }

    @RequestMapping("/reportes-upload")
    public Response insert_reporte_falla(@RequestParam("titulo") String titulo, @RequestParam("empresa") String empresa,
                                         @RequestParam("reporteFecha") String reporteFecha,
                                         @RequestParam("convoy") String convoy, @RequestParam("placaTracto") String placaTracto,
                                         @RequestParam("placaCarreta") String placaCarreta, @RequestParam("kilometraje") String kilometraje,
                                         @RequestParam("ubicacion") String ubicacion, @RequestParam("descFalla") String descFalla,
                                         @RequestParam("idUsuario") Long idUsuario) {
        //return ResponseEntity.ok(user);
        int response = hotelRepository.insertReporte(titulo, empresa, reporteFecha, convoy, placaTracto, placaCarreta, kilometraje, ubicacion, descFalla, idUsuario);
        Response resp = new Response();

        if(response == 1)
            resp.setMensaje("SUCCESS");
        else
            resp.setMensaje("FAILED");

        return resp;
    }

    @RequestMapping("/hoteles-det")
    public List<MHotelMap> all_hoteles_det() {
        return hotelRepository.getallHotelesDet();
    }

    @RequestMapping(value = "hotelesPorId", method = RequestMethod.GET)
    public List<MHotel> hoteles_por_id(@RequestParam("id") Long id) {
        return hotelRepository.getHotelPorId(id);
    }

    @RequestMapping(value = "hotelDetallePorId", method = RequestMethod.GET)
    public List<MHotelMap> hoteles_detalle_por_id(@RequestParam("id") Long id) {
        return hotelRepository.getHotelDetPorId(id);
    }

    @RequestMapping(value = "hotelDetallePorIdDisp", method = RequestMethod.GET)
    public List<MHotelMap> hoteles_detalle_por_id_disp(@RequestParam("id") Long id) {
        return hotelRepository.getHotelDetPorIdDisp(id);
    }

    @RequestMapping(value = "insertHotel", method = RequestMethod.POST)
    public Integer insertar_hotel(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("numHab") Long numHab, @RequestParam("flota") String flota, @RequestParam("estado") Long estado,@RequestParam("pisos") Long pisos) {
       return hotelRepository.insertHotel(id,nombre,numHab,flota,estado,pisos);
    }

    @RequestMapping(value = "updateHotel", method = RequestMethod.POST)
    public Integer update_hotel(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("numHab") Long numHab, @RequestParam("flota") String flota,@RequestParam("pisos") Long pisos){
        return hotelRepository.updateHotel(id,nombre,numHab,flota,pisos);
    }

    @RequestMapping(value = "updateHabHot", method = RequestMethod.POST)
    public Integer update_hab_hotel(@RequestParam("id") Long id, @RequestParam("idPersonal") Long idPersonal, @RequestParam("fechaIni") String fechaIni
                                ,@RequestParam("fechaFin") String fechaFin){
        return hotelRepository.updateHabHotel(id,idPersonal,fechaIni,fechaFin);
    }

    @RequestMapping(value = "updatePersonalHabitacion", method = RequestMethod.POST)
    public Integer update_personal_habitacion(@RequestParam("personalRelevoId") Long personalRelevoId, @RequestParam("habHotId") Long habHotId){
        return hotelRepository.updatePersonalHabitacion(personalRelevoId,habHotId);
    }

    @RequestMapping(value = "deleteHotel", method = RequestMethod.POST)
    public Integer delete_hotel(@RequestParam("id") Long id){
        return hotelRepository.deleteHotel(id);
    }

    @RequestMapping(value = "create-hotel", method = RequestMethod.POST)
    public Integer create_hotel(@RequestBody MHotelMap mHotelMap) {
        return hotelRepository.createHotel(mHotelMap);
    }

    @RequestMapping(value = "insertPisoHotel", method = RequestMethod.POST)
    public Integer insert_pisos_hotel(@RequestParam("hotelId") Long hotelId, @RequestParam("piso") Long piso, @RequestParam("numHabPiso") Long numHabPiso) {
        return hotelRepository.insertPisosHotel(hotelId, piso,numHabPiso);
    }

    @RequestMapping(value = "insertPersonalRelevo", method = RequestMethod.POST)
    public Integer insert_personal_relevo(@RequestParam("dni") String dni, @RequestParam("nombreCompleto") String nombreCompleto,
                                      @RequestParam("puesto") String puesto, @RequestParam("flota") String flota,
                                      @RequestParam("fechaIngreso") String fechaIngreso,@RequestParam("fechaSalida") String fechaSalida) {
        return hotelRepository.insertPersonalRelevo(dni, nombreCompleto, puesto, flota, fechaIngreso, fechaSalida);
    }

    @RequestMapping("/pisos")
    public List<TPisosHotel> all_pisos() {
        return hotelRepository.getAllPisos();
    }

    @RequestMapping("/personal-relevo")
    public List<TPersonalRelevo> personal_relevo_diario() {
        return hotelRepository.getAllPersonalRelevo();
    }

    @RequestMapping("/hoteles-flota")
    public List<MHotel> get_hoteles_x_flota(@RequestParam("flota") String flota) {
        return hotelRepository.getHotelesPorFlota(flota);
    }

    @RequestMapping("/get_det_hab")
    public THabitacionHotel get_det_hab(@RequestParam("id") Long id){
        return hotelRepository.get_det_hab(id);
    }


/*
    @RequestMapping("/hoteles")
    public List<MHotel> get_all_hoteles_prueba() {
        return hotelRepository.getAllHotelesPrueba();
    }*/

/*public void insertar_hotel(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("numHab") Long numHab, @RequestParam("flota") String flota) {*/
}