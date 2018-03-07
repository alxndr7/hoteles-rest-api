package com.transaltisa.hoteles.Servicios;

import com.transaltisa.hoteles.Dao.MHotelDao;
import com.transaltisa.hoteles.Entidad.MHotel;


import java.util.Collection;

// Business Object UsersBO
public interface HotelesService {
    Collection<MHotel> getAll();
}