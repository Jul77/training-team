package trainingLibrary.dto;

import lombok.Data;

import lombok.NoArgsConstructor;
import trainingLibrary.validation.CoreError;

import java.util.List;

@Data
@NoArgsConstructor
public class AddTrainingResponse {

    private Integer createTrainingId;
    private List<CoreError> errors;

}

