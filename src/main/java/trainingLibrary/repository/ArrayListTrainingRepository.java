package trainingLibrary.repository;

import org.springframework.stereotype.Repository;
import trainingLibrary.domain.TrainingEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayListTrainingRepository implements TrainingRepository {

    private List<TrainingEntity> database = new ArrayList<>();
    private int idSequence = 0;

    @Override
    public TrainingEntity save(TrainingEntity entity) {
        if (entity.getId() != null) {
        }else {

        }
        entity.setId(idSequence);
        idSequence++;
        database.add(entity);
        return entity;

    }

    private TrainingEntity update (TrainingEntity entity) {
        for (int i = 0; i < database.size(); i++) {
            var existingEntity = database.get(i);
            if (existingEntity.getId().equals(entity.getId())) {
                database.set(i, entity);
            }
        }
        return entity;
    }

    @Override
    public List<TrainingEntity> findAll() {
        return database;
    }

    @Override
    public Optional<TrainingEntity> findById(Integer id) {
        database.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
        return Optional.empty();
    }
}
