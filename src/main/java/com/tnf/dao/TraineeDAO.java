package com.tnf.dao;

import com.tnf.entities.Trainee;

public interface TraineeDAO {

    void registerTrainee(Trainee trainee);

    Trainee searchTrainee(int traineeId);

    void updateTrainee(Trainee trainee);

    void deleteTrainee(int traineeId);
}
