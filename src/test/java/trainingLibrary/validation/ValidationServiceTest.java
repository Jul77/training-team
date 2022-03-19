package trainingLibrary.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import trainingLibrary.dto.AddTrainingRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {
    @Mock
    private ValidationRule validationRules;

    @Captor
    private ArgumentCaptor<AddTrainingRequest> addTrainingRequestArgumentCaptor;

    private ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new ValidationService(List.of(validationRules));
    }

    @Test
    void shouldMapErrors() {
        doThrow(new ValidationException("TEST_EXCEPTION")).when(validationRules).validate(any());
        var request = new AddTrainingRequest();
        request.setTrainingChoice("TEST_TRAINING_CHOICE");
        var actual = validationService.validate(request);

        verify(validationRules).validate(addTrainingRequestArgumentCaptor.capture());
        var capturedRequest = addTrainingRequestArgumentCaptor.getValue();

        assertNotNull(capturedRequest);
        assertEquals("TEST_TRAINING_CHOICE", capturedRequest.getTrainingChoice());


        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(actual.get(0), new CoreError("TEST_EXCEPTION"));

    }
}