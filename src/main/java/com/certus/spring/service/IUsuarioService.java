
package com.certus.spring.service;

import com.certus.spring.models.Usuario;
import com.certus.spring.models.Response;

public interface IUsuarioService {

    public Response<Usuario> crearUsuario(Usuario u);

    public Response<Usuario> editarUsuario(Integer ID);

    public Response<Usuario> eliminarUsuario(Integer ID);

    public Response<Usuario> listarUsuario();

}
