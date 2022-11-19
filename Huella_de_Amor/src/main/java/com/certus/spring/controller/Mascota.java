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

/*import com.certus.spring.models.Mascota;*/
import com.certus.spring.models.Response;
import com.certus.spring.service.IMascotaService;

@Controller
@RequestMapping("/app/adminpage")
public class Mascota {
	/*
	 * @Value("${title.generic}")
	 * private String titlePage;
	 * 
	 * @Value("${mensaje}")
	 * private String mensaje;
	 * 
	 * @GetMapping("/listar")
	 * public String listarMascotas(Model model) {
	 * 
	 * model.addAttribute("TituloPagina", titlePage);
	 * model.addAttribute("titulo", "Sección J98");
	 * Response<Mascota> rspta = InterfaceMascota1.listarMascota();
	 * 
	 * if (rspta.getEstado()) {
	 * model.addAttribute("Mensaje", rspta.getMensaje());
	 * model.addAttribute("listita", rspta.getListData());
	 * return "Adminpage";
	 * } else {
	 * model.addAttribute("mensaje", rspta.getMensaje());
	 * model.addAttribute("mensajeError", rspta.getMensajeError());
	 * return "errores";
	 * }
	 * }
	 * 
	 * @GetMapping("/crear")
	 * public String crearMascota(Model model) {
	 * Mascota mascota = new Mascota();
	 * 
	 * model.addAttribute("TituloPagina", titlePage);
	 * model.addAttribute("titulo", "");
	 * model.addAttribute("Mascota", Mascota);
	 * 
	 * return "Adopcion";
	 * }
	 * 
	 * @GetMapping("/Editar/{idMascota}")
	 * public String editarMascota(@PathVariable int idMascota, Model model) {
	 * 
	 * model.addAttribute("TituloPagina", titlePage);
	 * 
	 * Response<Mascota> rspta = InterfaceMascota1.editarMascota(idMascota);
	 * 
	 * model.addAttribute("titulo", "Sección J98 - Editando el Regsitro");
	 * 
	 * model.addAttribute("Mascota", rspta.getData());
	 * 
	 * return "Adminpage";
	 * }
	 * 
	 * @GetMapping("/Editar/{idRegsitro}")
	 * public String elimnarMascota(@PathVariable int idRegsitro, Model model) {
	 * 
	 * Response<Mascota> rspta = InterfaceMascota1.eliminarMascota(idRegsitro);
	 * 
	 * if (rspta.getEstado()) {
	 * return "redirect:/app/adminpage";
	 * } else {
	 * model.addAttribute("mensaje", rspta.getMensaje());
	 * model.addAttribute("mensajeError", rspta.getMensajeError());
	 * 
	 * return "errores";
	 * }
	 * }
	 * 
	 * @PostMapping("/form")
	 * public String creaMascota(@Valid Mascota Luffy, BindingResult result, Model
	 * model) {
	 * 
	 * if (result.hasErrors()) {
	 * return "Adopcion";
	 * }
	 * Response<Mascota> rspta = InterfaceMascota1.crearMascota(Luffy);
	 * 
	 * if (rspta.getEstado()) {
	 * return "redirect:/app/home";
	 * } else {
	 * model.addAttribute("mensaje", rspta.getMensaje());
	 * model.addAttribute("mensajeError", rspta.getMensajeError());
	 * return "errores";
	 * }
	 * 
	 * }
	 * 
	 */
}
