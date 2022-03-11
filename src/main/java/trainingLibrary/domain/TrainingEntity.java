package trainingLibrary.domain;

import java.util.Objects;

public class TrainingEntity {

    private Long id;
    private String trainingChoice;
    private String trainer;

    public TrainingEntity(String trainingChoice, String trainer) {
        this.trainer = trainer;
        this.trainingChoice = trainingChoice;
    }

    public TrainingEntity() {

    }

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
        TrainingEntity training = (TrainingEntity) o;
        return Objects.equals(trainingChoice,training.trainingChoice) && Objects.equals(trainingChoice, training.trainingChoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingChoice, trainer);
    }

    @Override
    public String toString() {
        return "Training{" +
                "name='" + trainingChoice + '\'' +
                ", trainingChoice='" + trainingChoice + '\'' +
                '}';
    }
}

