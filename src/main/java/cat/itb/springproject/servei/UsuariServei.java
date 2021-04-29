package cat.itb.springproject.servei;

import cat.itb.springproject.model.Usuari;
import cat.itb.springproject.model.repositori.UsuariRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class UsuariServei {

    @Autowired
    private UsuariRepositori repo;

    public void nou(Usuari u) {
        u.setContrasenya(passwordEncoder(u.getContrasenya()));
        repo.save(u);
    }

    @PostConstruct
    public void init() {
        repo.save(new Usuari("ADMIN", passwordEncoder("ADMIN"), "ADMIN", "ADMIN"));
        repo.save(new Usuari("USER", passwordEncoder("USER"), "USER", "USER"));
//                Arrays.asList(
//                        new Usuari("Roger", passwordEncoder("roger123"), "roger123", "USER"),
//                        new Usuari("Montse", passwordEncoder("montseprogramacio"), "montseprogramacio", "USER"),
//                        new Usuari("Lario", passwordEncoder("lario321"), "lario321", "USER"),
//                        new Usuari("ADMIN", passwordEncoder("ADMIN"), "ADMIN", "ADMIN")
//                ));
    }

    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }

    public Usuari consultaPerId(String s) {
        return repo.findById(s).orElse(null);
    }

}
