package trainingLibrary.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "trainingLibrary")
@Table(name = "trainingLibrary")

public class TrainingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "trainingChoice")
    private String trainingChoice;

    @Column(name = "trainer")
    private String trainer;
}
