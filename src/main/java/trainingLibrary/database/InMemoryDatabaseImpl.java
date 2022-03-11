package trainingLibrary.database;

import trainingLibrary.domain.TrainingEntity;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements Database {
    private Long nextId = 1L;
    private List<TrainingEntity> trainings = new ArrayList<>();

    @Override
    public void save(TrainingEntity training) {
        training.setId(nextId);
        nextId++;
        trainings.add(training);
    }

    @Override
    public void deleteById(Long id) {
        trainings.stream()
                .filter(training -> training.getId().equals(id))
                .findFirst()
                .ifPresent(training -> trainings.remove(training));
    }

    @Override
    public List<TrainingEntity> getAllTraining() {
        return null;
    }
}


