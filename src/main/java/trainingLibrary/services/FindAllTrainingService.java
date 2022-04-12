package trainingLibrary.services;

import org.springframework.stereotype.Component;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.FindAllTrainingResponse;
import trainingLibrary.dto.TrainingDTO;
import trainingLibrary.repository.HibernateRepository;

@Component
public class FindAllTrainingService {
    private final HibernateRepository repository;

    public FindAllTrainingService(HibernateRepository repository) {
        this.repository = repository;
    }

    public FindAllTrainingResponse findAll() {
        var dto = repository.findAll().stream()
                .map(this::convert)
                .toList();
        return new FindAllTrainingResponse(dto);
    }

    private TrainingDTO convert(TrainingEntity entity){
        return  new TrainingDTO(entity.getId(), entity.getTrainingChoice(), entity.getTrainer());
    }
}
