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

package com.transaltisa.hoteles.Controlador;


import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.transaltisa.hoteles.Dao.UsuarioRepository;
//import com.transaltisa.hoteles.Dao.VwPersonalRepository;
import com.transaltisa.hoteles.Entidad.MUsuario;
import com.transaltisa.hoteles.Modelo.Greeting;
import org.json.JSONException;

//import com.transaltisa.hoteles.Entidad.VwPersonal;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    private final UsuarioRepository userRepository;


    @Autowired
    public GreetingController(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/greeting")
    public Greeting greeting(@AuthenticationPrincipal MUsuario user) {
        return new Greeting(counter.incrementAndGet(),user.getMUsuarioPK().getUsuarioId().longValue() ,String.format(template, user.getUsuUsuario()), user.getUsuPassword());
    }

    @RequestMapping("/allusers")
    public List<MUsuario> all_users(@AuthenticationPrincipal MUsuario user) {
        return userRepository.allUsers();
    }


    @RequestMapping(value="/up_password", method=RequestMethod.POST)
    public void  updatePassword(@RequestParam("id_usuario") BigInteger id_usuario, @RequestParam("password") String password) throws JSONException {
        userRepository.updatePassword(id_usuario,password);
    }

}
