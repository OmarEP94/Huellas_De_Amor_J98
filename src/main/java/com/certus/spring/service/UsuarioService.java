
package com.certus.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.certus.spring.config.MvcConfig;
import com.certus.spring.models.Usuario;
import com.certus.spring.models.Response;
import com.certus.spring.repository.UsuarioDAO;

@Component("servicio3")
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioDAO usuarioRepository;

    @Autowired
    MvcConfig config;

    @Override
    public Response<Usuario> crearUsuario(Usuario p) {

        Response<Usuario> response = new Response<>();
        try {
            Usuario usuario = usuarioRepository.save(p);
            response.setEstado(true);
            response.setMensaje("La Usuario ha sido creado correctamente");

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensaje("Error al crear la Usuario");
            response.setMensajeError(e.getStackTrace().toString());
            return response;
        }

        return response;
    }

    @Override
    public Response<Usuario> editarUsuario(Integer ID) {

        Response<Usuario> response = new Response<>();

        try {
            Optional<Usuario> p = usuarioRepository.findById(ID);
            response.setEstado(true);
            response.setData(p.get());

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensajeError(e.getStackTrace().toString());
        }

        return response;
    }

    @Override
    public Response<Usuario> eliminarUsuario(Integer ID) {

        Response<Usuario> response = new Response<>();

        try {
            Optional<Usuario> p = usuarioRepository.findById(ID);

            usuarioRepository.deleteById(ID);
            response.setEstado(true);
            response.setMensaje("El Usuario ha sido eliminado");

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensaje("Error al eliminar el Usuario");
            response.setMensajeError(e.getStackTrace().toString());
        }

        return response;
    }

    @Override
    public Response<Usuario> listarUsuario() {

        Response<Usuario> response = new Response<>();

        try {

            response.setListData((List<Usuario>) usuarioRepository.findAll());
            response.setEstado(true);
            response.setMensaje("Usuarios obtenidos correctamente");

        } catch (Exception e) {
            response.setEstado(false);
            response.setMensaje("Error al obtener los Usuarios");
            response.setMensajeError(e.getStackTrace().toString());
        }
        return response;
    }
}
