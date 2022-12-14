
package com.certus.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.certus.spring.config.MvcConfig;
import com.certus.spring.models.Registro;
import com.certus.spring.models.Response;
import com.certus.spring.repository.RegistroDAO;

@Component("servicio2")
public class RegistroService implements IRegistroService {

    @Autowired
    RegistroDAO registroRepository;

    @Autowired
    MvcConfig config;

    @Override
    public Response<Registro> crearRegistro(Registro p) {

        Response<Registro> response = new Response<>();
        try {
            Registro registro = registroRepository.save(p);
            response.setEstado(true);
            response.setMensaje("La Registro ha sido creado correctamente");

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensaje("Error al crear la Registro");
            response.setMensajeError(e.getStackTrace().toString());
            return response;
        }

        return response;
    }

    @Override
    public Response<Registro> editarRegistro(Integer ID) {

        Response<Registro> response = new Response<>();

        try {
            Optional<Registro> p = registroRepository.findById(ID);
            response.setEstado(true);
            response.setData(p.get());

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
            Optional<Registro> p = registroRepository.findById(ID);

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

/*
 * 
 * @Component("servicio2")
 * public class RegistroService implements IRegistroService {
 * 
 * @Override
 * public Response<Registro> crearRegistro(Registro p) {
 * Response<Registro> response = new Response<>();
 * try {
 * response.setEstado(true);
 * response.setMensaje("El Registro ha sido creado correctamente");
 * 
 * } catch (Exception e) {
 * response.setEstado(false);
 * response.setMensaje("Error al crear el Registro");
 * response.setMensajeError(e.getStackTrace().toString());
 * }
 * return response;
 * }
 * 
 * @Override
 * public Response<Registro> editarRegistro(Integer ID) {
 * 
 * Response<Registro> response = new Response<>();
 * 
 * try {
 * response.setEstado(true);
 * 
 * } catch (Exception e) {
 * response.setEstado(false);
 * response.setMensajeError(e.getStackTrace().toString());
 * }
 * 
 * return response;
 * }
 * 
 * @Override
 * public Response<Registro> eliminarRegistro(Integer ID) {
 * 
 * Response<Registro> response = new Response<>();
 * 
 * try {
 * response.setEstado(true);
 * response.setMensaje("El Registro ha sido eliminado");
 * 
 * } catch (Exception e) {
 * response.setEstado(false);
 * response.setMensaje("Error al eliminar el Registro");
 * response.setMensajeError(e.getStackTrace().toString());
 * }
 * 
 * return response;
 * }
 * 
 * @Override
 * public Response<Registro> listarRegistro() {
 * 
 * Response<Registro> response = new Response<>();
 * 
 * try {
 * response.setEstado(true);
 * response.setMensaje("Registros obtenidos correctamente");
 * 
 * } catch (Exception e) {
 * response.setEstado(false);
 * response.setMensaje("Error al obtener los Registros");
 * response.setMensajeError(e.getStackTrace().toString());
 * }
 * return response;
 * }
 * }
 */