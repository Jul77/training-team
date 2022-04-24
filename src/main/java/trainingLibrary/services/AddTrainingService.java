package trainingLibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.domain.UserEntity;
import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.dto.AddTrainingResponse;
import trainingLibrary.repository.HibernateRepository;


@Service
public class AddTrainingService {

    @Autowired
    private HibernateRepository<TrainingEntity> trainingRepository;

    @Autowired
    private HibernateRepository<UserEntity> repository;

    @Autowired
    private ValidationService validationService;

    public AddTrainingResponse add(AddTrainingRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddTrainingResponse();
            response.setErrors(validationResult);
            return response;
        }
        var user = repository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User with id" + request.getUserId() + " is not found!"));

        var entity = convert(request);
        entity.setUserId(request.getUserId());
        var createdEntity = trainingRepository.save(entity);
        System.out.println("Successfully saved " + createdEntity);
        var response = new AddTrainingResponse();
        System.out.println("Successfully saved: " + entity);
        response.setCreateTrainingId(createdEntity.getId());
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