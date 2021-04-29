package cat.itb.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuari {

    @Id
    private String nomUsuari;

    @NotNull
    @NotEmpty
    private String contrasenya;

    @NotNull
    @NotEmpty
    private String repetirContrasenya;

    @NotNull
    @NotEmpty
    private String rol;

    public Usuari(String nom, String contrasenya, String repetirContrasenya) {
        this.nomUsuari = nom;
        this.contrasenya = contrasenya;
        this.repetirContrasenya = repetirContrasenya;
        this.rol = "USER";
    }
}
