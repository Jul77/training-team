package trainingLibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "trainings")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrainingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "training_сhoice")
    private String trainingChoice;

    @Column(name = "trainer")
    private String trainer;

    @Column(name = "user_id")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Integer userId;
}
