package trainingLibrary.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.UpdateTrainingRequest;
import trainingLibrary.repository.TrainingRepository;

@Component
@AllArgsConstructor
public class UpdateTrainingService {
    private final TrainingRepository repository;

    @Transactional
    public void update(UpdateTrainingRequest request) {
        repository.findById(request.getId())
                .map(entity -> updateField(entity, request))
                .ifPresent(repository::save);
    }

    private TrainingEntity updateField(TrainingEntity entity, UpdateTrainingRequest request) {
        entity.setTrainingChoice(request.getTrainingChoice());
        entity.setTrainer(request.getTrainer());
        entity.setUserId(entity.getUserId());
        return entity;
    }
}


