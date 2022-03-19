package trainingLibrary.services;

import trainingLibrary.dto.GetByIdTrainingResponse;
import trainingLibrary.repository.TrainingRepository;

public class GetTrainingByIdService {
    private final TrainingRepository repository;

    public GetTrainingByIdService(TrainingRepository repository) {
        this.repository = repository;
    }

    public GetByIdTrainingResponse getById (Integer id) {
        throw new UnsupportedOperationException("Not implemented");

    }
}
