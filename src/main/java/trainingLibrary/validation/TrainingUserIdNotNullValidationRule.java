package trainingLibrary.validation;

import trainingLibrary.dto.AddTrainingRequest;

public class TrainingUserIdNotNullValidationRule implements ValidationRule{
    @Override
    public void validate(AddTrainingRequest request) {
        if(request.getUserId() == null) {
            throw  new ValidationException("User id must not be null!");
        }
    }

    @Override
    public void checkNotNull(AddTrainingRequest request) {
        ValidationRule.super.checkNotNull(request);
    }
}
