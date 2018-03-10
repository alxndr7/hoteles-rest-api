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

package com.transaltisa.hoteles.Configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class OAuth2ServerConfiguration {

	private static final String RESOURCE_ID = "restservice";


	//Un Authorization server es un servidor que se encarga de gestionar los access tokens, se los entrega al cliente, despues de autenticar el dueño de los recursos,y de obtener autorizaciones,
	@Configuration
	@EnableAuthorizationServer
	//la anotacion enableauthorization service nos da funciones para implementar de la interfaz AuthorizationServerConfigurer
	protected static class AuthorizationServerConfiguration extends	AuthorizationServerConfigurerAdapter {

		private TokenStore tokenStore = new InMemoryTokenStore();

		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;

		@Autowired
		private CustomUserDetailsService userDetailsService;


		//por default el servidor de autorizaciones NO le da ninguna seguridad al end point del mismo servidor de autorizaciones.
		//en este caso estamos inyectando el Spring security authentication manager, entonces para obtener un Token vamos a necesitar loguearnos primero con usuario y contraseña como esta definido en nuestro CustomUserDetailsService
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints)
				throws Exception {
			// @formatter:off
			endpoints
					.tokenStore(this.tokenStore)
					.authenticationManager(this.authenticationManager)
					.userDetailsService(userDetailsService);
			// @formatter:on
		}


		//aqui le damos acceso a nuestra aplicacion cliente(clienteapp) que usara los recursos protegidos
		//aqui solamente le estamos dando acceso a los recursos password y refresh_token a la aplicacion clientapp.
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// @formatter:off
			clients
					.inMemory()
					.withClient("clientapp")
					.authorizedGrantTypes("password", "refresh_token")
					.authorities("USER")
					.scopes("read", "write")
					.resourceIds(RESOURCE_ID)
					.secret("transal333");
			// @formatter:on
		}

		// el curl necesario para obtener un token es el siguiente:
		//curl -X POST -vu clientapp:transal333 http://localhost:8080/Kassa/oauth/token -H "Accept: application/json" -d "password=trn2017.&username=etrans&grant_type=password"


		@Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			DefaultTokenServices tokenServices = new DefaultTokenServices();
			tokenServices.setSupportRefreshToken(true);
			tokenServices.setTokenStore(this.tokenStore);
			return tokenServices;
		}

	}



	@Configuration
	@EnableResourceServer
	//Un resource server es el servidor que contiene todos los recursos protegidos, debe ser capaz de responder todos las llamadas a los recursos protegidos usando el Access Token
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) {
			// @formatter:off
			resources
					.resourceId(RESOURCE_ID);
			// @formatter:on
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http
					.authorizeRequests()
					.antMatchers("/loginkassa").anonymous()
					.antMatchers("/users").hasRole("admin")
					.antMatchers("/greeting").authenticated()
					.antMatchers("/allusers").authenticated()
					.antMatchers("/vacaciones").authenticated();
			// @formatter:on
		}

	}
}
