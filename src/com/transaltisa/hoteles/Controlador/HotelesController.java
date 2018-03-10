package com.transaltisa.hoteles.Controlador;

import com.transaltisa.hoteles.Dao.HotelRepository;
import com.transaltisa.hoteles.Entidad.MHotel;
import com.transaltisa.hoteles.Entidad.MUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
