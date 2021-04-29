package cat.itb.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Pokemon {

    @Id
    private String nomPokemon;

    private int numPokemon;

    private String tipusPokemon;

    private String descripcioPokemon;

    public Pokemon(String nomPokemon, int numPokemon, String tipusPokemon, String descripcioPokemon) {
        this.nomPokemon = nomPokemon;
        this.numPokemon = numPokemon;
        this.tipusPokemon = tipusPokemon;
        this.descripcioPokemon = descripcioPokemon;
    }

    public Pokemon() {
    }

    public String getNomPokemon() {
        return nomPokemon;
    }

    public void setNomPokemon(String nomPokemon) {
        this.nomPokemon = nomPokemon;
    }

    public int getNumPokemon() {
        return numPokemon;
    }

    public void setNumPokemon(int numPokemon) {
        this.numPokemon = numPokemon;
    }

    public String getTipusPokemon() {
        return tipusPokemon;
    }

    public void setTipusPokemon(String tipusPokemon) {
        this.tipusPokemon = tipusPokemon;
    }

    public String getDescripcioPokemon() {
        return descripcioPokemon;
    }

    public void setDescripcioPokemon(String descripcioPokemon) {
        this.descripcioPokemon = descripcioPokemon;
    }
}
