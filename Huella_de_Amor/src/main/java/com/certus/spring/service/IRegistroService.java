package com.certus.spring.service;

import com.certus.spring.models.Registro;
import com.certus.spring.models.Response;

public interface IRegistroService {
	
	public Response<Registro> crearRegistro(Registro r);
	
	public Response<Registro> editarRegistro(Integer ID);	
	
	public Response<Registro> eliminarRegistro(Integer ID);	
	
	public Response<Registro> listarRegistro();

}