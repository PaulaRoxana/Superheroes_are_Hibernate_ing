package org.superheroes_pack.dao_pack;

import org.superheroes_pack.entity_pack.Superhero;

import java.util.List;
import java.util.Optional;

public interface SuperheroDAO {
    void insertSuperhero(Superhero superhero);

    void insertMultipleSuperheroes(List<Superhero> superheroes);

    List<Superhero> getAllSuperheroes();

    Optional<Superhero> getSuperheroById(Integer id);

    void deleteSuperheroById(Integer id);

    void updateSuperhero(Superhero SuperheroFromFrontend);

    void updateSuperheroById(String heroName, Integer id);

    Superhero getSuperheroByIdWithCriteriaBuilder(Integer id);

    Superhero getSuperheroByIdWithHQL(Integer id);
}
