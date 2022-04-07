package trainingLibrary.dto;

import lombok.Data;

@Data
public class UpdateTrainingRequest {

    private Integer id;
    private String trainingChoice;
    private String trainer;

    }

