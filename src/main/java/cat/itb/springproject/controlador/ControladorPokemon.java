package cat.itb.springproject.controlador;

import cat.itb.springproject.model.Pokemon;
import cat.itb.springproject.servei.PokeServei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorPokemon {

    String nom;

    @Autowired
    private PokeServei serveiPokemon;

    @GetMapping("/")
    public String inici(Model m) {
        m.addAttribute("llistaPokemon", serveiPokemon.llistatPokemon());
        m.addAttribute("Pokemon", new Pokemon());
        return "home";
    }

    @GetMapping("/home")
    public String llistarPokemon(Model m) {
        m.addAttribute("llistaPokemon", serveiPokemon.llistatPokemon());
        m.addAttribute("Pokemon", new Pokemon());
        return "home";
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.POST)
    public String borrarPokemon(@PathVariable("name") String pokemon) {
        serveiPokemon.eliminarPokemonNom(pokemon);
        return "redirect:/";
    }

    @RequestMapping("/afegir")
    public String afegir(Model m) {
        m.addAttribute("Pokemon", new Pokemon());
        return "afegirPokemon";
    }

    @PostMapping("/afegirPokemon")
    public String nouPokemon(@ModelAttribute("Pokemon") Pokemon p) {
        serveiPokemon.nou(p);
        return "redirect:/";
    }

    @RequestMapping(value = "/update/{name}", method = RequestMethod.POST)
    public String updatePokemon(@PathVariable("name") String pokemon, Model m) {
        nom = pokemon;
        m.addAttribute("Pokemon", serveiPokemon.consultaNom(pokemon));
        return "editarPokemon";
    }

    @PostMapping("/editarPokemon")
    public String updatePokemonAbans(@ModelAttribute("Pokemon") Pokemon p) {
        serveiPokemon.updatePokemon(p, nom);
        return "redirect:/";
    }
}
