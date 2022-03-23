package trainingLibrary.UIAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import trainingLibrary.services.AddTrainingService;
import trainingLibrary.dto.AddTrainingRequest;

import java.util.Scanner;

@Order(1)
@Component
public class AddTrainingUIAction implements UIAction {
    private final AddTrainingService addTrainingService;

    @Autowired
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

        var request = new AddTrainingRequest();
        request.setTrainingChoice(trainingChoice);
        request.setTrainer(trainer);

        var response = addTrainingService.add(request);
        System.out.println("Received response: " + response);


    }

    @Override
    public String getActionName() {
        return "Add Training";
    }
}
