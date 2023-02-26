package org.superheroes_pack.dao_pack;

import org.superheroes_pack.entity_pack.Power;
import java.util.List;
import java.util.Optional;

public interface PowerDAO {

    Power insertPower(Power Power);

    void insertMultiplePowers(List<Power> powers);

    List<Power> getAllPowers();

    Optional<Power> getPowerById(Integer id);

    void deletePowerById(Integer id);

    void updatePower(Power powerFromFrontend);

    Power getPowerByIdWithCriteriaBuilder(Integer id);

    Power getPowerByIdWithHQL(Integer id);
}
