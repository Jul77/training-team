package trainingLibrary.services;

import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.FindAllTrainingResponse;
import trainingLibrary.dto.TrainingDTO;
import trainingLibrary.repository.TrainingRepository;

import java.util.List;

public class FindAllTrainingService {
    private final TrainingRepository repository;

    public FindAllTrainingService(TrainingRepository repository) {
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
