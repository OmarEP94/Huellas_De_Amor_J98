package com.certus.spring01.controller;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring01.models.Personaje;

@Controller
@RequestMapping("/app")
public class HomeController {

	/*@Value("${title.generic}")
	private String titlePage;*/

	@GetMapping({ "/home", "/inicio", "/", "/Home", "/Inicio" })
	public String HolaMundo(Model model) {

		/*Instanciando un personaje1 del tipo Personaje*/
		Personaje personaje1 = new Personaje();

		// Agregando datos a los atributos del personaje1
		personaje1.setNombres("Luffy");
		personaje1.setAlias("Luffy Alias");
		personaje1.setTipoFruta("Luffy Tipo Fruta");
		personaje1.setHabilidad("Luffy Hablidad");
		personaje1.setTripulacion("Luffy Trupulacion");
		personaje1.setRecompensa("123456789");

		//Instanciando una lista del tipo List del tip Personaje
		List<Personaje> listita = new ArrayList<>();

		//Instanciando un personaje2 del tipo Personaje
		Personaje personaje2 = new Personaje();

		//Agregando datos a los atributos del personaje2
		personaje2.setNombres("Luffy 2");
		personaje2.setAlias("Luffy Alias 2");
		personaje2.setTipoFruta("Luffy Tipo Fruta 2");
		personaje2.setHabilidad("Luffy Hablidad 2");
		personaje2.setTripulacion("Luffy Trupulacion 2");
		personaje2.setRecompensa("123456789 2");
		

		// Agregando un personaje a la lista
		listita.add(personaje1);
		listita.add(personaje2);

		model.addAttribute("TituloPagina", "HUELLAS DE AMOR|HOME");
		model.addAttribute("titulo", "HUELLAS DE AMOR");
		model.addAttribute("titulonav1", "Adopta y regala una esperanza...");
		model.addAttribute("titulonav2", "No compres, adopta...");
		model.addAttribute("titulonav3", "Un nuevo amigo te espera...");
		model.addAttribute("listita", listita);

		return"Home";

	}

}
