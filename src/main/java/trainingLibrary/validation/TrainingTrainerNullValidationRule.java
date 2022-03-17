package trainingLibrary.validation;

import trainingLibrary.dto.AddTrainingRequest;

public class TrainingTrainerNullValidationRule implements ValidationRule {

    @Override
    public void validate(AddTrainingRequest request) {
        if (request.getTrainingChoice() == null) {
            throw new ValidationException(("Training trainer must not be null"));

        }
    }
}
