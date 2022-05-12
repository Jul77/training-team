package trainingLibrary.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = "trainingLibrary", exclude = HibernateJpaAutoConfiguration.class)
public class TrainingApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class);

    }
}