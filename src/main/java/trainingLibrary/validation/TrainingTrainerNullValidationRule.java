package trainingLibrary.validation;

import trainingLibrary.domain.TrainingEntity;

public class TrainingTrainerNullValidationRule implements ValidationRule {

    @Override
    public void validate(TrainingEntity entity) {
        if (entity.getTrainingChoice() == null) {
            throw new ValidationException(("Training trainer must not be null"));

        }
    }
}
