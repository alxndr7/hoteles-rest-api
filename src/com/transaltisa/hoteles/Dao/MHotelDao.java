package com.transaltisa.hoteles.Dao;

import com.transaltisa.hoteles.Entidad.MHotel;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */

public interface MHotelDao {
    Collection<MHotel> getAll();
}
