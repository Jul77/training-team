package trainingLibrary.services;

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
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddTrainingResponse();
            response.setErrors(validationResult);
            return response;

        }
        var entity = convert(request);
        var createdEntity = repository.save(request);
        System.out.println("Successfully saved " + createdEntity );
        var response = new AddTrainingResponse();
        System.out.println("Successfully saved: " + entity);
        response.getCreateTrainingId();
        System.out.println("Sending response " + response);
        return response;

    }

    private AddTrainingRequest convert(AddTrainingRequest request) {
        AddTrainingRequest addTrainingRequest = new AddTrainingRequest();
        addTrainingRequest.setTrainingChoice(request.getTrainingChoice());
        addTrainingRequest.setTrainer(request.getTrainer());
        return addTrainingRequest;

    }
}