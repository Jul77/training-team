package trainingLibrary.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import trainingLibrary.domain.TrainingEntity;
import trainingLibrary.dto.FindAllTrainingResponse;
import trainingLibrary.dto.TrainingDTO;
import trainingLibrary.repository.HibernateRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllTrainingServiceTest {

    @Mock
    private HibernateRepository repository;

    @InjectMocks
    private FindAllTrainingService findAllTrainingService;

    @Test
    void shouldFindAllTrainings() {
        var returnResult = entities();
        when(repository.findAll()).thenReturn(returnResult);

        var result = findAllTrainingService.findAll();

        var expectedResult = response();
        assertEquals(expectedResult, result);
    }

    private List<TrainingEntity> entities() {
        var returnEntity = new TrainingEntity();
        returnEntity.setId(1);
        returnEntity.setTrainer("Test trainer");
        returnEntity.setTrainingChoice("Test training choice");
        return List.of(returnEntity);
    }

    private FindAllTrainingResponse response() {
        var dto = new TrainingDTO(1, "Test training choice", "Test trainer");
        return new FindAllTrainingResponse(List.of(dto));
    }
}