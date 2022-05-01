package trainingLibrary.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import trainingLibrary.domain.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@AllArgsConstructor

public class HibernateUserRepository implements HibernateRepository<UserEntity> {
    private final SessionFactory sessionFactory;

    @Override
    public UserEntity save(UserEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public List<UserEntity> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT u FROM users u").getResultList();
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        var entity = sessionFactory.getCurrentSession().get(UserEntity.class, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public void update(UserEntity entity) {
        sessionFactory.getCurrentSession().update(entity);

    }
}
