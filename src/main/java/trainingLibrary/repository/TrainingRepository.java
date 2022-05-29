package trainingLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trainingLibrary.domain.TrainingEntity;

import java.util.List;
import java.util.Optional;

public interface TrainingRepository extends JpaRepository<TrainingEntity, Integer>, JpaSpecificationExecutor<TrainingEntity> {

    List<TrainingEntity> findAllByTrainingChoice(String trainingChoice);

    Optional<TrainingEntity> findFirstByTrainingChoice(String trainingChoice);

    @Query(value = "SELECT tr FROM TrainingEntity tr LEFT JOIN UserEntity u on tr.userId = u.id " +
            "WHERE u.username = :username")
    List<TrainingEntity> findAllByUserName(@Param("username") String username);

}
