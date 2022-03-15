package trainingLibrary.services;

import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.repository.TrainingRepository;

import java.util.List;

public class FindAllTrainingService {
    private final TrainingRepository repository;

    public FindAllTrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    public List<AddTrainingRequest> findAll() {
        return repository.findAll();
    }
}
