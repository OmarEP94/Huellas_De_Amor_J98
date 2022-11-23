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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.certus.spring.models.Registro;
import com.certus.spring.models.Response;
import com.certus.spring.service.IRegistroService;

@Controller
@RequestMapping("/app")
@SessionAttributes("registro")

public class RegistroController {

    @Value("${title.generic}")
    private String titlePage;

    @Value("${mensaje}")
    private String mensaje;

    @Autowired
    @Qualifier("servicio2")
    private IRegistroService InterfaceRegistro1;

    @GetMapping({ "/listarreg" })
    public String ListarRegistros(Model model) {

        model.addAttribute("TituloPagina", titlePage);
        model.addAttribute("titulo", "Sección J98");
        Response<Registro> rspta = InterfaceRegistro1.listarRegistro();

        if (rspta.getEstado()) {
            model.addAttribute("Mensaje", rspta.getMensaje());
            model.addAttribute("listita", rspta.getListData());
            return "Listareg";
        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());
            return "errores";
        }
    }

    @GetMapping("/crearreg")
    public String CrearRegistro(Model model) {
        Registro registro = new Registro();

        model.addAttribute("TituloPagina", titlePage);
        model.addAttribute("titulo", "Sección J98 - Crear Registro");
        model.addAttribute("registro", registro);

        return "Formreg";
    }

    @GetMapping("/Editarreg/{idRegistro}")
    public String EditarRegistro(@PathVariable int idRegistro, Model model) {

        model.addAttribute("TituloPagina", titlePage);

        Response<Registro> rspta = InterfaceRegistro1.editarRegistro(idRegistro);

        model.addAttribute("titulo", "Sección J98 - Editando el Registro");

        model.addAttribute("registro", rspta.getData());

        return "Formreg";
    }

    @GetMapping("/Elimnarreg/{idRegistro}")
    public String ElimnarRegistro(@PathVariable int idRegistro, Model model) {

        Response<Registro> rspta = InterfaceRegistro1.eliminarRegistro(idRegistro);

        if (rspta.getEstado()) {
            return "redirect:/app/listarreg";
        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());

            return "errores";
        }
    }

    @PostMapping("/formreg")
    public String creaRegistro(@Valid Registro Luffy, BindingResult result, Model model, SessionStatus sStatus) {

        if (result.hasErrors()) {
            return "Formreg";
        }

        Response<Registro> rspta = InterfaceRegistro1.crearRegistro(Luffy);

        if (rspta.getEstado()) {

            sStatus.setComplete();
            return "redirect:/app/listarreg";

        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());
            return "errores";
        }

    }
}