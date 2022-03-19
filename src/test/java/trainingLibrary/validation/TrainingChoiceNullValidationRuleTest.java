package trainingLibrary.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import trainingLibrary.dto.AddTrainingRequest;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class TrainingChoiceNullValidationRuleTest {

    @Mock
    private AddTrainingRequest request;

    TrainingChoiceNullValidationRule validationRule = new TrainingChoiceNullValidationRule();

    @Test
    void shouldThrowExceptionWhenNameUIsNull() {
        when(request.getTrainingChoice()).thenReturn(null);
        Assertions.assertThrows(ValidationException.class, () -> validationRule.validate(request));

    }

    @Test
    void shouldNotThrowException() {
        var request = new AddTrainingRequest();
        request.setTrainingChoice("TEST_TRAINING_CHOICE");
        Assertions.assertDoesNotThrow(() -> validationRule.validate(request));
    }
}