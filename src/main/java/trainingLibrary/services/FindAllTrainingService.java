package trainingLibrary.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.SearchTrainingRequest;
import trainingLibrary.dto.TrainingDTO;
import trainingLibrary.repository.TrainingRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class FindAllTrainingService {
    private final TrainingRepository repository;

    public List<TrainingDTO> findAllByTrainingChoice(SearchTrainingRequest request) {
        var specifications = getSearchSpecifications(request);
        var entities = specifications.stream()
                .reduce(Specification::and)
                .map(repository::findAll)
                .orElseGet(repository::findAll);

        return entities.stream()
                .map(this::convert)
                .toList();

    }

    private List<Specification<TrainingEntity>> getSearchSpecifications(SearchTrainingRequest request) {
        var specifications = new ArrayList<Specification<TrainingEntity>>();
        var trainingChoice = request.getTrainingChoice();
        var trainer = request.getTrainer();
        var userId = request.getUserId();
        if (trainingChoice != null) {
            var specification = new SearchTrainingByTrainingChoiceSpecification(trainingChoice);
            specifications.add(specification);
        }
        if (trainer != null) {
            specifications.add(new SearchTrainingByTrainerSpecification(trainer));
        }
        if (userId != null) {
            specifications.add((new SearchTrainingByUserIdSpecification(userId)));
        }
        return specifications;
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
