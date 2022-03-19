package trainingLibrary;

import trainingLibrary.UIAction.AddTrainingUIAction;
import trainingLibrary.UIAction.FindAllTrainingUIAction;
import trainingLibrary.UIAction.UIMenu;
import trainingLibrary.repository.ArrayListTrainingRepository;
import trainingLibrary.repository.TrainingRepository;
import trainingLibrary.services.AddTrainingService;
import trainingLibrary.services.FindAllTrainingService;
import trainingLibrary.validation.TrainingChoiceNullValidationRule;
import trainingLibrary.validation.TrainingTrainerNullValidationRule;
import trainingLibrary.validation.ValidationService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingListApplication {
    public static void main(String[] args) {
        var repository = new ArrayListTrainingRepository();

        var validationRules = List.of(
                new TrainingChoiceNullValidationRule(),
                new TrainingTrainerNullValidationRule()
        );
        var validationService = new ValidationService(validationRules);

        var addService = new AddTrainingService(repository, validationService);
        var findAllService = new FindAllTrainingService(repository);

        var actions = Arrays.asList(
                new AddTrainingUIAction(addService),
                new FindAllTrainingUIAction(findAllService)
        );

        UIMenu uiMenu = new UIMenu(actions);
        uiMenu.startUI();
    }

}
