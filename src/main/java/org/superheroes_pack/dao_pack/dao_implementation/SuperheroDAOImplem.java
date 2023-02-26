package org.superheroes_pack.dao_pack.dao_implementation;

import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.superheroes_pack.dao_pack.EnemyDAO;
import org.superheroes_pack.dao_pack.SuperheroDAO;
import org.superheroes_pack.entity_pack.Superhero;
import org.superheroes_pack.utils_pack.HibernateUtil;

import java.util.List;
import java.util.Optional;

@Log
public class SuperheroDAOImplem implements SuperheroDAO {

    private final SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    private final EnemyDAO enemyDAO = new EnemyDAOImplem();
    public SuperheroDAOImplem() {
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
