package org.superheroes_pack.dao_pack.dao_implementation;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.superheroes_pack.dao_pack.PowerDAO;
import org.superheroes_pack.entity_pack.Power;
import org.superheroes_pack.utils_pack.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class PowerDAOImplem implements PowerDAO {
    private final SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;


    public PowerDAOImplem() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
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
    public Power insertPower(Power power) {
        openSessionAndTransaction();
        Power persistedPower = session.merge(power);
        commitTransactionAndCloseSession();
        return persistedPower;
    }

    @Override
    public void insertMultiplePowers(List<Power> powers) {
        for (Power power:powers) {
            insertPower(power);
        }
    }

    @Override
    public List<Power> getAllPowers() {
        openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Power> getAllPowersQuery = criteriaBuilder.createQuery(Power.class);
        getAllPowersQuery.from(Power.class);
        List<Power> powerList = session.createQuery(getAllPowersQuery).getResultList();
        closeSession();
        return powerList;
    }

    @Override
    public Optional<Power> getPowerById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deletePowerById(Integer id) {

    }

    @Override
    public void updatePower(Power powerFromFrontend) {

    }

    @Override
    public Power getPowerByIdWithCriteriaBuilder(Integer id) {
        return null;
    }

    @Override
    public Power getPowerByIdWithHQL(Integer id) {
        return null;
    }
}
