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

package com.transaltisa.hoteles.Modelo;

public class Greeting {

	private final long id;
	private final long id_usuario;
	private final String content;
	private final String passw;

	public long getId() {
		return id;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public String getContent() {
		return content;
	}

	public String getPassw() {
		return passw;
	}

	public Greeting(long id,long id_usu, String content, String passw) {
		this.id = id;
		this.id_usuario = id_usu;
		this.content = content;
		this.passw = passw;
	}

}
