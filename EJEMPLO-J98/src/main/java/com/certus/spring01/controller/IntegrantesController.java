package com.certus.spring01.controller;


//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/app")
public class IntegrantesController {
	@GetMapping({ "/integrantes", })
	public String HolaMundo(Model model) {

		model.addAttribute("TituloPagina", "INTEGRANTES|GRUPO03");
		model.addAttribute("titulo", "GRUPO 03");
		model.addAttribute("descripcion", "Se muestran a todos los integrantes del Grupo 03");

		return"Integrantes";

	}

}

