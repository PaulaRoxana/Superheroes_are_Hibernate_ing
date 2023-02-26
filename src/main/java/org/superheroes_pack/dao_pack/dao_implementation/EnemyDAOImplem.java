package org.superheroes_pack.dao_pack.dao_implementation;

import org.superheroes_pack.dao_pack.EnemyDAO;
import org.superheroes_pack.entity_pack.Enemy;

import java.util.List;
import java.util.Optional;

public class EnemyDAOImplem implements EnemyDAO {
    @Override
    public void insertEnemy(Enemy enemy) {

    }

    @Override
    public void insertMultipleEnemies(List<Enemy> enemies) {

    }

    @Override
    public List<Enemy> getAllEnemies() {
        return null;
    }

    @Override
    public Optional<Enemy> getEnemyById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteEnemyById(Integer id) {

    }

    @Override
    public void updateEnemy(Enemy EnemyFromFrontend) {

    }

    @Override
    public Enemy getEnemyByIdWithCriteriaBuilder(Integer id) {
        return null;
    }

    @Override
    public Enemy getEnemyByIdWithHQL(Integer id) {
        return null;
    }
}
