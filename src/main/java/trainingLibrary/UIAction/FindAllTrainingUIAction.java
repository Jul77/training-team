package trainingLibrary.UIAction;

import trainingLibrary.services.FindAllTrainingService;

public class FindAllTrainingUIAction implements UIAction{
    private final FindAllTrainingService findAllTrainingService;

    public FindAllTrainingUIAction(FindAllTrainingService findAllTrainingService) {
        this.findAllTrainingService = findAllTrainingService;
    }

    @Override
    public void execute() {
        var response = findAllTrainingService.findAll();
        System.out.println(response);

    }

    @Override
    public String getActionName() {
        return "Find all";
    }
}
