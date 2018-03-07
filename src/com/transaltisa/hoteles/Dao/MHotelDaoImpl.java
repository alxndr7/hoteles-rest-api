package com.transaltisa.hoteles.Dao;

import com.transaltisa.hoteles.Entidad.MHotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by CESAR-TRN on 7/03/2018.
 */
@Repository
public class MHotelDaoImpl implements MHotelDao {

    
    public Collection<MHotel> getAll() {
      return null;
    }
}
