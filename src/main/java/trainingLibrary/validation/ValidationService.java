package trainingLibrary.validation;

import trainingLibrary.domain.TrainingEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationService {

    private final List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validation(TrainingEntity trainingEntity) {
        List<CoreError> errors = new ArrayList<>();
        if (trainingEntity == null) {
            errors.add(new CoreError("Training must not be null"));
            return errors;

        }
        return validationRules.stream()
                .map(rule -> mapError(rule, trainingEntity))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(ValidationRule rule, TrainingEntity entity) {
        try {
            rule.validate(entity);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}

