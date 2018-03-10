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

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Transactional
public interface HotelRepository extends CrudRepository<MHotel, Long> {


        //public HrmUsuario findByUsuUser(@Param("usuUsuario") String usuaUser);

    @Query("select s from MHotel s")
    List<MHotel> getallHoteles();

/*    
    @Query()  
    public List<MGui> allGui();
    
    
    @Query(nativeQuery = true)
    public List<MParadas> getPausasEnGeocercas();*/
    
   // public MRo             
}
