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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.certus.spring.models.Mascota;
import com.certus.spring.models.Response;
import com.certus.spring.service.IMascotaService;

/*
import com.certus.spring.models.Registro;
import com.certus.spring.service.IRegistroService;
*/
@Controller
@RequestMapping("/app")
@SessionAttributes({ "mascota", "registro" })
public class HomeController {

	@Value("${title.generic}")
	private String titlePage;

	@Value("${mensaje}")
	private String mensaje;

	@Autowired
	@Qualifier("servicio1")
	private IMascotaService InterfaceMascota1;

	@GetMapping({ "/home", "/inicio", "/", "/Home", "/Inicio" })

	// model.addAttribute("TituloPagina", titlePage);
	// model.addAttribute("titulo", "Sección J98");
	// model.addAttribute("Mensaje", mensaje);

	public String Home(Model model) {

		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		Response<Mascota> rspta = InterfaceMascota1.listarMascota();

		if (rspta.getEstado()) {
			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("listita", rspta.getListData());
			return "home";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());
			return "errores";
		}

	}

	@GetMapping({ "/listar" })
	public String ListarMascotas(Model model) {

		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		Response<Mascota> rspta = InterfaceMascota1.listarMascota();

		if (rspta.getEstado()) {
			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("listita", rspta.getListData());
			return "Listapets";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());
			return "errores";
		}
	}

	@GetMapping("/crear")
	public String CrearMascota(Model model) {
		Mascota mascota = new Mascota();

		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98 - Crear Mascota");
		model.addAttribute("mascota", mascota);

		return "Formpets";
	}

	@GetMapping("/Editar/{idMascota}")
	public String EditarMascota(@PathVariable int idMascota, Model model) {

		model.addAttribute("TituloPagina", titlePage);

		Response<Mascota> rspta = InterfaceMascota1.editarMascota(idMascota);

		model.addAttribute("titulo", "Sección J98 - Editando el mascota");

		model.addAttribute("mascota", rspta.getData());

		return "Formpets";
	}

	@GetMapping("/Elimnar/{idMascota}")
	public String ElimnarMascota(@PathVariable int idMascota, Model model) {

		Response<Mascota> rspta = InterfaceMascota1.eliminarMascota(idMascota);

		if (rspta.getEstado()) {
			return "redirect:/app/listar";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());

			return "errores";
		}
	}

	@PostMapping("/form")
	public String creaMascota(@Valid Mascota Luffy, BindingResult result, Model model,
			@RequestParam("ImagenDelFormulario") MultipartFile fileRecibido, SessionStatus sStatus) {

		if (result.hasErrors()) {
			return "Formpets";
		}

		Response<Mascota> rspta = InterfaceMascota1.crearMascota(Luffy, fileRecibido);

		if (rspta.getEstado()) {

			sStatus.setComplete();
			return "redirect:/app/listar";

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
		model.addAttribute("TituloPagina", titlePage);
		model.addAttribute("titulo", "Sección J98");
		Response<Mascota> rspta = InterfaceMascota1.listarMascota();

		if (rspta.getEstado()) {
			model.addAttribute("Mensaje", rspta.getMensaje());
			model.addAttribute("listita", rspta.getListData());
			return "adopcion";
		} else {
			model.addAttribute("mensaje", rspta.getMensaje());
			model.addAttribute("mensajeError", rspta.getMensajeError());
			return "errores";
		}
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
	/*
	 * // FORMULARIO DE REGISTRAR
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("servicio1")
	 * private IRegistroService InterfaceRegistro1;
	 * 
	 * @GetMapping("/crearreg")
	 * public String Formulario(Model model) {
	 * Registro registro = new Registro();
	 * 
	 * model.addAttribute("TituloPagina", titlePage);
	 * model.addAttribute("titulo", "Sección J98 - Crear Registro");
	 * model.addAttribute("registro", registro);
	 * 
	 * return "Formregistro";
	 * }
	 * 
	 * @PostMapping("/formreg")
	 * public String creaRegistro(@Valid Registro Luffy, BindingResult result, Model
	 * model,
	 * 
	 * @RequestParam("ImagenDelFormulario") MultipartFile fileRecibido,
	 * SessionStatus sStatus) {
	 * 
	 * if (result.hasErrors()) {
	 * return "Formregistro";
	 * }
	 * 
	 * Response<Registro> rspta = InterfaceRegistro1.crearRegistro(Luffy,
	 * fileRecibido);
	 * 
	 * if (rspta.getEstado()) {
	 * 
	 * sStatus.setComplete();
	 * return "redirect:/app/listarreg";
	 * 
	 * } else {
	 * model.addAttribute("mensaje", rspta.getMensaje());
	 * model.addAttribute("mensajeError", rspta.getMensajeError());
	 * return "errores";
	 * }
	 * 
	 * }
	 * 
	 * @GetMapping({ "/listarreg" })
	 * public String ListarRegistro(Model model) {
	 * 
	 * model.addAttribute("TituloPagina", titlePage);
	 * model.addAttribute("titulo", "Sección J98");
	 * Response<Registro> rspta = InterfaceRegistro1.listarRegistro();
	 * 
	 * if (rspta.getEstado()) {
	 * model.addAttribute("Mensaje", rspta.getMensaje());
	 * model.addAttribute("listita", rspta.getListData());
	 * return "ListaReg";
	 * } else {
	 * model.addAttribute("mensaje", rspta.getMensaje());
	 * model.addAttribute("mensajeError", rspta.getMensajeError());
	 * return "errores";
	 * }
	 * }
	 */

}
