package com.certus.spring.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.certus.spring.config.MvcConfig;
import com.certus.spring.models.Mascota;
import com.certus.spring.models.Response;
import com.certus.spring.repository.MascotaDAO;

@Component("servicio1")
public class MascotaService implements IMascotaService {

	@Autowired
	MascotaDAO mascotaRepository;

	@Autowired
	MvcConfig config;

	@Override
	public Response<Mascota> crearMascota(Mascota p, MultipartFile fileRecibido) {

		Response<Mascota> response = new Response<>();
		try {

			if (!fileRecibido.isEmpty()) {
				try {

					if (p.getUriImagen() != null) {

						Path enlaceGuardado = Paths.get(config.pathImage() + "\\" + p.getUriImagen());
						File fileEliminar = enlaceGuardado.toFile();

						if (fileEliminar.exists()) {
							fileEliminar.delete();
						}
					}

					String NewExtention = StringUtils.getFilenameExtension(fileRecibido.getOriginalFilename());
					String newName = UUID.randomUUID().toString() + "." + NewExtention;

					byte[] bytesFile = fileRecibido.getBytes();
					Path enlaceAGuardar = Paths.get(config.pathImage() + "//" + newName);
					Files.write(enlaceAGuardar, bytesFile);

					p.setUriImagen(newName);

				} catch (IOException e) {
					response.setEstado(false);
					response.setMensaje("Error al crear la mascota");
					response.setMensajeError(e.getStackTrace().toString());
					return response;
				}

			}

			Mascota mascota = mascotaRepository.save(p);
			response.setEstado(true);
			response.setMensaje("La Mascota ha sido creado correctamente");

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al crear el Mascotas correctamente");
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

	@Override
	public Response<Mascota> editarMascota(Integer ID) {

		Response<Mascota> response = new Response<>();

		try {
			Optional<Mascota> p = mascotaRepository.findById(ID);
			response.setEstado(true);
			response.setData(p.get());

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensajeError(e.getStackTrace().toString());
		}

		return response;
	}

	@Override
	public Response<Mascota> eliminarMascota(Integer ID) {

		Response<Mascota> response = new Response<>();

		try {
			Optional<Mascota> p = mascotaRepository.findById(ID);

			Path rutaElimarFile = Paths.get(config.pathImage() + "/" + p.get().getUriImagen());
			File fileEliminar = rutaElimarFile.toFile();
			if (fileEliminar.exists()) {
				fileEliminar.delete();
			}

			mascotaRepository.deleteById(ID);
			response.setEstado(true);
			response.setMensaje("El Mascota ha sido eliminado");

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al eliminar el Mascota");
			response.setMensajeError(e.getStackTrace().toString());
		}

		return response;
	}

	@Override
	public Response<Mascota> listarMascota() {

		Response<Mascota> response = new Response<>();

		try {

			response.setListData((List<Mascota>) mascotaRepository.findAll());
			response.setEstado(true);
			response.setMensaje("Mascotas obtenidos correctamente");

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al obtener los Mascotas");
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

	@Override
	public Response<Mascota> home() {

		Response<Mascota> response = new Response<>();

		try {

			response.setListData((List<Mascota>) mascotaRepository.findAll());
			response.setEstado(true);
			response.setMensaje("Mascotas obtenidos correctamente");

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al obtener los Mascotas");
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

	@Override
	public Response<Mascota> adopcion() {

		Response<Mascota> response = new Response<>();

		try {

			response.setListData((List<Mascota>) mascotaRepository.findAll());
			response.setEstado(true);
			response.setMensaje("Mascotas obtenidos correctamente");

		} catch (Exception e) {
			response.setEstado(false);
			response.setMensaje("Error al obtener los Mascotas");
			response.setMensajeError(e.getStackTrace().toString());
		}
		return response;
	}

}
