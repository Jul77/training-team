package trainingLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainingListApplication {
    public static void main(String[] args) {
        List<Training> trainings = new ArrayList<>();
        while (true) {
            printTrainingMenu();
            int menuNumber = getMenuNumberFromUser();
            executeSelectedMenu(trainings, menuNumber);
        }
    }

    private static void printTrainingMenu() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Add training to list");
        System.out.println("2. Delete training from list");
        System.out.println("3. Show all training in the list");
        System.out.println("4. Exit");
        System.out.println();
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void executeSelectedMenu(List<Training> trainings, int selectedMenu) {
        switch (selectedMenu) {
            case 1: {
                addNewTrainingAction(trainings);
                break;
            }
            case 2: {
                removeTrainingAction(trainings);
                break;
            }
            case 3: {
                printAllTrainingsAction(trainings);
                break;
            }
            case 4: {
                exitProgramAction(trainings);
                break;
            }
        }
    }

    private static void printAllTrainingsAction(List<Training> trainings) {
        System.out.println("Training list: ");
        for (Training training : trainings) {
            System.out.println(training);
        }
        System.out.println("Training list end.");
    }

    private static void removeTrainingAction(List<Training> trainings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name : ");
        String name = scanner.nextLine();
        System.out.println("Enter trainingChoice : ");
        String trainingChoice = scanner.nextLine();
        Training training = new Training(name, trainingChoice);
        trainings.add(training);
        System.out.println("Your training was remove.");
    }

    private static void addNewTrainingAction(List<Training> trainings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name : ");
        String name = scanner.nextLine();
        System.out.println("Enter trainingChoice : ");
        String trainingChoice = scanner.nextLine();
        Training training = new Training(name, trainingChoice);
        trainings.add(training);
        System.out.println("Your training was added to list.");

    }

    private static void exitProgramAction(List<Training> trainings) {
        System.out.println("Good by!");
        System.exit(0);
    }

}
