package trainingLibrary.validation;

import trainingLibrary.domain.TrainingEntity;

public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }
}

