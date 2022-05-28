package trainingLibrary.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.dto.AddTrainingResponse;
import trainingLibrary.repository.TrainingRepository;

@Slf4j
@Service
@AllArgsConstructor
public class AddTrainingService {

    private final TrainingRepository repository;

    public AddTrainingResponse add(AddTrainingRequest request) {
        log.info("Received request: {} ", request);
        var entity = convert(request);
        entity.setUserId(request.getUserId());
        var createdEntity = repository.save(entity);
        log.info("Successfully saved: {} ", createdEntity);
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