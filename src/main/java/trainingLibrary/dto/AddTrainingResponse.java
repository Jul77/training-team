package trainingLibrary.dto;

import lombok.Data;

import trainingLibrary.validation.CoreError;

import java.util.List;

@Data
public class AddTrainingResponse {

    private Integer createTrainingId;
    private List<CoreError> errors;

}

