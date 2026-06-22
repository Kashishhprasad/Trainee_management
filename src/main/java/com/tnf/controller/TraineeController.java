package com.tnf.controller;

import java.util.List;
import java.util.Scanner;

import com.tnf.entities.Batch;
import com.tnf.entities.Trainee;
import com.tnf.service.TraineeService;
import com.tnf.service.TraineeServiceImpl;

// Plain entry point for now - menu driven, calls the service layer directly.
// This is the class that turns into a Spring @Controller later.
public class TraineeController {

    private static final TraineeService traineeService = new TraineeServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Trainee Management =====");
            System.out.println("1. Add Trainee");
            System.out.println("2. Search Trainee");
            System.out.println("3. Update Trainee");
            System.out.println("4. Delete Trainee");
            System.out.println("5. View All Trainees");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    addTrainee();
                    break;
                case 2:
                    searchTrainee();
                    break;
                case 3:
                    updateTrainee();
                    break;
                case 4:
                    deleteTrainee();
                    break;
                case 5:
                    viewAllTrainees();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addTrainee() {
        Trainee trainee = new Trainee();

        System.out.print("Enter Trainee Name: ");
        trainee.setName(scanner.nextLine().trim());

        System.out.print("Enter Email: ");
        trainee.setEmail(scanner.nextLine().trim());

        System.out.print("Enter Mobile: ");
        trainee.setMobile(scanner.nextLine().trim());

        trainee.setBatch(readBatch());

        traineeService.registerTrainee(trainee);
        System.out.println("Trainee added successfully with Id: " + trainee.getTraineeId());
    }

    private static void searchTrainee() {
        System.out.print("Enter Trainee Id: ");
        int id = readInt();
        Trainee trainee = traineeService.searchTrainee(id);
        if (trainee != null) {
            printTrainee(trainee);
        } else {
            System.out.println("No trainee found with Id: " + id);
        }
    }

    private static void updateTrainee() {
        System.out.print("Enter Trainee Id to update: ");
        int id = readInt();
        Trainee trainee = traineeService.searchTrainee(id);
        if (trainee == null) {
            System.out.println("No trainee found with Id: " + id);
            return;
        }

        System.out.print("Enter Trainee Name: ");
        trainee.setName(scanner.nextLine().trim());

        System.out.print("Enter Email: ");
        trainee.setEmail(scanner.nextLine().trim());

        System.out.print("Enter Mobile: ");
        trainee.setMobile(scanner.nextLine().trim());

        trainee.setBatch(readBatch());

        traineeService.updateTrainee(trainee);
        System.out.println("Trainee updated successfully.");
    }

    private static void deleteTrainee() {
        System.out.print("Enter Trainee Id to delete: ");
        int id = readInt();
        traineeService.deleteTrainee(id);
        System.out.println("Trainee deleted (if existed) with Id: " + id);
    }

    private static void viewAllTrainees() {
        List<Trainee> trainees = traineeService.getAllTrainees();
        if (trainees == null || trainees.isEmpty()) {
            System.out.println("No trainees found.");
            return;
        }
        for (Trainee trainee : trainees) {
            System.out.println("-----------------------------");
            printTrainee(trainee);
        }
    }

    // Batch is an optional FK - blank input leaves the trainee unassigned.
    private static Batch readBatch() {
        System.out.print("Enter Batch Id (leave blank for none): ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return null;
        }
        try {
            Batch batch = new Batch();
            batch.setBatchId(Integer.parseInt(input));
            return batch;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Batch Id, skipping batch assignment.");
            return null;
        }
    }

    private static void printTrainee(Trainee trainee) {
        System.out.println("Id: " + trainee.getTraineeId());
        System.out.println("Name: " + trainee.getName());
        System.out.println("Email: " + trainee.getEmail());
        System.out.println("Mobile: " + trainee.getMobile());
        if (trainee.getBatch() != null) {
            System.out.println("Batch Id: " + trainee.getBatch().getBatchId());
        }
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, please enter again: ");
            }
        }
    }
}
