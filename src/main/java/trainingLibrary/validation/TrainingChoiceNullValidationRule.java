package trainingLibrary.validation;

import trainingLibrary.domain.TrainingEntity;

public class TrainingChoiceNullValidationRule implements ValidationRule{

    @Override
    public void validate(TrainingEntity entity) {
        if(entity.getTrainingChoice() == null) {
            throw new ValidationException(("Training choice must not be null"));
        }
    }
}
