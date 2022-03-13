package trainingLibrary.services;

import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.repository.TrainingRepository;
import trainingLibrary.validation.ValidationService;
import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.dto.AddTrainingResponse;

public class AddTrainingService {
    private final TrainingRepository repository;
    private final ValidationService validationService;

    public AddTrainingService(TrainingRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddTrainingResponse add(AddTrainingRequest request) {
        System.out.println("Received request: " + request);
        var entity = convert(request);
        var validationResult = validationService.validation(entity);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddTrainingResponse();
            response.setErrors(validationResult);
            return response;

        }
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved " + createdEntity);
        var response = new AddTrainingResponse();
        response.getCreateTrainingId(createdEntity.getId());
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