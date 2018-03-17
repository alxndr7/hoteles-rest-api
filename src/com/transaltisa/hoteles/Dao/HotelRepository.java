/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.transaltisa.hoteles.Dao;

import com.transaltisa.hoteles.Entidad.MHotel;
import com.transaltisa.hoteles.Entidad.MUsuario;
import com.transaltisa.hoteles.Entidad.MUsuarioPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Transactional
public interface HotelRepository extends CrudRepository<MHotel, Long> {


        //public HrmUsuario findByUsuUser(@Param("usuUsuario") String usuaUser);

    @Query("select s from MHotel s where estado = 1 order by hotelId asc")
    List<MHotel> getallHoteles();


    @Query("select s from MHotel s where hotelId = :id")
    List<MHotel> getHotelPorId(@Param("id") Long id);

    //@Query("select s from MHotel s order by hotelId asc")
    @Modifying
    @Query(value = "insert into logistica.m_hotel (hotel_id, hotel_nombre,hotel_num_hab,flota,estado,pisos) VALUES (:id,:nombre,:numHab,:flota,:estado,:pisos)", nativeQuery = true)
    Integer insertHotel(@Param("id") Long id, @Param("nombre") String nombre, @Param("numHab") Long numHab, @Param("flota") String flota, @Param("estado") Long estado,@Param("pisos") Long pisos);

    @Modifying
    @Query(value = "update logistica.m_hotel set hotel_nombre = :nombre,hotel_num_hab = :numHab,flota = :flota,pisos = :pisos where hotel_id = :id", nativeQuery = true)
    Integer updateHotel(@Param("id") Long id, @Param("nombre") String nombre, @Param("numHab") Long numHab, @Param("flota") String flota,@Param("pisos") Long pisos);

    @Modifying
    @Query(value = "update logistica.m_hotel set estado = 0 where hotel_id = :id", nativeQuery = true)
    Integer deleteHotel(@Param("id") Long id);

    @Modifying
    @Query(value = "insert into logistica.m_hotel (hotel_id, hotel_nombre,hotel_num_hab,flota,estado) VALUES (:hotel.,:nombre,:numHab,:flota,:estado)", nativeQuery = true)
    Integer createHotel(MHotel hotel);


/*
    @Query()  
    public List<MGui> allGui();
    
    
    @Query(nativeQuery = true)
    public List<MParadas> getPausasEnGeocercas();*/
    
   // public MRo             
}
