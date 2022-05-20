package trainingLibrary.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trainingLibrary.dto.*;
import trainingLibrary.services.AddTrainingService;
import trainingLibrary.services.FindAllTrainingService;
import trainingLibrary.services.GetTrainingByIdService;
import trainingLibrary.services.UpdateTrainingService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class TrainingController {
    private final FindAllTrainingService findAllTrainingService;
    private final GetTrainingByIdService getTrainingByIdService;
    private final AddTrainingService addTrainingService;
    private final UpdateTrainingService updateTrainingService;

    @GetMapping("/trainings")
    public List<TrainingDTO> findAll(@RequestParam(required = false) String trainingChoice,
                                     @RequestParam(required = false) String trainer,
                                     @RequestParam(required = false) String userName
    ) {
        if (trainingChoice != null || trainer != null) {
            return findAllTrainingService.findAllBy(trainingChoice, trainer);
        }
        if (userName != null){
            return findAllTrainingService.findAllByUserName(userName);
        }
        return findAllTrainingService.findAll();
    }

    @GetMapping("/trainings/{id}")
    public GetByIdTrainingResponse findById(@PathVariable("id") Integer id) {
        return getTrainingByIdService.getById(id);
    }

    @PostMapping("/trainings")
    public AddTrainingResponse add(@RequestBody AddTrainingRequest request) {
        return addTrainingService.add(request);
    }

    @PutMapping("/trainings/{id}")
    public void update(@PathVariable("id") Integer id,
                       @RequestBody UpdateTrainingRequest request) {
        updateTrainingService.update(request);
    }
}
