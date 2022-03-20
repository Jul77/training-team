package trainingLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trainingLibrary.validation.CoreError;

import java.util.List;
import java.util.Objects;

@Data
public class AddTrainingResponse {

    private Integer createTrainingId;
    private List<CoreError> errors;

}

