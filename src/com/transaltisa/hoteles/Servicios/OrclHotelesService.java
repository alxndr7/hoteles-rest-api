package com.transaltisa.hoteles.Servicios;

import com.transaltisa.hoteles.Dao.MHotelDao;
import com.transaltisa.hoteles.Entidad.MHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OrclHotelesService implements HotelesService {

    @Autowired
    private MHotelDao mHotelDao;

    @Transactional(readOnly = true)
    public Collection<MHotel> getAll() {
        return mHotelDao.getAll();
    }

}
