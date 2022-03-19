package trainingLibrary.services;

import trainingLibrary.dto.UpdateTrainingRequest;
import trainingLibrary.repository.TrainingRepository;

public class UpdateTrainingService {
    private final TrainingRepository repository;

    public UpdateTrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    public void update(UpdateTrainingRequest request) {
    }
}
