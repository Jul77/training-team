package trainingLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDTO {

    private Integer id;
    private String trainingChoice;
    private String trainer;
}

