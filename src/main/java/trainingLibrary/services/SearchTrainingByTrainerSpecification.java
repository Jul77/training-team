package trainingLibrary.services;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import trainingLibrary.domain.TrainingEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class SearchTrainingByTrainerSpecification implements Specification<TrainingEntity> {

    private final String trainer;

    @Override
    public Predicate toPredicate(Root<TrainingEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get("trainer"), trainer);
    }
}
