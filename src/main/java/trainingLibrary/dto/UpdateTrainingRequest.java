package trainingLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class UpdateTrainingRequest {

    private Integer id;
    private String trainingChoice;
    private String trainer;

    public UpdateTrainingRequest() {

    }
}
