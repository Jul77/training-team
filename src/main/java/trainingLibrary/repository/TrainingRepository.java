package trainingLibrary.repository;

import trainingLibrary.domain.TrainingEntity;

import java.util.List;

public interface TrainingRepository {
    TrainingEntity save (TrainingEntity trainingEntity);
    List<TrainingEntity> findAll();
}
