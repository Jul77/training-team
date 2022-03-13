package trainingLibrary.dto;

import trainingLibrary.validation.CoreError;

import java.util.List;
import java.util.Objects;

public class AddTrainingResponse {

    private Long createTrainingId;
    private List<CoreError> errors;

    public Long getCreateTrainingId(Long id) {
        return createTrainingId;
    }

    public void setCreateTrainingId(Long createTrainingId) {
        this.createTrainingId = createTrainingId;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTrainingResponse that = (AddTrainingResponse) o;
        return Objects.equals(createTrainingId, that.createTrainingId) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createTrainingId, errors);
    }

    @Override
    public String toString() {
        return "AddTrainingResponse{" +
                "createTraining=" + createTrainingId +
                ", errors=" + errors +
                '}';
    }
}
