package trainingLibrary.UIAction;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import trainingLibrary.dto.AddUserRequest;
import trainingLibrary.services.UserService;

import java.util.Scanner;

@Order(0)
@Component
@AllArgsConstructor

public class AddUserUIAction implements UIAction{
    private final UserService userService;

    @Override
    public void execute() {
        System.out.println("Please enter username: ");
        var scanner = new Scanner(System.in);
        var username = scanner.nextLine();
        var request = new AddUserRequest();
        request.setUsername(username);

        var result = userService.addUser(request);
        System.out.println("User added: " + result);
    }

    @Override
    public String getActionName() {
        return "Add user";
    }
}
