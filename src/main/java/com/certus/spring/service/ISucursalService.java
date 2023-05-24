
package com.certus.spring.service;

import com.certus.spring.models.Sucursal;
import com.certus.spring.models.Response;

public interface ISucursalService {

    public Response<Sucursal> crearSucursal(Sucursal p);

    public Response<Sucursal> editarSucursal(Integer ID);

    public Response<Sucursal> eliminarSucursal(Integer ID);

    public Response<Sucursal> listarSucursal();

}
