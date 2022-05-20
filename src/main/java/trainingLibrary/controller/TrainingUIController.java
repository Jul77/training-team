package trainingLibrary.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.services.AddTrainingService;
import trainingLibrary.services.FindAllTrainingService;

@Controller
@AllArgsConstructor
@RequestMapping("/ui")
class TrainingUIController {

    private final FindAllTrainingService findAllTrainingService;
    private final AddTrainingService addTrainingService;

    @GetMapping("/findAllTrainings")
    public String findAllTraining(Model model) {
        var response = findAllTrainingService.findAll();
        model.addAttribute("trainings", response);
        return "findAllTrainings";
    }

    @GetMapping("/addTraining")
    public String addTrainingView(Model model) {
        model.addAttribute("training", new AddTrainingRequest());
        return "addTraining";
    }

    @PostMapping("/addTraining")
    public String addTraining(@ModelAttribute AddTrainingRequest training) {
        addTrainingService.add(training);
        return "redirect:/ui/findAllTrainings";
    }
}
