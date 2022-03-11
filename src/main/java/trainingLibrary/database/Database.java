package trainingLibrary.database;

import trainingLibrary.domain.TrainingEntity;

import java.util.List;

public interface Database {
    void save(TrainingEntity training);

    void deleteById(Long id);

    List<TrainingEntity> getAllTraining();

}
