package com.tnf.controller;

import com.tnf.entities.Trainee;
import com.tnf.service.TraineeService;
import com.tnf.service.TraineeServiceImpl;
import java.util.List;

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

        List<Trainee> allTrainees = controller.traineeService.getAllTrainees();
        System.out.println("All Trainees:");
        for (Trainee t : allTrainees) {
            System.out.println("ID: " + t.getTraineeId()
                    + " | Name: " + t.getName()
                    + " | Email: " + t.getEmail()
                    + " | Mobile: " + t.getMobile());
        }
    }
}
