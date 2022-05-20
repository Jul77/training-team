package trainingLibrary.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class AddTrainingRequest {
    @NotBlank
    @Length(min = 3, max = 20)
    private String trainingChoice;
    @NonNull
    private String trainer;
    @NonNull
    @Range(min = 1)
    private Integer userId;
}
