package com.prac.demo.controller;


import com.prac.demo.model.Usuario;
import com.prac.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public String validarLogin(
            @RequestParam String codusuario,
            @RequestParam String pass,
            Model model) {

        Usuario usuario = usuarioRepository.findByCodusuario(codusuario);

        if (usuario != null && usuario.getPass().equals(pass)) {
            return "redirect:/bienvenido";
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "login";
    }
}