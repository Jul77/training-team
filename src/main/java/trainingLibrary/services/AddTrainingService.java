package trainingLibrary.services;

import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.repository.TrainingRepository;

public class AddTrainingService {
    private final TrainingRepository repository;

    public AddTrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    public void add(TrainingEntity entity) {
        repository.save(entity);
    }
}