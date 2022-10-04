package ch.swiss.km.featuretoggleassignmentbackend.repository;
import ch.swiss.km.featuretoggleassignmentbackend.model.FeatureToggle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface for the FeatureToggleRepository
 * @author marco karpf
 * @verison 04.10.22
 */
public interface FeatureToggleRepository extends JpaRepository<FeatureToggle, Long> {

    List<FeatureToggle> findByActive(boolean active);
    List<FeatureToggle> findByNameContaining(String name);
}

