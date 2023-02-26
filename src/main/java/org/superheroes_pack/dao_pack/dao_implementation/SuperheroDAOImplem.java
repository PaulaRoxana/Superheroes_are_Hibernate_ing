package org.superheroes_pack.dao_pack.dao_implementation;

import org.superheroes_pack.dao_pack.SuperheroDAO;
import org.superheroes_pack.entity_pack.Superhero;

import java.util.List;
import java.util.Optional;

public class SuperheroDAOImplem implements SuperheroDAO {
    @Override
    public void insertSuperhero(Superhero superhero) {

    }

    @Override
    public void insertMultipleSuperheroes(List<Superhero> superheroes) {

    }

    @Override
    public List<Superhero> getAllSuperheroes() {
        return null;
    }

    @Override
    public Optional<Superhero> getSuperheroById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteSuperheroById(Integer id) {

    }

    @Override
    public void updateSuperhero(Superhero SuperheroFromFrontend) {

    }

    @Override
    public Superhero getSuperheroByIdWithCriteriaBuilder(Integer id) {
        return null;
    }

    @Override
    public Superhero getSuperheroByIdWithHQL(Integer id) {
        return null;
    }
}
