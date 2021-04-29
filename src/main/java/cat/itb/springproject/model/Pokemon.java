package cat.itb.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pokemon {

    @Id
    private String nomPokemon;

    @NotNull
    @NotEmpty
    private int numPokemon;

    @NotNull
    @NotEmpty
    private String tipusPokemon;

    @NotNull
    @NotEmpty
    private String descripcioPokemon;
}
