package trainingLibrary.repository;

import trainingLibrary.dto.AddTrainingRequest;

import java.util.List;

public interface TrainingRepository {
    AddTrainingRequest save (AddTrainingRequest request);
    List<AddTrainingRequest> findAll();
}
