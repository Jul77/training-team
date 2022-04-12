package trainingLibrary.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import trainingLibrary.domain.TrainingEntity;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;


public class JDBCTemplateTrainingRepository implements HibernateRepository {

    private final JdbcTemplate jdbcTemplate;

    JDBCTemplateTrainingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TrainingEntity save(TrainingEntity entity) {
        var query = "INSERT INTO trainings(trainingChoice, trainer) VALUES (?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getTrainingChoice());
            ps.setString(2, entity.getTrainer());
            return ps;
        }, keyHolder);
        entity.setId(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public List<TrainingEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM trainings", new BeanPropertyRowMapper(TrainingEntity.class));
    }

    @Override
    public Optional<TrainingEntity> findById(Integer id) {
        var result = jdbcTemplate.queryForObject("SELECT * FROM trainings WHERE id=" + id, new BeanPropertyRowMapper<>(TrainingEntity.class));
        return Optional.ofNullable(result);
    }
}
