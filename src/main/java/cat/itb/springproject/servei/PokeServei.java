package cat.itb.springproject.servei;

import cat.itb.springproject.model.Pokemon;
import cat.itb.springproject.model.repositori.PokemonRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PokeServei {

    @Autowired
    private PokemonRepositori repositoriPokemon;

    public void nou(Pokemon p) {
        repositoriPokemon.save(p);
    }
    public List<Pokemon> llistatPokemon() {
        return (List<Pokemon>) repositoriPokemon.findAll();
    }


    @PostConstruct
    public void init() {
        repositoriPokemon.save(new Pokemon("Pikachu", 25, "Electric", "Pikachu es un Pokemon de tipus Electric introduit a la primera generacio"));

//        repositoriPokemon.saveAll(
//                Arrays.asList(
//                        new Pokemon("Pikachu", 25, "Electric", "Pikachu es un Pokemon de tipus Electric introduit a la primera generacio"),
//                        new Pokemon("Gyarados", 130, "Aigua / Volador", "Gyarados es un Pokemon tipus Aigua / Volador introduit a la primera generacio"),
//                        new Pokemon("Jigglypuff", 39, "Normal / Fada", "Jigglypuff es un Pokemon de tipus Normal / Fada introduit a la primera generacio")
//                ));
    }


    public Pokemon consultaNom(String s) {
        return repositoriPokemon.findById(s).orElse(null);
    }

    public void eliminarPokemonNom(String s) {
        Pokemon p = consultaNom(s);
        repositoriPokemon.delete(p);
    }

    public void updatePokemon(Pokemon p, String nom) {
        Pokemon pok = consultaNom(nom);
        repositoriPokemon.delete(pok);
        repositoriPokemon.save(p);
    }
}
