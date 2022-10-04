package ch.swiss.km.featuretoggleassignmentbackend.api;


import ch.swiss.km.featuretoggleassignmentbackend.model.FeatureToggle;
import ch.swiss.km.featuretoggleassignmentbackend.service.FeatureToggleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api")
public class FeatureToggleController {

    @Autowired
    private FeatureToggleService featureToggleService;

    @GetMapping("/feature-toggles/{id}")
    @ResponseBody
    public FeatureToggle getFeatureToggleById(@PathVariable long id) {
        return featureToggleService.getFeatureToggleById(id);
    }

    @GetMapping("/feature-toggles")
    @ResponseBody
    public List<FeatureToggle> getAllFeatureToggles(@RequestParam(required = false) String name) {
        if (name == null) {
            return featureToggleService.getFeatureToggles();
        } else {
            return featureToggleService.getFeatureTogglesByName(name);
        }
    }

    @PostMapping("/feature-toggles")
    @ResponseBody
    public FeatureToggle createFeatureToggle(@RequestBody FeatureToggle featureToggle) {
        return featureToggleService.createFeatureToggle(featureToggle);
    }

    @PutMapping("/feature-toggles/{id}")
    @ResponseBody
    public FeatureToggle updateFeatureToggle(@PathVariable long id, @RequestBody FeatureToggle featureToggle) {
        return featureToggleService.updateFeatureToggle(id, featureToggle);
    }

    @DeleteMapping("/feature-toggles/{id}")
    @ResponseBody
    public void deleteFeatureToggle(@PathVariable long id) {
        featureToggleService.deleteFeatureToggle(id);
    }

    @DeleteMapping("/feature-toggles")
    @ResponseBody
    public void deleteAllFeatureToggles() {
        featureToggleService.deleteAllFeatureToggles();
    }

    @GetMapping("/feature-toggles/active")
    @ResponseBody
    public List<FeatureToggle> getActiveFeatureToggles() {
        return featureToggleService.getActiveFeatureToggles();
    }

}
