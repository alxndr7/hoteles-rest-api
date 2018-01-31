/*
 * Copyright 2014 the original author or authors.
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

package kassa.Servicio;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kassa.Dao.GuiRepository;
import kassa.Dao.PersonalRepository;
import kassa.Dao.UsuarioRepository;
import kassa.Dao.VwCumpleRepository;
import kassa.Dao.VwPersonalRepo;
import kassa.Dao.VwVacacionesRepository;
//import kassa.Dao.VwPersonalRepository;
import kassa.Entidad.MGui;
import kassa.Entidad.MParadas;
import kassa.Entidad.MUsuario;
import kassa.Entidad.TPersonal;
import kassa.Entidad.VwCumple;
import kassa.Entidad.VwPersonal;
import kassa.Entidad.VwVacaciones;
import org.json.JSONException;

//import kassa.Entidad.VwPersonal;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();
        
        
        private final UsuarioRepository userRepository;
        private final GuiRepository guiRepository;
        private final PersonalRepository personalRepository;
        private final VwPersonalRepo vw_PersonalR;
        private final VwCumpleRepository vw_Cumples;
        private final VwVacacionesRepository vw_vacaciones;

	@Autowired
	public GreetingController(UsuarioRepository userRepository,GuiRepository guiRepository, PersonalRepository personalRepository, VwPersonalRepo vw_PersonalR, VwCumpleRepository vw_cumples, VwVacacionesRepository vw_vacaciones) {
		this.userRepository = userRepository;
                this.guiRepository = guiRepository;
                this.personalRepository = personalRepository;
                this.vw_PersonalR = vw_PersonalR;
                this.vw_Cumples = vw_cumples;
                this.vw_vacaciones = vw_vacaciones;
	}
        
        
	@RequestMapping("/greeting")
	public Greeting greeting(@AuthenticationPrincipal MUsuario user) {
		return new Greeting(counter.incrementAndGet(),user.getMUsuarioPK().getUsuarioId().longValue() ,String.format(template, user.getUsuUsuario()), user.getUsuPassword());
	}
        
        @RequestMapping("/allusers")
	public List<MUsuario> all_users(@AuthenticationPrincipal MUsuario user) {
		return userRepository.allUsers();
	}
        
        @RequestMapping("/info_personal")
	public Personal  infoPersonal(@AuthenticationPrincipal MUsuario user) throws JSONException {
                TPersonal var = personalRepository.findByPersId(new BigDecimal(user.getMUsuarioPK().getPersId()));
                System.out.println("-------- VARIABLE ---------");
                  System.out.println(var.toString());
                System.out.println("-------- VARIABLE ---------");
                
            
		return new Personal(var.getPersId().longValue(),var.getNombre1(),var.getNombre2(), var.getApePat(), var.getApeMat(),var.getNacFecha().toGMTString(), var.getDireccion(), var.getTelefFijo(),var.getTelefCelular(),var.getSexoId().longValue(),var.getReferenciaDir());
	}
        
         @RequestMapping("/info_personal2")
	public VwPersonal  infoPersonal2(@AuthenticationPrincipal MUsuario user) throws JSONException {
                return vw_PersonalR.findByPersId(user.getMUsuarioPK().getPersId());
	}
        
        @RequestMapping(value="/up_password", method=RequestMethod.POST)
	public void  updatePassword(@RequestParam("id_usuario") BigInteger id_usuario, @RequestParam("password") String password) throws JSONException {
                userRepository.updatePassword(id_usuario,password);
	}
        
        @RequestMapping(value="/get_cumples")
	public List<VwCumple>  findAllCumples(){
                return vw_Cumples.allCumples();
	}
        
         @RequestMapping(value="/vacaciones")
	public List<VwVacaciones> vacaciones(@AuthenticationPrincipal MUsuario user) {
		return vw_vacaciones.findByPersId(user.getMUsuarioPK().getPersId());
	}
        
        
    /*
          @RequestMapping("/info_personal2")
	public VwPersonal infoPersonal2(@AuthenticationPrincipal MUsuario user) {
		return vw_PersonalR.findByPersId(new BigDecimal(user.getMUsuarioPK().getPersId()));
	}*/
    
        /*
        
        @RequestMapping("/gui")
	public List<MGui> findByGuiId() {
		return guiRepository.findAll();
	}*/
        
         @RequestMapping("/guiNombre")
	public List<MGui> gui_x_nombre() {
            
		return guiRepository.findByGuiNombre("Personal");
	}
        
        @RequestMapping("/guiid")
	public MGui gui_x_id() {
                MGui val = guiRepository.findByGuiId(BigInteger.valueOf(2000));
		return val;
	}
        
        
  
        @RequestMapping(value = "/allGui", method = RequestMethod.GET, produces = "application/json")
        @ResponseBody
        public List<MGui> all_Gui(){
            return guiRepository.allGui();
        }
        
      
    /*
        @RequestMapping("/allGui")
	public List<MGui> allGui() {
                List<MGui> lista=guiRepository.allGui();
		return lista;
        }*/
        /*
        @RequestMapping("/allParadas")
	public List<MParadas> all_paradas(@AuthenticationPrincipal MUsuario user) {
		return userRepository.getPausasEnGeocercas();
	}
        */
        @RequestMapping("/getusuario")
	public MUsuario get_usuario(@AuthenticationPrincipal MUsuario user) {
		return userRepository.findByUsuUsuarioN("cpalol");
	}
        

//        @RequestMapping("/greeting2")
//	public HrmUsuario greeting2() {
//                
//            System.out.println();
//            //HrmUsuario user=userRepository.findByUsuUser("etrans");
//            HrmUsuario user=userRepository.findByUsuUser();
//            System.out.println("yeah"+ user.getUsuPwd());
//		return user;
//	}
}
