
package com.certus.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.certus.spring.models.Sucursal;
import com.certus.spring.models.Response;
import com.certus.spring.repository.ISucursalDAO;

@Component("servicio1")
public class SucursalService implements ISucursalService {

    @Autowired
    ISucursalDAO sucursalRepository;

    @Override
    public Response<Sucursal> crearSucursal(Sucursal p) {

        Response<Sucursal> response = new Response<>();
        try {
            Sucursal sucursal = sucursalRepository.save(p);
            response.setEstado(true);
            response.setMensaje("La Sucursal ha sido creado correctamente");

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensaje("Error al crear la Sucursal");
            response.setMensajeError(e.getStackTrace().toString());
            return response;
        }

        return response;
    }

    @Override
    public Response<Sucursal> editarSucursal(Integer ID) {

        Response<Sucursal> response = new Response<>();

        try {
            Optional<Sucursal> p = sucursalRepository.findById(ID);
            response.setEstado(true);
            response.setData(p.get());

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensajeError(e.getStackTrace().toString());
        }

        return response;
    }

    @Override
    public Response<Sucursal> eliminarSucursal(Integer ID) {

        Response<Sucursal> response = new Response<>();

        try {
            Optional<Sucursal> p = sucursalRepository.findById(ID);

            sucursalRepository.deleteById(ID);
            response.setEstado(true);
            response.setMensaje("El Sucursal ha sido eliminado");

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensaje("Error al eliminar el Sucursal");
            response.setMensajeError(e.getStackTrace().toString());
        }

        return response;
    }

    @Override
    public Response<Sucursal> listarSucursal() {

        Response<Sucursal> response = new Response<>();

        try {

            response.setListData((List<Sucursal>) sucursalRepository.findAll());
            response.setEstado(true);
            response.setMensaje("Sucursals obtenidos correctamente");

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensaje("Error al obtener los Sucursals");
            response.setMensajeError(e.getStackTrace().toString());
        }
        return response;
    }

}