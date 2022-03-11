package trainingLibrary.services;

import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.repository.TrainingRepository;

import java.util.List;

public class FindAllTrainingService {
    private final TrainingRepository repository;

    public FindAllTrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    public List<TrainingEntity> findAll() {
        return repository.findAll();
    }
}
