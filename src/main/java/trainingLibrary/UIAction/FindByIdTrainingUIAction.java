package trainingLibrary.UIAction;

import org.springframework.stereotype.Component;
import trainingLibrary.services.GetTrainingByIdService;

import java.util.Scanner;

@Component
public class FindByIdTrainingUIAction implements UIAction{

    private final GetTrainingByIdService getTrainingByIdService;

    public FindByIdTrainingUIAction(GetTrainingByIdService getTrainingByIdService) {
        this.getTrainingByIdService = getTrainingByIdService;
    }

    @Override
    public void execute() {
        System.out.println("Please enter training id:");
        var scanner = new Scanner(System.in);
        var id = scanner.nextInt();
        var result = getTrainingByIdService.getById(id);
        System.out.println("Result: " + result);
    }

    @Override
    public String getActionName() {
        return "Find by ID";
    }
}
