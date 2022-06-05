package trainingLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindAllTrainingResponse {

    private List<TrainingDTO> trainings;


}
