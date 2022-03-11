package trainingLibrary.UIAction;

import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.services.AddTrainingService;

import java.util.Scanner;

public class AddTrainingUIAction implements UIAction {
    private final AddTrainingService addTrainingService;

    public AddTrainingUIAction(AddTrainingService addTrainingService) {
        this.addTrainingService = addTrainingService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter training choice: ");
        String trainingChoice = scanner.nextLine();
        System.out.println("Please enter training trainer: ");
        String trainer = scanner.nextLine();

        TrainingEntity entity = new TrainingEntity();
        entity.setTrainingChoice(trainingChoice);
        entity.setTrainer(trainer);

        addTrainingService.add(entity);

    }

    @Override
    public String getActionName() {
        return "Add ";
    }
}
