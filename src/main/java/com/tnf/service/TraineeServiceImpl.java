package com.tnf.service;

import com.tnf.dao.TraineeDAO;
import com.tnf.dao.TraineeDAOImpl;
import com.tnf.entities.Trainee;
import java.util.List;

public class TraineeServiceImpl implements TraineeService {

    private TraineeDAO traineeDAO = new TraineeDAOImpl();

    @Override
    public void registerTrainee(Trainee trainee) {
        traineeDAO.registerTrainee(trainee);
    }

    @Override
    public Trainee searchTrainee(int traineeId) {
        return traineeDAO.searchTrainee(traineeId);
    }

    @Override
    public void updateTrainee(Trainee trainee) {
        traineeDAO.updateTrainee(trainee);
    }

    @Override
    public void deleteTrainee(int traineeId) {
        traineeDAO.deleteTrainee(traineeId);
    }
    @Override
    public List<Trainee> getAllTrainees() {
        return traineeDAO.getAllTrainees();
    }
}
