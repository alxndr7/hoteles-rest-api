package com.transaltisa.hoteles.Controlador;

import com.transaltisa.hoteles.Dao.HotelRepository;
import com.transaltisa.hoteles.Entidad.*;
import com.transaltisa.hoteles.Modelo.Cantidad;
import com.transaltisa.hoteles.Modelo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
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

    @RequestMapping(value="/reportes-upload",method=RequestMethod.POST,  headers = "content-type=multipart/*")
    public Response insert_reporte_falla(@RequestParam("titulo") String titulo, @RequestParam("empresa") String empresa,
                                         @RequestParam("ruta") String ruta,
                                         @RequestParam("reporteFecha") String reporteFecha, @RequestParam("flota") String flota,
                                         @RequestParam("convoy") String convoy, @RequestParam("placaTracto") String placaTracto,
                                         @RequestParam("placaCarreta") String placaCarreta, @RequestParam("kilometraje") String kilometraje,
                                         @RequestParam("ubicacion") String ubicacion, @RequestParam("descFalla") String descFalla,
                                         @RequestParam("idUsuario") Long idUsuario,
                                         @RequestParam("imageBody") MultipartFile imageBody,
                                         @RequestParam("imageBody2") MultipartFile imageBody2,
                                         @RequestParam("imageBody3") MultipartFile imageBody3) {
        //return ResponseEntity.ok(user);

        Response resp = new Response();
        System.out.println("read hola" );

      /*int response = hotelRepository.insertReporte(titulo, empresa, ruta, reporteFecha, flota , convoy, placaTracto, placaCarreta, kilometraje, ubicacion, descFalla, idUsuario ,"´prueba");

        if(response == 1)
            resp.setMensaje("SUCCESS");
        else
            resp.setMensaje("FAILED");*/
        try {
            // Get the file and save it somewhere
            byte[] ibytes = imageBody.getBytes();
            byte[] ibytes2 = imageBody2.getBytes();
            byte[] ibytes3 = imageBody3.getBytes();
            int response = hotelRepository.insertReporte(titulo, empresa, ruta, reporteFecha, flota , convoy, placaTracto, placaCarreta, kilometraje, ubicacion, descFalla, idUsuario ,ibytes, ibytes2, ibytes3);

            if(response == 1)
                resp.setMensaje("SUCCESS");
            else
                resp.setMensaje("FAILED");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resp;
    }

    @RequestMapping(value="/get-reportes-pendientes",method=RequestMethod.POST)
    public List<MReporteFallas> get_reportes_pendientes(@RequestParam("titulo") String titulo)  {
        return hotelRepository.getAllReportesPendientes();
    }

    @RequestMapping(value="/get-cant-reportes-pendientes",method=RequestMethod.GET)
    public Cantidad get_reportes_pendientes()  {
        List<MReporteFallas> list = hotelRepository.getAllReportesPendientesCount();
        Cantidad c = new Cantidad(list.size());
        return c;
    }


    @RequestMapping(value = "update-estado-reporte", method = RequestMethod.POST)
    public Integer update_hotel(@RequestParam("idReporteFalla") Long idReporteFalla,
                                @RequestParam("estado_reporte") String estado_reporte,
                                @RequestParam("descFalla") String descFalla){
        return hotelRepository.update_estado_reporte_falla(idReporteFalla,estado_reporte, descFalla);
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
                                          @RequestParam("fechaIngreso") String fechaIngreso,@RequestParam("fechaSalida") String fechaSalida,@RequestParam("orden") Long orden) {
        return hotelRepository.insertPersonalRelevo(dni, nombreCompleto, puesto, flota, fechaIngreso, fechaSalida, orden);
    }

    @RequestMapping(value = "insertNuevoPersonalRelevo", method = RequestMethod.POST)
    public Integer insert_nuevo_personal_relevo(@RequestParam("dni") String dni, @RequestParam("nombreCompleto") String nombreCompleto,
                                                @RequestParam("puesto") String puesto, @RequestParam("flota") String flota,
                                                @RequestParam("fechaIngreso") String fechaIngreso,@RequestParam("fechaSalida") String fechaSalida,
                                                @RequestParam("orden") Long orden) {
        return hotelRepository.insertNuevoPersonalRelevo(dni, nombreCompleto, puesto, flota, fechaIngreso, fechaSalida, orden);
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


    //OBTENER PERSONAL QUE OCUPA HABITACIONES
    @RequestMapping("/personal-hotel")
    public List<VwPersonalHotel> get_personal_hotel(){
        return hotelRepository.get_personal_hotel();
    }

    //DESOCUPA HABITACION
    @RequestMapping("/desocupar-habitacion")
    public Response sp_desocupar_habitacion( @RequestParam("habHotId") Long habHotId,
                                             @RequestParam("personalRelevoId") Long personalRelevoId,
                                             @RequestParam("observacion") String observacion){
        hotelRepository.sp_desocupar_habitacion(habHotId, personalRelevoId, observacion);
        Response resp = new Response();
        resp.setMensaje("LLego");
        return resp;
    }

    @RequestMapping("/personal-relevo-hotel")
    public List<TPersonalRelevo> reporte_diario_por_hotel(@RequestParam("hotelId") Long hotelId){
        return hotelRepository.reporte_diario_por_hotel(hotelId);
    }

    @RequestMapping("/get-registro-diario-hotel")
    public List<TRegistroDiario> get_registro_diario(@RequestParam("hotelId") Long hotelId){
        return hotelRepository.get_registro_diario(hotelId);
    }

    @RequestMapping("/get-registro-diario-all")
    public List<TRegistroDiario> get_registro_diario(){
        return hotelRepository.get_registro_diario_all();
    }

    @RequestMapping(value = "/update-reg1",method = RequestMethod.POST)
    public Integer update_reg1(@RequestParam("idRegDiar") Long idRegDiar){
        return hotelRepository.update_reg1(idRegDiar);
    }

    @RequestMapping(value = "/update-reg2",method = RequestMethod.POST)
    public Integer update_reg2(@RequestParam("idRegDiar") Long idRegDiar){
        return hotelRepository.update_reg2(idRegDiar);
    }

    @RequestMapping(value = "/update-reg3",method = RequestMethod.POST)
    public Integer update_reg3(@RequestParam("idRegDiar") Long idRegDiar){
        return hotelRepository.update_reg3(idRegDiar);
    }

    @RequestMapping(value = "/validar-usuario",method = RequestMethod.POST)
    public MUsuarioTerceros update_reg3(@RequestParam("usuUsuario") String usuUsuario, @RequestParam("passwUsuario") String passwUsuario){
        return hotelRepository.validar_usuario(usuUsuario, passwUsuario);
    }


/*
    @RequestMapping("/hoteles")
    public List<MHotel> get_all_hoteles_prueba() {
        return hotelRepository.getAllHotelesPrueba();
    }*/

/*public void insertar_hotel(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("numHab") Long numHab, @RequestParam("flota") String flota) {*/
}