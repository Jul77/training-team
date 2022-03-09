package trainingLibrary;

import java.util.Objects;

public class Training {

    private Long id;
    private String name;
    private String trainingChoice;

    public Training(String name, String trainingChoice) {
        this.name = name;
        this.trainingChoice = trainingChoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainingChoice() {
        return trainingChoice;
    }

    public void setTrainingChoice(String trainingChoice) {
        this.trainingChoice = trainingChoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(name, training.name) && Objects.equals(trainingChoice, training.trainingChoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, trainingChoice);
    }

    @Override
    public String toString() {
        return "Training{" +
                "name='" + name + '\'' +
                ", trainingChoice='" + trainingChoice + '\'' +
                '}';
    }
}

