package org.superheroes_pack;

import com.github.javafaker.Faker;
import org.superheroes_pack.dao_pack.PowerDAO;
import org.superheroes_pack.dao_pack.SuperheroDAO;
import org.superheroes_pack.dao_pack.dao_implementation.PowerDAOImplem;
import org.superheroes_pack.dao_pack.dao_implementation.SuperheroDAOImplem;
import org.superheroes_pack.entity_pack.Enemy;
import org.superheroes_pack.entity_pack.Power;
import org.superheroes_pack.entity_pack.Sidekick;
import org.superheroes_pack.entity_pack.Superhero;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        SuperheroDAO superheroDAO = new SuperheroDAOImplem();
        PowerDAO powerDAO = new PowerDAOImplem();

/**CREATE*/
    //    superheroDAO.insertMultipleSuperheroes(getRandomSuperheroes());
        //     superheroDAO.insertSuperhero(getRandomSuperhero());

        /**READ*/

    //    superheroDAO.getAllSuperheroes().forEach(System.out::println);
        //   System.out.println(superheroDAO.getSuperheroById(4));

/**UPDATE*/
        // superheroDAO.updateSuperhero(getRandomSuperhero());
      //  superheroDAO.updateSuperheroById("New Hero Name", 8);

/**DELETE*/

        superheroDAO.deleteSuperheroById(7);

    }


    private static Set<Power> generateRandomPowers(Superhero superhero) {
        Faker faker = new Faker();
        Random random = new Random();
        Set<Power> powers = new HashSet<>();
        for (int i = 0; i < random.nextInt(8); i++) {
            Power power = new Power(faker.superhero().power(), true);
            power.addSuperheroToPower(superhero);
            powers.add(power);
        }
        return powers;
    }

    private static Set<Sidekick> generateRandomSidekicks(Superhero superhero) {
        Faker faker = new Faker();
        Random random = new Random();
        Set<Sidekick> sidekicks = new HashSet<>();
        for (int i = 0; i < random.nextInt(8); i++) {
            Sidekick sidekick = new Sidekick(faker.name().name(), faker.superhero().power());
            superhero.addSidekickToSuperhero(sidekick);
            sidekicks.add(sidekick);
        }
        return sidekicks;
    }


    private static Superhero getRandomSuperhero() {
        Faker faker = new Faker();
        Superhero superhero = new Superhero();
        superhero.setName(faker.funnyName().name());
        superhero.setHeroName(faker.superhero().name());
        superhero.setEnemy(new Enemy(faker.pokemon().name(), faker.funnyName().name()));
        superhero.setPowers(generateRandomPowers(superhero));
        superhero.setSidekicks(generateRandomSidekicks(superhero));
        return superhero;
    }

    private static List<Superhero> getRandomSuperheroes() {
        return Stream.generate(Main::getRandomSuperhero).limit(25).toList();
    }
}
