package trainingLibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.repository.TrainingRepository;
import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.dto.AddTrainingResponse;

@Service
public class AddTrainingService {
    private final TrainingRepository repository;
    private final ValidationService validationService;
@Autowired
    public AddTrainingService(TrainingRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddTrainingResponse add(AddTrainingRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddTrainingResponse();
            response.setErrors(validationResult);
            return response;

        }
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved " + createdEntity );
        var response = new AddTrainingResponse();
        System.out.println("Successfully saved: " + entity);
        response.getCreateTrainingId();
        System.out.println("Sending response " + response);
        return response;

    }

    private TrainingEntity convert(AddTrainingRequest request) {
        TrainingEntity entity = new TrainingEntity();
        entity.setTrainingChoice(request.getTrainingChoice());
        entity.setTrainer(request.getTrainer());
        return entity;

    }
}