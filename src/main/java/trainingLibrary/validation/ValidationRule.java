package trainingLibrary.validation;

import trainingLibrary.dto.AddTrainingRequest;

public interface ValidationRule {
    void validate(AddTrainingRequest request);

    default void checkNotNull(AddTrainingRequest request) {
        if (request == null) {
            throw new ValidationException("Training must not be null");

        }
    }
}
