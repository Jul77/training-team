package trainingLibrary.repository;

import trainingLibrary.domain.TrainingEntity;


import java.util.ArrayList;
import java.util.List;

public class ArrayListTrainingRepository implements TrainingRepository {

    private List<TrainingEntity> database = new ArrayList<>();
    private int idSequence = 0;

    @Override
    public TrainingEntity save(TrainingEntity entity) {
        entity.setId(idSequence);
        idSequence++;
        database.add(entity);
        return entity;
    }

    @Override
    public List<TrainingEntity> findAll() {
        return database;
    }
}
