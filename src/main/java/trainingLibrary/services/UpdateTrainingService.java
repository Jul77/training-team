package trainingLibrary.services;

import org.springframework.stereotype.Component;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.UpdateTrainingRequest;
import trainingLibrary.repository.HibernateRepository;

@Component
public class UpdateTrainingService {
    private final HibernateRepository<TrainingEntity> repository;

    public UpdateTrainingService(HibernateRepository <TrainingEntity> repository) {
        this.repository = repository;
    }

    public void update(UpdateTrainingRequest request) {
        repository.findById((request.getId()))
        .map(entity -> updateField(entity, request))
                .ifPresent(repository::update);
    }

    private TrainingEntity updateField(TrainingEntity entity, UpdateTrainingRequest request) {
        var updatedEntity = new TrainingEntity();
        updatedEntity.setId(entity.getId());
        updatedEntity.setTrainer(request.getTrainer());
        updatedEntity.setTrainingChoice(request.getTrainingChoice());
        return updatedEntity;
    }
}


