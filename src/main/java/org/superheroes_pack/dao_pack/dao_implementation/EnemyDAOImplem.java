package org.superheroes_pack.dao_pack.dao_implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.superheroes_pack.dao_pack.EnemyDAO;
import org.superheroes_pack.entity_pack.Enemy;
import org.superheroes_pack.utils_pack.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class EnemyDAOImplem implements EnemyDAO {


    private final SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public EnemyDAOImplem() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    private void openSessionAndTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    private void openSession() {
        session = sessionFactory.openSession();
    }

    private void commitTransactionAndCloseSession() {
        transaction.commit();
        session.close();
    }

    private void closeSession() {
        session.close();
    }




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
