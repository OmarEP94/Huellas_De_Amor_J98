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

import com.certus.spring.models.Usuario;
import com.certus.spring.models.Response;
import com.certus.spring.service.IUsuarioService;

@Controller
@RequestMapping("/app")
@SessionAttributes("usuario")

public class UsuarioController {

    @Value("${title.generic}")
    private String titlePage;

    @Value("${mensaje}")
    private String mensaje;

    @Autowired
    @Qualifier("servicio3")
    private IUsuarioService InterfaceUsuario;

    @GetMapping({ "/listarusu" })
    public String ListarUsuarios(Model model) {

        model.addAttribute("TituloPagina", titlePage);
        model.addAttribute("titulo", "Sección J98");
        Response<Usuario> rspta = InterfaceUsuario.listarUsuario();

        if (rspta.getEstado()) {
            model.addAttribute("Mensaje", rspta.getMensaje());
            model.addAttribute("listita", rspta.getListData());
            return "ListaUsuario";
        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());
            return "errores";
        }
    }

    @GetMapping("/crearusu")
    public String CrearUsuario(Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("TituloPagina", titlePage);
        model.addAttribute("titulo", "Sección J98 - Crear Usuario");
        model.addAttribute("usuario", usuario);

        return "Registro";
    }

    @GetMapping("/Editarusu/{idUsuario}")
    public String EditarUsuario(@PathVariable int idUsuario, Model model) {

        model.addAttribute("TituloPagina", titlePage);

        Response<Usuario> rspta = InterfaceUsuario.editarUsuario(idUsuario);

        model.addAttribute("titulo", "Sección J98 - Editando el Usuario");

        model.addAttribute("usuario", rspta.getData());

        return "Registro";
    }

    @GetMapping("/Elimnarusu/{idUsuario}")
    public String ElimnarUsuario(@PathVariable int idUsuario, Model model) {

        Response<Usuario> rspta = InterfaceUsuario.eliminarUsuario(idUsuario);

        if (rspta.getEstado()) {
            return "redirect:/app/listarusu";
        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());

            return "errores";
        }
    }

    @PostMapping("/formusu")
    public String creaUsuario(@Valid Usuario Luffy, BindingResult result, Model model, SessionStatus sStatus) {

        if (result.hasErrors()) {
            return "Registro";
        }

        Response<Usuario> rspta = InterfaceUsuario.crearUsuario(Luffy);

        if (rspta.getEstado()) {

            sStatus.setComplete();
            return "redirect:/app/login";

        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());
            return "errores";
        }

    }

}
