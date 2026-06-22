package com.tnf.service;

import com.tnf.entities.Trainee;
import java.util.List;

public interface TraineeService {

    void registerTrainee(Trainee trainee);

    Trainee searchTrainee(int traineeId);

    void updateTrainee(Trainee trainee);

    void deleteTrainee(int traineeId);
    List<Trainee> getAllTrainees();
}
