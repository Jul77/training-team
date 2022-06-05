package trainingLibrary.validation;

import org.springframework.stereotype.Component;
import trainingLibrary.dto.AddTrainingRequest;

@Component
public class TrainingChoiceNullValidationRule implements ValidationRule {

    @Override
    public void validate(AddTrainingRequest request) {
        if (request.getTrainingChoice() == null) {
            throw new ValidationException(("Training choice must not be null"));
        }
    }
}
