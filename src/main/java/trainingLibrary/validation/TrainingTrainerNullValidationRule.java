package trainingLibrary.validation;

import org.springframework.stereotype.Component;
import trainingLibrary.dto.AddTrainingRequest;

@Component
public class TrainingTrainerNullValidationRule implements ValidationRule {

    @Override
    public void validate(AddTrainingRequest request) {
        if (request.getTrainingChoice() == null) {
            throw new ValidationException(("Training trainer must not be null"));

        }
    }
}
