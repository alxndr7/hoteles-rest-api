package com.transaltisa.hoteles.Controlador;

import com.transaltisa.hoteles.Dao.HotelRepository;
import com.transaltisa.hoteles.Entidad.MHotel;
import com.transaltisa.hoteles.Entidad.MUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public List<MHotel> all_hoteles() {
        return hotelRepository.getallHoteles();
    }

    @RequestMapping(value = "hotelesPorId", method = RequestMethod.GET)
    public List<MHotel> hoteles_por_id(@RequestParam("id") Long id) {
        return hotelRepository.getHotelPorId(id);
    }

    @RequestMapping(value = "insertHotel", method = RequestMethod.POST)
    public Integer insertar_hotel(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("numHab") Long numHab, @RequestParam("flota") String flota, @RequestParam("estado") Long estado,@RequestParam("pisos") Long pisos) {
       return hotelRepository.insertHotel(id,nombre,numHab,flota,estado,pisos);
    }

    @RequestMapping(value = "updateHotel", method = RequestMethod.POST)
    public Integer update_hotel(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("numHab") Long numHab, @RequestParam("flota") String flota,@RequestParam("pisos") Long pisos){
        return hotelRepository.updateHotel(id,nombre,numHab,flota,pisos);
    }

    @RequestMapping(value = "deleteHotel", method = RequestMethod.POST)
    public Integer delete_hotel(@RequestParam("id") Long id){
        return hotelRepository.deleteHotel(id);
    }

    @RequestMapping(value = "create-hotel", method = RequestMethod.POST)
    public Integer create_hotel(@RequestBody MHotel mHotel) {
        return hotelRepository.createHotel(mHotel);
    }


/*public void insertar_hotel(@RequestParam("id") Long id, @RequestParam("nombre") String nombre, @RequestParam("numHab") Long numHab, @RequestParam("flota") String flota) {*/
}