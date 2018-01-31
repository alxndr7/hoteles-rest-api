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

package kassa.Servicio;

import java.math.BigInteger;

public class Personal {

	private final long persId;
	private final String nombre1;
        private final String nombre2;
        private final String apePat;
        private final String apeMat;
        private final String nacFecha;
        private final String direccion;
        private final String telefFijo;
        private final String telefCelular;
        private final long sexoId;
        private final String referenciaDir;
        
    
    public Personal(long persId, String nombre1, String nombre2, String apePat, String apeMat, String nacFecha, String direccion, String telefFijo, String telefCelular, long sexoId, String referenciaDir) {
        this.persId = persId;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.nacFecha = nacFecha;
        this.direccion = direccion;
        this.telefFijo = telefFijo;
        this.telefCelular = telefCelular;
        this.sexoId = sexoId;
        this.referenciaDir = referenciaDir;
    }
        
            

    public String getApePat() {
        return apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public String getNacFecha() {
        return nacFecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefFijo() {
        return telefFijo;
    }

    public String getTelefCelular() {
        return telefCelular;
    }

    public long getSexoId() {
        return sexoId;
    }

    public String getReferenciaDir() {
        return referenciaDir;
    }   

    public long getPersId() {
        return persId;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }



}
