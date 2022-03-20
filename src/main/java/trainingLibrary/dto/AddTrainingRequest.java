package trainingLibrary.dto;

import java.util.Objects;

public class AddTrainingRequest {
    private Long id;
    private String trainingChoice;
    private String trainer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainingChoice() {
        return trainingChoice;
    }

    public void setTrainingChoice(String trainingChoice) {
        this.trainingChoice = trainingChoice;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTrainingRequest that = (AddTrainingRequest) o;
        return Objects.equals(trainingChoice, that.trainingChoice) && Objects.equals(trainer, that.trainer);
    }

    @Override
    public String toString() {
        return "AddTrainingRequest{" +
                "trainingChoice='" + trainingChoice + '\'' +
                ", trainer='" + trainer + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingChoice, trainer);
    }
}
