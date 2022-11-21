package com.certus.spring.service;

import org.springframework.web.multipart.MultipartFile;

import com.certus.spring.models.Mascota;
import com.certus.spring.models.Response;

public interface IMascotaService {

	public Response<Mascota> crearMascota(Mascota p, MultipartFile fileRecibido);

	public Response<Mascota> editarMascota(Integer ID);

	public Response<Mascota> eliminarMascota(Integer ID);

	public Response<Mascota> listarMascota();

	public Response<Mascota> home();

	public Response<Mascota> adopcion();

}
