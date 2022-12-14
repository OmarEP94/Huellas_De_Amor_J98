package com.certus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.certus.spring.models.Mascota;
import com.certus.spring.models.Response;
import com.certus.spring.service.IMascotaService;

/*
import com.certus.spring.models.Registro;
import com.certus.spring.service.IRegistroService;
*/
@Controller
@RequestMapping({ "/app", "/" })
@SessionAttributes({})
public class HomeController {

	@Value("${title.generic}")
	private String titlePage;

	@Value("${mensaje}")
	private String mensaje;

	@Autowired
	@Qualifier("servicio1")
	private IMascotaService InterfaceMascota1;

	@GetMapping({ "/home", "/inicio", "/", "/Home", "/Inicio" })
	public String Home(Model model) {

		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		Response<Mascota> rspta = InterfaceMascota1.listarMascota();

		if (rspta.getEstado()) {
			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("listita", rspta.getListData());
			return "Home";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());
			return "errores";
		}

	}

	@GetMapping({ "/adopcion" })
	public String Adopcion(Model model) {
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		Response<Mascota> rspta = InterfaceMascota1.listarMascota();

		if (rspta.getEstado()) {
			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("listita", rspta.getListData());
			return "Adopcion";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());
			return "errores";
		}
	}

	@GetMapping({ "/login" })
	public String Login(Model model) {

		return "Login";
	}

	@GetMapping({ "/registro" })
	public String Registro(Model model) {
		model.addAttribute("TituloPagina", "Inicia Sesión");
		model.addAttribute("titulo", "Iniciar Sesión");

		return "Registro";
	}

	@GetMapping({ "/contacto" })
	public String Contacto(Model model) {
		model.addAttribute("TituloPagina", "Inicia Sesión");
		model.addAttribute("titulo", "Iniciar Sesión");

		return "Contacto";
	}

	@GetMapping({ "/nosotros", })
	public String Nosotros(Model model) {

		model.addAttribute("TituloPagina", "HUELLAS DE AMOR | SOBRE NOSOTROS ");
		model.addAttribute("titulo", "HUELLAS DE AMOR");
		model.addAttribute("TituloSN", "Se muestran a todos los integrantes del Grupo 03");

		return "SobreNosotros";
	}

	@GetMapping({ "/integrantes" })
	public String Integrantes(Model model) {

		model.addAttribute("TituloPagina", "HUELLAS DE AMOR | SOBRE NOSOTROS ");
		model.addAttribute("titulo", "HUELLAS DE AMOR");
		model.addAttribute("tituloSN", "Se muestran a todos los integrantes del Grupo 03");

		return "Integrantes";
	}

}
