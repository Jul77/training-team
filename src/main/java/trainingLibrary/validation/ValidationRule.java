package trainingLibrary.validation;

import trainingLibrary.domain.TrainingEntity;

public interface ValidationRule {
    void validate(TrainingEntity entity);

    default void checkNotNull(TrainingEntity entity) {
        if (entity == null) {
            throw new ValidationException("Training must not be null");

        }
    }
}
