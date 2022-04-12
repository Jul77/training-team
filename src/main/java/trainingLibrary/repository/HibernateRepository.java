package trainingLibrary.repository;

import trainingLibrary.domain.TrainingEntity;

import java.util.List;
import java.util.Optional;

public interface HibernateRepository {

    TrainingEntity save(TrainingEntity entity);

    List<TrainingEntity> findAll();

    Optional<TrainingEntity> findById(Integer id);
}