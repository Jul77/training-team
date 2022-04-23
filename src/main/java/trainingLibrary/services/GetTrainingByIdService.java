package trainingLibrary.services;

import org.springframework.stereotype.Component;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.GetByIdTrainingResponse;
import trainingLibrary.dto.TrainingDTO;
import trainingLibrary.repository.HibernateRepository;

@Component
public class GetTrainingByIdService {
    private final HibernateRepository <TrainingEntity> repository;

    public GetTrainingByIdService(HibernateRepository<TrainingEntity> repository) {
        this.repository = repository;
    }

    public GetByIdTrainingResponse getById (Integer id) {
       return repository.findById(id)
                .map(this::convert)
                .map(GetByIdTrainingResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("Training with id " + id + " is not found."));

    }
    private TrainingDTO convert(TrainingEntity entity) {
        return new TrainingDTO((entity.getId()),entity.getTrainingChoice(), entity.getTrainer());
    }
}
