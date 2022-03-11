package trainingLibrary;

import trainingLibrary.UIAction.AddTrainingUIAction;
import trainingLibrary.UIAction.FindAllTrainingUIAction;
import trainingLibrary.UIAction.UIMenu;
import trainingLibrary.repository.ArrayListTrainingRepository;
import trainingLibrary.repository.TrainingRepository;
import trainingLibrary.services.AddTrainingService;
import trainingLibrary.services.FindAllTrainingService;

import java.util.Arrays;

public class TrainingListApplication {
    public static void main(String[] args) {
       TrainingRepository repository = new ArrayListTrainingRepository();
        var addService = new AddTrainingService(repository);
        var findAllService = new FindAllTrainingService(repository);
        var actions = Arrays.asList(
                new AddTrainingUIAction(addService),
                new FindAllTrainingUIAction(findAllService)
        );

        UIMenu uiMenu = new UIMenu(actions);
        uiMenu.startUI();
    }

}
