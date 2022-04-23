package trainingLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import trainingLibrary.validation.CoreError;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserResponse {
    private Integer createdUserId;
    private List<CoreError> errors;
}
