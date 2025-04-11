package com.example.tareals.controller;

import com.example.tareals.model.User;
import com.example.tareals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador que maneja las solicitudes relacionadas con el inicio de sesión.
 */
@Controller
public class LoginController {

    private final UserService userService;

    /**
     * Constructor que inyecta el servicio de usuarios.
     *
     * @param userService Servicio para gestionar usuarios
     */
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Maneja las solicitudes GET a la URL "/inicio".
     * Muestra el formulario de inicio de sesión.
     *
     * @param model Modelo para pasar datos a la vista
     * @return Nombre de la vista a renderizar
     */
    @GetMapping("/inicio")
    public String showLoginForm(Model model) {
        // Si el modelo no tiene un usuario, agregamos uno nuevo
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "login";
    }

    /**
     * Maneja las solicitudes POST a la URL "/inicio".
     * Procesa el inicio de sesión y redirige según el resultado.
     *
     * @param user Usuario con las credenciales enviadas
     * @param redirectAttributes Atributos para redirección
     * @return Redirección a la página correspondiente
     */
    @PostMapping("/inicio")
    public String processLogin(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        // Validamos las credenciales del usuario
        if (userService.validateUser(user)) {
            // Inicio de sesión exitoso, redirigimos a la página de inicio
            redirectAttributes.addFlashAttribute("username", user.getUsername());
            return "redirect:/home";
        } else {
            // Inicio de sesión fallido, volvemos al formulario con un mensaje de error
            redirectAttributes.addFlashAttribute("error", "Usuario o contraseña incorrectos");
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/inicio";
        }
    }

    /**
     * Maneja las solicitudes GET a la URL "/home".
     * Muestra la página de inicio después de un inicio de sesión exitoso.
     *
     * @param model Modelo para pasar datos a la vista
     * @return Nombre de la vista a renderizar
     */
    @GetMapping("/home")
    public String showHomePage(Model model) {
        // Verificamos si el usuario está autenticado
        if (!model.containsAttribute("username")) {
            // Si no hay nombre de usuario en el modelo, redirigimos al inicio de sesión
            return "redirect:/inicio";
        }
        return "home";
    }
}