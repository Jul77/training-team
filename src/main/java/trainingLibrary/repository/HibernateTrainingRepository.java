package trainingLibrary.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import trainingLibrary.domain.TrainingEntity;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HibernateTrainingRepository implements HibernateRepository<TrainingEntity> {

    private final SessionFactory sessionFactory;

    HibernateTrainingRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public TrainingEntity save(TrainingEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public List<TrainingEntity> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT t FROM training t").getResultList();
    }


    @Override
    public Optional<TrainingEntity> findById(Integer id) {
       var entity = sessionFactory.getCurrentSession().get(TrainingEntity.class, id);
        return Optional.ofNullable(entity);
    }

    @Override
    public void update(TrainingEntity entity) {
        sessionFactory.getCurrentSession().update(entity);

    }
}
