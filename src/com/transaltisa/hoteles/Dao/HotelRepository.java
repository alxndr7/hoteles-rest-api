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

import com.transaltisa.hoteles.Entidad.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface HotelRepository extends CrudRepository<MHotelMap, Long> {


    //public HrmUsuario findByUsuUser(@Param("usuUsuario") String usuaUser);

/*    @Procedure(name = "VwPersonalHotel.desocupar_habitacion")
    void plus1Backed(@Param("arg") Integer arg);*/

    @Query("select s from MHotel s where estado = 1 order by hotelId asc")
    List<MHotel> getallHoteles();

    @Query("select s from MReporteFallas s")
    List<MReporteFallas> getallReportes();

    @Modifying
    @Query(value = "insert into trn_sistemas.m_reporte_fallas (titulo,reporte_fecha, ruta, empresa, flota, convoy, placa_tracto, placa_carreta, kilometraje, ubicacion, desc_falla, usuario_id, imagen_1, imagen_2, imagen_3, estado_reporte)" +
            " VALUES (:titulo, to_date(:reporteFecha,'YYYY-MM-DD HH24:MI:SS') ,:ruta , :empresa, :flota, :convoy, :placaTracto, :placaCarreta, :kilometraje, :ubicacion, :descFalla, :idUsuario, :ibytes, :ibytes2,:ibytes3, 'Pendiente')", nativeQuery = true)
    Integer insertReporte(@Param("titulo") String titulo, @Param("empresa") String empresa,
                          @Param("ruta") String ruta,
                          @Param("reporteFecha") String reporteFecha, @Param("flota") String flota,
                          @Param("convoy") String convoy, @Param("placaTracto") String placaTracto,
                          @Param("placaCarreta") String placaCarreta, @Param("kilometraje") String kilometraje,
                          @Param("ubicacion") String ubicacion, @Param("descFalla") String descFalla,
                          @Param("idUsuario") Long idUsuario,
                          @Param("ibytes") byte[] ibytes,
                          @Param("ibytes2") byte[] ibytes2,
                          @Param("ibytes3") byte[] ibytes3);

    @Modifying
    @Query(value = "update trn_sistemas.m_reporte_fallas set estado_reporte = :estado_reporte, desc_falla = :descFalla where id_reporte_falla = :idReporteFalla", nativeQuery = true)
    Integer update_estado_reporte_falla(@Param("idReporteFalla") Long idReporteFalla, @Param("estado_reporte") String estado, @Param("descFalla") String descFalla);


    @Query("select s from MReporteFallas s where s.estadoReporte = 'Pendiente'")
    List<MReporteFallas> getAllReportesPendientes();

    @Query("select s.idReporteFalla from MReporteFallas s where s.estadoReporte = 'Pendiente'")
    List<MReporteFallas> getAllReportesPendientesCount();

    @Query("select s from MHotel s where upper(flota) = upper(:flota) AND estado = 1")
    List<MHotel> getHotelesPorFlota(@Param("flota") String flota);

    @Query("select s from MHotelMap s")
    List<MHotelMap> getallHotelesDet();

    @Query("select s from MHotelMap s where hotelId = :id")
    List<MHotelMap> getHotelDetPorId(@Param("id") Long id);

    @Query("select s from MHotelMap s where hotelId = :id")
    List<MHotelMap> getHotelDetPorIdDisp(@Param("id") Long id);

    @Query("select s from MHotel s where hotelId = :id")
    List<MHotel> getHotelPorId(@Param("id") Long id);

    //@Query("select s from MHotelMap s order by hotelId asc")
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
    Integer createHotel(MHotelMap hotel);

    @Modifying
    @Query(value = "insert into logistica.t_pisos_hotel (hotel_id, piso, num_hab_piso) VALUES (:hotelId,:piso,:numHabPiso)", nativeQuery = true)
    Integer insertPisosHotel(@Param("hotelId") Long hotelId, @Param("piso") Long piso, @Param("numHabPiso") Long numHabPiso);

    @Modifying
    @Query(value = "insert into logistica.t_personal_relevo_diario (dni, nombre_completo, puesto, flota, fecha_ingreso, fecha_salida, orden)" +
            " VALUES (:dni,:nombreCompleto,:puesto, :flota, :fechaIngreso, :fechaSalida, :orden)", nativeQuery = true)
    Integer insertPersonalRelevo(@Param("dni") String dni, @Param("nombreCompleto") String nombreCompleto,
                                 @Param("puesto") String puesto, @Param("flota") String flota,
                                 @Param("fechaIngreso") String fechaIngreso,@Param("fechaSalida") String fechaSalida,
                                 @Param("orden") Long orden);

    @Modifying
    @Query(value = "insert into logistica.t_personal_relevo_diario (dni, nombre_completo, puesto, flota, fecha_ingreso, fecha_salida, orden)" +
            " VALUES (:dni,:nombreCompleto,:puesto, :flota, to_date(:fechaIngreso,'YYYY-MM-DD HH24:MI:SS') , to_date(:fechaSalida,'YYYY-MM-DD HH24:MI:SS'), :orden)", nativeQuery = true)
    Integer insertNuevoPersonalRelevo(@Param("dni") String dni, @Param("nombreCompleto") String nombreCompleto,
                                      @Param("puesto") String puesto, @Param("flota") String flota,
                                      @Param("fechaIngreso") String fechaIngreso,@Param("fechaSalida") String fechaSalida,
                                      @Param("orden") Long orden);


    @Modifying
    @Query(value = "update logistica.t_habitacion_hotel set personal_relevo_id = :idPersonal,fecha_ini_ocupa= to_date(:fechaIni,'YYYY-MM-DD HH24:MI:SS'),fecha_fin_ocupa = to_date(:fechaFin,'YYYY-MM-DD HH24:MI:SS'), estado_ocupa = 'O' where hab_hot_id = :id", nativeQuery = true)
    Integer updateHabHotel(@Param("id") Long id, @Param("idPersonal") Long idPersonal, @Param("fechaIni") String fechaIni, @Param("fechaFin") String fechaFin);

    @Modifying
    @Query(value = "update logistica.t_personal_relevo_diario set hab_hot_id = :habHotId where personal_relevo_id = :personalRelevoId", nativeQuery = true)
    Integer updatePersonalHabitacion(@Param("personalRelevoId") Long personalRelevoId, @Param("habHotId") Long habHotId);


    @Query("select s from TPisosHotel s")
    List<TPisosHotel> getAllPisos();

    @Query("select p from TPersonalRelevo p order by orden asc")
    List<TPersonalRelevo> getAllPersonalRelevo();

    @Query("select p from THabitacionHotel p where habHotId = :id")
    THabitacionHotel get_det_hab(@Param("id") Long id);

    @Query("select p from VwPersonalHotel p")
    List<VwPersonalHotel> get_personal_hotel();

    @Query(value =  "{call logistica.DESO_HAB_ANTICIPADA(:personalRelevoId,:habHotId,:observacion)}" , nativeQuery = true)
    Integer desocupar_habitacion(@Param("personalRelevoId") Long personalRelevoId, @Param("habHotId") Long habHotId, @Param("observacion") String observacion);

    @Procedure
    void sp_desocupar_habitacion(@Param("habHotId") Long habHotId,@Param("personalRelevoId") Long personalRelevoId, @Param("observacion") String observacion);

    @Query("select p from TPersonalRelevo p where habDet.hotelId =  :hotelId")
    List<TPersonalRelevo> reporte_diario_por_hotel(@Param("hotelId") Long hotelId);

    @Query("select p from TRegistroDiario p where hotelId = :hotelId")
    List<TRegistroDiario> get_registro_diario(@Param("hotelId") Long hotelId);

    @Query("select p from TRegistroDiario p")
    List<TRegistroDiario> get_registro_diario_all();

    @Modifying
    @Query(value = "update logistica.t_registro_diario set reg1 = 1, fecha_reg1 = sysdate where id_reg_diar = :idRegDiar", nativeQuery = true)
    Integer update_reg1(@Param("idRegDiar") Long idRegDiar);

    @Modifying
    @Query(value = "update logistica.t_registro_diario set reg2 = 1, fecha_reg2 = sysdate where id_reg_diar = :idRegDiar", nativeQuery = true)
    Integer update_reg2(@Param("idRegDiar") Long idRegDiar);

    @Modifying
    @Query(value = "update logistica.t_registro_diario set reg3 = 1, fecha_reg3 = sysdate where id_reg_diar = :idRegDiar", nativeQuery = true)
    Integer update_reg3(@Param("idRegDiar") Long idRegDiar);

    @Query("select u from MUsuarioTerceros u where usuUsuario = :usuUsuario and passwUsuario = :passwUsuario")
    MUsuarioTerceros validar_usuario(@Param("usuUsuario") String usuUsuario, @Param("passwUsuario") String passwUsuario);

    /*
    @Query()
    public List<MGui> allGui();


    @Query(nativeQuery = true)
    public List<MParadas> getPausasEnGeocercas();*/

    // public MRo
}
