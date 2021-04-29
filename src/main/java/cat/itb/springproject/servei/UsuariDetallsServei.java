package cat.itb.springproject.servei;

import cat.itb.springproject.model.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuariDetallsServei implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsuariServei serveiUsuari;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuari u = serveiUsuari.consultaPerId(s);
        User.UserBuilder builder;
        if (u != null) {
            builder = User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getContrasenya());
            builder.roles(u.getRol());
        } else throw new UsernameNotFoundException("Usuari no trobat");
        return builder.build();
    }

}
