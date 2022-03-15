package trainingLibrary.validation;

import trainingLibrary.dto.AddTrainingRequest;

public class TrainingChoiceNullValidationRule implements ValidationRule{

    @Override
    public void validate(AddTrainingRequest request) {
        if(request.getTrainingChoice() == null) {
            throw new ValidationException(("Training choice must not be null"));
        }
    }
}
