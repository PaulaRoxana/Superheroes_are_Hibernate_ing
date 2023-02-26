package org.superheroes_pack.dao_pack.dao_implementation;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.superheroes_pack.dao_pack.PowerDAO;
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

    //  private final EnemyDAO enemyDAO = new EnemyDAOImplem();

    private final PowerDAO powerDAO = new PowerDAOImplem();

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
        openSessionAndTransaction();
        try {
            session.persist(superhero);
            commitTransactionAndCloseSession();
        } catch (Exception e) {
            log.severe("Could not save superhero. Duplicate superhero");
            //transaction.rollback();
            closeSession();
        }
    }

    @Override
    public void insertMultipleSuperheroes(List<Superhero> superheroes) {
        for (Superhero superhero : superheroes) {
            insertSuperhero(superhero);
        }
    }

    @Override
    public List<Superhero> getAllSuperheroes() {
        openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Superhero> getAllSuperheroesQuery = criteriaBuilder.createQuery(Superhero.class);
        getAllSuperheroesQuery.from(Superhero.class);
        List<Superhero> superheroList = session.createQuery(getAllSuperheroesQuery).getResultList();
        closeSession();
        return superheroList;
    }

    @Override
    public Optional<Superhero> getSuperheroById(Integer id) {
        openSession();
        Optional<Superhero> superhero = Optional.ofNullable(session.find(Superhero.class, id));
        closeSession();
        return superhero;
    }

    @Override
    public void deleteSuperheroById(Integer id) {
        Optional<Superhero> optionalSuperhero = getSuperheroById(id);
        if (optionalSuperhero.isPresent()) {
            openSessionAndTransaction();
            session.remove(optionalSuperhero.get());
            commitTransactionAndCloseSession();
        } else
            log.info("Cannot find instance with id=" + id);
    }

    @Override
    public void updateSuperhero(Superhero receivedSuperhero) {
        openSessionAndTransaction();
        session.merge(receivedSuperhero);
        commitTransactionAndCloseSession();

    }

    @Override
    public void updateSuperheroById(String newHeroName, Integer id) {
        openSessionAndTransaction();
        try {
            Superhero superhero=new Superhero();
            superhero.setId(id);
            superhero.setHeroName(newHeroName);
            session.merge(superhero);
            commitTransactionAndCloseSession();
        } catch (Exception e) {
            log.severe("Could not update superhero. Did not find the id");
            transaction.rollback();
            closeSession();
        }

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
