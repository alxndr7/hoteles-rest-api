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

package kassa.Dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import kassa.Entidad.MGui;
import kassa.Entidad.MGuiPK;
import kassa.Entidad.MUsuario;
import kassa.Entidad.MParadas;
import kassa.Entidad.MUsuarioPK;
import kassa.Entidad.TPersonal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface PersonalRepository extends CrudRepository<TPersonal, BigDecimal> {


    @Query()
    public TPersonal findByPersId(@Param("persId") BigDecimal id);
    
  // public MRo             
}

