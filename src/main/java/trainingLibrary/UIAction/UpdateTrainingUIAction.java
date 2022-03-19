package trainingLibrary.UIAction;

import trainingLibrary.dto.UpdateTrainingRequest;
import trainingLibrary.services.GetTrainingByIdService;
import trainingLibrary.services.UpdateTrainingService;

import java.util.Scanner;


public class UpdateTrainingUIAction implements UIAction {
    private final GetTrainingByIdService getTrainingByIdService;
    private final UpdateTrainingService updateTrainingService;

    public UpdateTrainingUIAction(GetTrainingByIdService getTrainingByIdService, UpdateTrainingService updateTrainingService) {
        this.getTrainingByIdService = getTrainingByIdService;
        this.updateTrainingService = updateTrainingService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Training id: ");
        var id = Integer.valueOf(scanner.nextLine());
        var foundTrainingResponse = getTrainingByIdService.getById(id);
        var training = foundTrainingResponse.getTrainingDTO();
        var trainingChoice = scanner.nextLine();
        var trainer = scanner.nextLine();

        var updateRequest = new UpdateTrainingRequest();
        updateRequest.setId(training.getId());
        var updatedTrainingChoice = getUpdatedValue(trainingChoice, training.getTrainingChoice());
        var updatedTrainer = getUpdatedValue(trainer, training.getTrainer());

        updateRequest.setTrainingChoice(updatedTrainingChoice);
        updateRequest.setTrainer(updatedTrainer);

        updateTrainingService.update(updateRequest);

    }

    public String getUpdatedValue(String newValue, String oldValue) {
        return newValue.equals("") ? oldValue : newValue;

    }

    @Override
    public String getActionName() {
        return "Update Training";
    }

}
