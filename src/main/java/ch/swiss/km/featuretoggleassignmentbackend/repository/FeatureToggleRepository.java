package ch.swiss.km.featuretoggleassignmentbackend.repository;
import ch.swiss.km.featuretoggleassignmentbackend.model.FeatureToggle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeatureToggleRepository extends JpaRepository<FeatureToggle, Long> {

    List<FeatureToggle> findByActive(boolean active);
    List<FeatureToggle> findByNameContaining(String name);
}

