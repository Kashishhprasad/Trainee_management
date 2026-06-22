package com.tnf.dao;

import com.tnf.entities.Trainee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class TraineeDAOImpl implements TraineeDAO {

    // No separate util package in this structure, so the SessionFactory
    // is built right here. If Trainer/Batch/Feedback DAOs need the same
    // factory, this is the place to make it shared later.
    private static final SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    @Override
    public void registerTrainee(Trainee trainee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(trainee);
        tx.commit();
        session.close();
    }

    @Override
    public Trainee searchTrainee(int traineeId) {
        Session session = sessionFactory.openSession();
        Trainee trainee = session.get(Trainee.class, traineeId);
        session.close();
        return trainee;
    }

    @Override
    public void updateTrainee(Trainee trainee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(trainee);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteTrainee(int traineeId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Trainee trainee = session.get(Trainee.class, traineeId);
        if (trainee != null) {
            session.delete(trainee);
        }
        tx.commit();
        session.close();
    }
    @Override
    public List<Trainee> getAllTrainees() {
        Session session = sessionFactory.openSession();
        List<Trainee> trainees = session.createQuery("from Trainee", Trainee.class).list();
        session.close();
        return trainees;
    }
}
