package trainingLibrary.repository;

import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.AddTrainingRequest;

import java.util.List;

public interface TrainingRepository {
    TrainingEntity save (TrainingEntity entity);
    List<TrainingEntity> findAll();
}
