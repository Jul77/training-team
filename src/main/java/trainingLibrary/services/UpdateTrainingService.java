package trainingLibrary.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.UpdateTrainingRequest;
import trainingLibrary.repository.TrainingRepository;

@Component
@AllArgsConstructor
public class UpdateTrainingService {
    private final TrainingRepository repository;

    public void update(UpdateTrainingRequest request) {
        repository.findById((request.getId()))
        .map(entity -> updateField(entity, request))
                .ifPresent(repository::save);
    }

    private TrainingEntity updateField(TrainingEntity entity, UpdateTrainingRequest request) {
        var updatedEntity = new TrainingEntity();
        updatedEntity.setTrainer(request.getTrainer());
        updatedEntity.setTrainingChoice(request.getTrainingChoice());
        return updatedEntity;
    }
}


