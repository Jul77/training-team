package trainingLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTrainingRequest {
    @NonNull
    private Integer id;
    private String trainingChoice;
    private String trainer;
    private Integer userId;
}
