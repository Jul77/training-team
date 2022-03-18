package trainingLibrary.domain;

import java.util.Objects;

public class TrainingEntity {

    private Integer id;
    private String trainingChoice;
    private String trainer;

    public TrainingEntity(String trainingChoice, String trainer) {
        this.trainer = trainer;
        this.trainingChoice = trainingChoice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        TrainingEntity that = (TrainingEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(trainingChoice, that.trainingChoice) && Objects.equals(trainer, that.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainingChoice, trainer);
    }

    @Override
    public String toString() {
        return "TrainingEntity{" +
                "id=" + id +
                ", trainingChoice='" + trainingChoice + '\'' +
                ", trainer='" + trainer + '\'' +
                '}';
    }
}

