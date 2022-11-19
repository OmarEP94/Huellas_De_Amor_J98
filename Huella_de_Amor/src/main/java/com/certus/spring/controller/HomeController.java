package com.certus.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring.models.Registro;
import com.certus.spring.models.Response;
import com.certus.spring.service.IRegistroService;

@Controller
@RequestMapping("/app")
public class HomeController {

	@Value("${title.generic}")
	private String titlePage;

	@Value("${mensaje}")
	private String mensaje;

	@Autowired
	@Qualifier("servicio1")
	private IRegistroService InterfaceRegistro1;

	@GetMapping({ "/home", "/inicio", "/", "/Home", "/Inicio" })
	public String Home(Model model) {
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		model.addAttribute("Mensaje", mensaje);

		return "Home";

	}

	@GetMapping("/listar")
	public String listarRegistros(Model model) {

		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		Response<Registro> rspta = InterfaceRegistro1.listarRegistro();

		if (rspta.getEstado()) {
			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("listita", rspta.getListData());
			return "Adminpage";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());
			return "errores";
		}
	}

	@GetMapping("/crear")
	public String crearRegistro(Model model) {
		Registro registro = new Registro();

		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "");
		model.addAttribute("registro", registro);

		return "Adopcion";
	}

	@GetMapping("/Editar/{idRegistro}")
	public String editarRegistro(@PathVariable int idRegistro, Model model) {

		model.addAttribute("TituloPagina", titlePage);

		Response<Registro> rspta = InterfaceRegistro1.editarRegistro(idRegistro);

		model.addAttribute("titulo", "Sección J98 - Editando el Regsitro");

		model.addAttribute("registro", rspta.getData());

		return "Adminpage";
	}

	@GetMapping("/Editar/{idRegsitro}")
	public String elimnarRegistro(@PathVariable int idRegsitro, Model model) {

		Response<Registro> rspta = InterfaceRegistro1.eliminarRegistro(idRegsitro);

		if (rspta.getEstado()) {
			return "redirect:/app/adminpage";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());

			return "errores";
		}
	}

	@PostMapping("/form")
	public String creaRegistro(@Valid Registro Luffy, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "Adopcion";
		}
		Response<Registro> rspta = InterfaceRegistro1.crearRegistro(Luffy);

		if (rspta.getEstado()) {
			return "redirect:/app/home";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());
			return "errores";
		}

	}

	@GetMapping({ "/proximamente" })
	public String Construccion(Model model) {
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		model.addAttribute("Mensaje", mensaje);

		return "proximamente";
	}

	@GetMapping({ "/adopcion" })
	public String Adopcion(Model model) {
		model.addAttribute("TituloPagina", "Inicia Sesión");
		model.addAttribute("titulo", "Iniciar Sesión");

		return "Adopcion";
	}

	@GetMapping({ "/login" })
	public String Login(Model model) {
		model.addAttribute("TituloPagina", "Inicia Sesión");
		model.addAttribute("titulo", "Iniciar Sesión");

		return "login";
	}

	@GetMapping({ "/registro" })
	public String Registro(Model model) {
		model.addAttribute("TituloPagina", "Inicia Sesión");
		model.addAttribute("titulo", "Iniciar Sesión");

		return "registro";
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

}
