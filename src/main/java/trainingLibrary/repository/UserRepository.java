package trainingLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainingLibrary.domain.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
