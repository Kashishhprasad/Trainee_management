package com.tnf.controller;

import com.tnf.entities.Trainee;
import com.tnf.service.TraineeService;
import com.tnf.service.TraineeServiceImpl;

// Plain entry point for now - calls the service layer directly.
// This is the class that turns into a Spring @Controller later.
public class TraineeController {

    private TraineeService traineeService = new TraineeServiceImpl();

    public static void main(String[] args) {
        TraineeController controller = new TraineeController();

        Trainee trainee = new Trainee();
        trainee.setName("Ravi Kumar");
        trainee.setEmail("ravi.kumar@example.com");
        trainee.setMobile("9876543210");

        controller.traineeService.registerTrainee(trainee);

        Trainee fetched = controller.traineeService.searchTrainee(trainee.getTraineeId());
        System.out.println("Registered Trainee: " + fetched.getName());
    }
}
