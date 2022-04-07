package trainingLibrary.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AddTrainingRequest {
    @NonNull
    private Integer id;
    private String trainingChoice;
    private String trainer;
}
