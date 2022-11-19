package com.certus.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.certus.spring.models.Mascota;
import com.certus.spring.models.Response;
import com.certus.spring.repository.IMascotaDAO;

public class MascotaService {

    @Autowired
    IMascotaDAO mascotaRepository;
    /*
     * @Override
     * public Response<Mascota> crearMascota(Mascota p) {
     * Response<Mascota> response = new Response<>();
     * try {
     * 
     * Mascota mascota = mascotaRepository.save(p);
     * response.setEstado(true);
     * response.setMensaje("El Mascota se realizo correctamente");
     * 
     * } catch (Exception e) {
     * response.setEstado(false);
     * response.setMensaje("Error al ingresar el Mascota");
     * response.setMensajeError(e.getStackTrace().toString());
     * }
     * return response;
     * }
     * 
     * @Override
     * public Response<Mascota> editarMascota(Integer ID) {
     * 
     * Response<Mascota> response = new Response<>();
     * 
     * try {
     * Optional<Mascota> p = mascotaRepository.findById(ID);
     * response.setEstado(true);
     * response.setData(p.get());
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
     * public Response<Mascota> eliminarMascota(Integer ID) {
     * 
     * Response<Mascota> response = new Response<>();
     * 
     * try {
     * Optional<Mascota> p = mascotaRepository.findById(ID);
     * 
     * mascotaRepository.deleteById(ID);
     * response.setEstado(true);
     * response.setMensaje("El Mascota ha sido eliminado");
     * 
     * } catch (Exception e) {
     * response.setEstado(false);
     * response.setMensaje("Error al eliminar el Mascota");
     * response.setMensajeError(e.getStackTrace().toString());
     * }
     * 
     * return response;
     * }
     * 
     * @Override
     * public Response<Mascota> listarMascota() {
     * 
     * Response<Mascota> response = new Response<>();
     * 
     * try {
     * 
     * response.setListData((List<Mascota>) MascotaRepository.findAll());
     * response.setEstado(true);
     * response.setMensaje("Mascotas obtenidos correctamente");
     * 
     * } catch (Exception e) {
     * response.setEstado(false);
     * response.setMensaje("Error al obtener los Mascotas");
     * response.setMensajeError(e.getStackTrace().toString());
     * }
     * return response;
     * }
     */
}
