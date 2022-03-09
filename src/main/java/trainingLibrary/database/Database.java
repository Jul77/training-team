package trainingLibrary.database;

import trainingLibrary.Training;

import java.util.List;

public interface Database {
    void save(Training training);

    void deleteById(Long id);

    List<Training> getAllTraining();

}
