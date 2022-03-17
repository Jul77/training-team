package trainingLibrary.dto;

import java.util.List;
import java.util.Objects;

public class FindAllTrainingResponse {

    private List<TrainingDTO> trainings;

    public FindAllTrainingResponse(List<TrainingDTO> trainings) {
        this.trainings = trainings;
    }

    public List<TrainingDTO> getTrainings() {
        return trainings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindAllTrainingResponse that = (FindAllTrainingResponse) o;
        return Objects.equals(trainings, that.trainings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainings);
    }

    @Override
    public String toString() {
        return "FindAllTrainingResponse{" +
                "trainings=" + trainings +
                '}';
    }
}
