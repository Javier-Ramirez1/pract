package com.prac.demo.controller;

import com.prac.demo.model.Usuario;
import com.prac.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(
            @RequestParam String codusuario,
            @RequestParam String pass,
            Model model) {

        Usuario usuario = usuarioRepository.findByCodusuarioAndPass(codusuario, pass);

        if (usuario != null) {
            return "redirect:/bienvenido";
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }

    @GetMapping("/bienvenido")
    public String bienvenido() {
        return "bienvenido";
    }
}