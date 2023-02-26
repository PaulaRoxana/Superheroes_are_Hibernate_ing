package org.superheroes_pack.entity_pack;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Power extends CommonAttributes {

    private Boolean fatality;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "powers") //MappedBy inseamna ca e non-owning side
    private Set<Superhero> superheroes = new HashSet<>();

    public Power(String name, Boolean fatality) {
        this.name = name;
        this.fatality = fatality;
    }

    public void addSuperheroToPower(Superhero superhero) {
        superheroes.add(superhero);
    }

    public void removeSuperheroFromPower(Superhero superhero) {
        superheroes.remove(superhero);
    }
}
