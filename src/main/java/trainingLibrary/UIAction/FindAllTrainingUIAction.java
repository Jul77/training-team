package trainingLibrary.UIAction;

import trainingLibrary.services.FindAllTrainingService;

public class FindAllTrainingUIAction implements UIAction{
    private final FindAllTrainingService findAllTrainingService;

    public FindAllTrainingUIAction(FindAllTrainingService findAllTrainingService) {
        this.findAllTrainingService = findAllTrainingService;
    }

    @Override
    public void execute() {
       findAllTrainingService.findAll().forEach(System.out::println);

    }

    @Override
    public String getActionName() {
        return "Find all";
    }
}
