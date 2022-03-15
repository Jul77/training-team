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
        var entity = convert(request);
        var validationResult = validationService.validation(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddTrainingResponse();
            response.setErrors(validationResult);
            return response;

        }
        var createdRequest = repository.save(request);
        System.out.println("Successfully saved " + createdRequest);
        var response = new AddTrainingResponse();
        response.getCreateTrainingId(createdRequest.getId());
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