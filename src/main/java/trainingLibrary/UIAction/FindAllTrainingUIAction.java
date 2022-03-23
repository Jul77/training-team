package trainingLibrary.UIAction;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import trainingLibrary.services.FindAllTrainingService;

@Order(2)
@Component
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
