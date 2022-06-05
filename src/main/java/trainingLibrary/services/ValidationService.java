package trainingLibrary.services;

import org.springframework.stereotype.Service;
import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.validation.CoreError;
import trainingLibrary.validation.ValidationException;
import trainingLibrary.validation.ValidationRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ValidationService {

    private final List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(AddTrainingRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("Training must not be null"));
            return errors;

        }
        return validationRules.stream()
                .map(rule -> validate(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public CoreError validate(ValidationRule rule,AddTrainingRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}

