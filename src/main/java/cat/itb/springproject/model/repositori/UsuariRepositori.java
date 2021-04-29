package cat.itb.springproject.model.repositori;

import cat.itb.springproject.model.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface UsuariRepositori extends CrudRepository<Usuari,String> {
}