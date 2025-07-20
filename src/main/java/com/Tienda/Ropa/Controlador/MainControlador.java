package com.Tienda.Ropa.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlador {

    @GetMapping({"", "/"})
    public String Inicio() {
        return "index";
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }

    @GetMapping("/catalogo")
    public String catalogo() {
        return "catalogo";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/inicioCliente")
    public String inicioCliente() {
        return "inicioCliente";
    }

    @GetMapping("/intranet")
    public String intranet() {
        return "Intranet";
    }
}
