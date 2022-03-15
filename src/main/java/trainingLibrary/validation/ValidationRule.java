package trainingLibrary.validation;

import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.AddTrainingRequest;

public interface ValidationRule {
    void validate(AddTrainingRequest request);

    default void checkNotNull(TrainingEntity entity) {
        if (entity == null) {
            throw new ValidationException("Training must not be null");

        }
    }
}
