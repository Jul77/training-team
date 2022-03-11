package trainingLibrary.repository;

import trainingLibrary.domain.TrainingEntity;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTrainingRepository implements TrainingRepository {
    private List<TrainingEntity> database = new ArrayList<>();
    private long idSequence = 0;

    @Override
    public TrainingEntity save(TrainingEntity trainingEntity) {
        trainingEntity.setId(idSequence);
        idSequence++;
        database.add(trainingEntity);
        return trainingEntity;
    }

    @Override
    public List<TrainingEntity> findAll() {
        return database;
    }
}
