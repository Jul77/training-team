package trainingLibrary.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.dto.AddUserRequest;
import trainingLibrary.services.UserService;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
class UserUIController {

    private final UserService userService;

    @GetMapping("/users")
    public String findAllUsers(Model model) {

        return "users";
    }

    @GetMapping("/addUser")
    public String addUserView(Model model) {
        model.addAttribute("user", new AddUserRequest());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute AddUserRequest user) {
        userService.addUser(user);
        return "redirect:/ui/users";
    }
}
