package cat.itb.springproject.controlador;

import cat.itb.springproject.model.Usuari;
import cat.itb.springproject.servei.UsuariServei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ControladorUsuari {

    @Autowired
    private UsuariServei serveiUsuari;

    @GetMapping("/registrar")
    public String showRegistrationForm(WebRequest request, Model m) {
        m.addAttribute("usuari", new Usuari());
        return "register";
    }

    @PostMapping("/registrar")
    public String nouSubmit(@ModelAttribute("usuari") Usuari u) {
        u.setRol("USER");
        serveiUsuari.nou(u);
        return "redirect:/list";
    }
}
