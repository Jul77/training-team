package trainingLibrary.dto;

import lombok.Data;

@Data
public class AddTrainingRequest {
    private Integer id;
    private String trainingChoice;
    private String trainer;
}
