package com.tnf.dao;
import java.util.List;

import com.tnf.entities.Trainee;

public interface TraineeDAO {

    void registerTrainee(Trainee trainee);

    Trainee searchTrainee(int traineeId);

    void updateTrainee(Trainee trainee);

    void deleteTrainee(int traineeId);

    List<Trainee> getAllTrainees();
}
