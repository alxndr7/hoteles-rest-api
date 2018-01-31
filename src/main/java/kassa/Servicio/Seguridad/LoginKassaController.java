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

package kassa.Servicio.Seguridad;


import javax.servlet.http.HttpServletRequest;
import kassa.Dao.UsuarioRepository;
import kassa.Entidad.MUsuario;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginKassaController {

	 private final UsuarioRepository userRepository;

	@Autowired
	public LoginKassaController(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}
        

	@RequestMapping(value="/loginkassa",method = RequestMethod.GET)
	public MUsuario loginkassa(@RequestParam String usuario, @RequestParam String password) {
                
                //System.out.println();
               if(usuario!=null)
               {
                   MUsuario u=userRepository.findByUsuUsuarioN(password);
                   if(u!=null && u.getUsuUsuario()!=null && u.getUsuPassword()!=null){
                       if(u.getUsuPassword().contains(password))
                           return u;
                       else
                           return null;
                   }
               }
               
               return null;
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
