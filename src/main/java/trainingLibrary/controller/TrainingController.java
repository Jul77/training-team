package trainingLibrary.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import trainingLibrary.dto.*;
import trainingLibrary.services.AddTrainingService;
import trainingLibrary.services.FindAllTrainingService;
import trainingLibrary.services.GetTrainingByIdService;
import trainingLibrary.services.UpdateTrainingService;

@Slf4j
@RestController
@AllArgsConstructor
public class TrainingController {
    private final FindAllTrainingService findAllTrainingService;
    private final GetTrainingByIdService getTrainingByIdService;
    private final AddTrainingService addTrainingService;
    private final UpdateTrainingService updateTrainingService;

    @GetMapping("/trainings")
    public FindAllTrainingResponse findAll() {
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

    @PutMapping("/trainings")
    public void update (@RequestBody UpdateTrainingRequest request) {
        updateTrainingService.update(request);
    }
}
