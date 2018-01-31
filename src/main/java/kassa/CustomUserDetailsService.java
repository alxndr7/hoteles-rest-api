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

package kassa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kassa.Dao.UsuarioRepository;
import kassa.Entidad.MRol;
import kassa.Entidad.MUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//La interfaz userdetailsservice se usa para obtener el usuario, password, y las autorizaciones de un usuario cuando usamos spring security.

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UsuarioRepository userRepository;

	@Autowired
	public CustomUserDetailsService(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
        // Funcion de la interfaz necesaria para recolectar los datos del usuario y ser usados despues en un objeto de autenticacion
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                
                MUsuario user=null;
         
                user= userRepository.findByUsuUsuarioN(username);
            
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		return new UserRepositoryUserDetails(user);
	}

        
        //Implementamos la interfaz Userdetails para ordenar los datos del usuario obtenidos desde la base de datos
	private final static class UserRepositoryUserDetails extends MUsuario implements UserDetails {

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(MUsuario user) {
			super(user);
		}
   

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
                        List<MRol> listarol= new ArrayList<MRol>();
                        listarol.add(MRol.ROL_ADMIN);
                        return  listarol;
		}

		@Override
		public String getUsername() {
			return getUsuUsuario();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

                @Override
                public String getPassword() {
                    return getUsuPassword();
                }

	}

}
