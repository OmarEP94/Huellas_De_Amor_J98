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

import com.certus.spring.models.Sucursal;
import com.certus.spring.models.Response;
import com.certus.spring.service.ISucursalService;

@Controller
@RequestMapping("/app")
@SessionAttributes("sucursal")

public class SucursalController {

    @Value("${mensaje}")
    private String mensaje;

    @Autowired
    @Qualifier("servicio1")
    private ISucursalService InterfaceSucursal;

    @GetMapping({ "/listarsucu" })
    public String ListarSucursal(Model model) {

        model.addAttribute("TituloPagina", "Crud Practica");
        model.addAttribute("Titulo", "Lista de Sucursales");
        Response<Sucursal> rspta = InterfaceSucursal.listarSucursal();

        if (rspta.getEstado()) {
            model.addAttribute("Mensaje", rspta.getMensaje());
            model.addAttribute("listita", rspta.getListData());
            return "SucuList";
        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());
            return "errores";
        }
    }

    @GetMapping("/crearsucu")
    public String CrearSucursal(Model model) {
        Sucursal sucursal = new Sucursal();

        model.addAttribute("TituloPagina", "Crud Practica");
        model.addAttribute("Titulo", "Creando Sucursal");
        model.addAttribute("Btn", "Crear Sucursal");
        model.addAttribute("sucursal", sucursal);

        return "SucuReg";
    }

    @GetMapping("/Editarsucu/{idSucursal}")
    public String EditarSucursal(@PathVariable int idSucursal, Model model) {

        model.addAttribute("TituloPagina", "Crud Practica");

        Response<Sucursal> rspta = InterfaceSucursal.editarSucursal(idSucursal);

        model.addAttribute("Titulo", "Editando Sucursal");
        model.addAttribute("Btn", "Editando Sucursal");

        model.addAttribute("sucursal", rspta.getData());

        return "SucuReg";
    }

    @GetMapping("/Eliminarsucu/{idSucursal}")
    public String ElimnarSucursal(@PathVariable int idSucursal, Model model) {

        Response<Sucursal> rspta = InterfaceSucursal.eliminarSucursal(idSucursal);

        if (rspta.getEstado()) {
            return "redirect:/app/listarsucu";
        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());

            return "errores";
        }
    }

    @PostMapping("/formsucu")
    public String creaSucursal(@Valid Sucursal Sucursal, BindingResult result, Model model, SessionStatus sStatus) {

        if (result.hasErrors()) {
            model.addAttribute("Btn", "Enviar Sucursal");
            return "SucuReg";
        }

        Response<Sucursal> rspta = InterfaceSucursal.crearSucursal(Sucursal);

        if (rspta.getEstado()) {
            model.addAttribute("Btn", "Editando Sucursal");
            sStatus.setComplete();
            return "redirect:/app/listarsucu";

        } else {
            model.addAttribute("mensaje", rspta.getMensaje());
            model.addAttribute("mensajeError", rspta.getMensajeError());
            return "errores";
        }

    }
}