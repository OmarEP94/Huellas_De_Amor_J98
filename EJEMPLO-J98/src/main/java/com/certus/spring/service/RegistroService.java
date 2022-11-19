package com.certus.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.certus.spring.models.Registro;
import com.certus.spring.models.Response;
import com.certus.spring.repository.IRegistroDAO;

@Component("servicio1")
public class RegistroService implements IRegistroService {

	@Autowired
	IRegistroDAO registroRepository;

	@Override
	public Response<Registro> crearRegistro(Registro r) {
		Response<Registro> response = new Response<>();
		try {

			Registro registro = registroRepository.save(r);
			response.setEstado(true);
			response.setMensaje("El Registro se realizo correctamente");

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al ingresar el registro");
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

	@Override
	public Response<Registro> editarRegistro(Integer ID) {

		Response<Registro> response = new Response<>();

		try {
			Optional<Registro> r = registroRepository.findById(ID);
			response.setEstado(true);
			response.setData(r.get());

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensajeError(e.getStackTrace().toString());
		}

		return response;
	}

	@Override
	public Response<Registro> eliminarRegistro(Integer ID) {

		Response<Registro> response = new Response<>();

		try {
			Optional<Registro> r = registroRepository.findById(ID);

			registroRepository.deleteById(ID);
			response.setEstado(true);
			response.setMensaje("El Registro ha sido eliminado");

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al eliminar el Registro");
			response.setMensajeError(e.getStackTrace().toString());
		}

		return response;
	}

	@Override
	public Response<Registro> listarRegistro() {

		Response<Registro> response = new Response<>();

		try {

			response.setListData((List<Registro>) registroRepository.findAll());
			response.setEstado(true);
			response.setMensaje("Registros obtenidos correctamente");

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al obtener los Registros");
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

}