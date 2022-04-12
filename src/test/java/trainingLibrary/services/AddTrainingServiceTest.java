package trainingLibrary.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.AddTrainingRequest;
import trainingLibrary.dto.AddTrainingResponse;
import trainingLibrary.repository.HibernateRepository;
import trainingLibrary.validation.CoreError;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddTrainingServiceTest {
    @Mock
    private HibernateRepository repository;

    @Mock
    private ValidationService validationService;

    @InjectMocks
    private AddTrainingService addTrainingService;

    @Test
    void shouldSuccessfulSaveTraining() {
        var request = request();
        when(validationService.validate(request)).thenReturn(List.of());
        when(repository.save(entity(null))).thenReturn(entity(10));

        var result = addTrainingService.add(request());

        verify(repository).save(any());
        verify(validationService).validate(any());

        var expected = new AddTrainingResponse();
        expected.setErrors(null);
        expected.setCreateTrainingId(10);

        assertEquals(expected, result);
    }

    @Test
    void shouldSReturnErrors() {
        var request = request();
        when(validationService.validate(request)).thenReturn(List.of(new CoreError("TEST ERROR")));

        var result = addTrainingService.add(request());

        verify(validationService).validate(any());
        verifyNoInteractions(repository);

        var expected = new AddTrainingResponse();
        expected.setErrors(List.of(new CoreError("TEST ERROR")));
        expected.setCreateTrainingId(null);

        assertEquals(expected, result);
    }

    private AddTrainingRequest request() {
        var request = new AddTrainingRequest();
        request.setTrainer("TEST_TRAINER");
        request.setTrainingChoice("TEST_TRAINING_CHOICE");
        return request;
    }

    private TrainingEntity entity(Integer id) {
        var entity = new TrainingEntity();
        entity.setId(id);
        entity.setTrainer("TEST_TRAINER");
        entity.setTrainingChoice("TEST_TRAINING_CHOICE");
        return entity;
    }

}
