package trainingLibrary.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.TrainingDTO;
import trainingLibrary.repository.TrainingRepository;

import java.util.List;

@Component
@AllArgsConstructor
public class FindAllTrainingService {
    private final TrainingRepository repository;

    public List<TrainingDTO> findAllBy(String trainingChoice, String trainer) {
        var exampleEntity = new TrainingEntity();
        exampleEntity.setTrainingChoice(trainingChoice);
        exampleEntity.setTrainer(trainer);
        return repository.findAll(Example.of(exampleEntity)).stream()
                .map(this::convert)
                .toList();

    }

    public List<TrainingDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convert)
                .toList();

    }

    public List<TrainingDTO> findAllByUserName(String userName) {
        return repository.findAllByUserName(userName).stream()
                .map(this::convert)
                .toList();
    }

    private TrainingDTO convert(TrainingEntity entity) {
        return new TrainingDTO(entity.getId(), entity.getTrainingChoice(), entity.getTrainer());
    }

}
