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
import com.certus.spring.models.Sucursal;
import com.certus.spring.service.ISucursalService;

@Controller
@RequestMapping("/app")
@SessionAttributes("usuario")

public class UsuarioController {

    @Value("${mensaje}")
    private String mensaje;

    @Autowired
    @Qualifier("servicio1")
    private ISucursalService InterfaceSucursal;

    @Autowired
    @Qualifier("servicio2")
    private IUsuarioService InterfaceUsuario;

    @GetMapping({ "/listarusu" })
    public String ListarUsuario(Model model) {

        model.addAttribute("TituloPagina", "Crud Practica");
        model.addAttribute("Titulo", "Lista de Usuarios");
        Response<Usuario> rspta = InterfaceUsuario.listarUsuario();

        if (rspta.getEstado()) {
            model.addAttribute("Mensaje", rspta.getMensaje());
            model.addAttribute("listita", rspta.getListData());
            return "UsuList";
        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());
            return "errores";
        }
    }

    @GetMapping("/crearusu")
    public String crearUsuario(Model model) {
        Usuario usuario = new Usuario();
        Response<Sucursal> rspta = InterfaceSucursal.listarSucursal();

        model.addAttribute("TituloPagina", "Crud Practica");
        model.addAttribute("Titulo", "Creando Usuario");
        model.addAttribute("Btn", "Crear Usuario");
        model.addAttribute("usuario", usuario);

        model.addAttribute("sucursal", rspta.getListData());

        return "UsuReg";
    }

    @GetMapping("/Editarusu/{idUsuario}")
    public String EditarUsuario(@PathVariable int idUsuario, Model model) {

        model.addAttribute("TituloPagina", "Crud Practica");

        Response<Usuario> rspta = InterfaceUsuario.editarUsuario(idUsuario);
        Response<Sucursal> rsptausu = InterfaceSucursal.listarSucursal();

        model.addAttribute("Titulo", "Editando Usuario");
        model.addAttribute("Btn", "Editando Usuario");

        model.addAttribute("usuario", rspta.getData());
        model.addAttribute("sucursal", rsptausu.getListData());

        return "UsuReg";
    }

    @GetMapping("/Eliminarusu/{idUsuario}")
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
    public String creaUsuario(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus sStatus) {
        Response<Sucursal> rsptausu = InterfaceSucursal.listarSucursal();
        if (result.hasErrors()) {

            model.addAttribute("Btn", "Enviar Usuario");

            model.addAttribute("sucursal", rsptausu.getListData());
            return "UsuReg";
        }

        Response<Usuario> rspta = InterfaceUsuario.crearUsuario(usuario);

        if (rspta.getEstado()) {

            sStatus.setComplete();
            return "redirect:/app/listarusu";

        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());
            return "errores";
        }

    }
}