package ch.swiss.km.featuretoggleassignmentbackend.service;

import ch.swiss.km.featuretoggleassignmentbackend.exceptions.ResourceNotFoundException;
import ch.swiss.km.featuretoggleassignmentbackend.model.FeatureToggle;
import ch.swiss.km.featuretoggleassignmentbackend.repository.FeatureToggleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class FeatureToggleService {
    @Autowired
    private FeatureToggleRepository featureToggleRepository;

    @PostConstruct
    private void postConstruct() {
        if (featureToggleRepository.findAll().size() == 0) {
            FeatureToggle[] featureToggles = new FeatureToggle[7];
            featureToggles[0] = new FeatureToggle(1, "ABR", true);
            featureToggles[1] = new FeatureToggle(2, "thor2", true);
            featureToggles[2] = new FeatureToggle(3, "foo", true);
            featureToggles[3] = new FeatureToggle(4, "darv", false);
            featureToggles[4] = new FeatureToggle(5, "luke", true);
            featureToggles[5] = new FeatureToggle(6, "sheev", false);
            featureToggles[6] = new FeatureToggle(7, "obi", false);
            featureToggleRepository.saveAll(List.of(featureToggles));
        }
    }

    public FeatureToggle getFeatureToggleById(long id) {
        return featureToggleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FeatureToggle with id " + id + " not found"));
    }

    public FeatureToggle createFeatureToggle(FeatureToggle featureToggle) {
        return featureToggleRepository.save(featureToggle);
    }

    public List<FeatureToggle> getFeatureToggles() {
        return featureToggleRepository.findAll();
    }

    public FeatureToggle updateFeatureToggle(long id, FeatureToggle featureToggle) {
        FeatureToggle featureToggleToUpdate = featureToggleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FeatureToggle with id" + id + "not found"));
        featureToggleToUpdate.setName(featureToggle.getName());
        featureToggleToUpdate.setActive(featureToggle.getActive());
        return featureToggleRepository.save(featureToggleToUpdate);
    }

    public void deleteFeatureToggle(long id) {
        FeatureToggle featureToggleToDelete = featureToggleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FeatureToggle with id" + id + "not found"));
        featureToggleRepository.delete(featureToggleToDelete);
    }

    public void deleteAllFeatureToggles() {
        featureToggleRepository.deleteAll();
    }

    public List<FeatureToggle> getActiveFeatureToggles() {
        return featureToggleRepository.findByActive(true);
    }

    public List<FeatureToggle> getFeatureTogglesByName(String name) {
        return featureToggleRepository.findByNameContaining(name);
    }
}
