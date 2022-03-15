package trainingLibrary.validation;

import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.AddTrainingRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationService {

    private final List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validation(AddTrainingRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("Training must not be null"));
            return errors;

        }
        return validationRules.stream()
                .map(rule -> mapError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(ValidationRule rule, AddTrainingRequest entity) {
        try {
            rule.validate(entity);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}

