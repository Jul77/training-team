package trainingLibrary.dto;

import java.util.Objects;

public class TrainingDTO {

    private Integer id;
    private String trainingChoice;
    private String trainer;

    public TrainingDTO(Integer id, String trainingChoice, String trainer) {
        this.id = id;
        this.trainingChoice = trainingChoice;
        this.trainer = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingDTO that = (TrainingDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(trainingChoice, that.trainingChoice) && Objects.equals(trainer, that.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainingChoice, trainer);
    }

    @Override
    public String toString() {
        return "TrainingDTO{" +
                "id=" + id +
                ", trainingChoice='" + trainingChoice + '\'' +
                ", trainer='" + trainer + '\'' +
                '}';
    }
}
