package org.superheroes_pack.dao_pack;

import org.superheroes_pack.entity_pack.Enemy;

import java.util.List;
import java.util.Optional;

public interface EnemyDAO {
    void insertEnemy(Enemy enemy);
    void insertMultipleEnemies(List<Enemy> enemies);

    List<Enemy> getAllEnemies();

    Optional<Enemy> getEnemyById(Integer id);

    void deleteEnemyById(Integer id);

    void updateEnemy(Enemy EnemyFromFrontend);

    Enemy getEnemyByIdWithCriteriaBuilder(Integer id);

    Enemy getEnemyByIdWithHQL(Integer id);
}
