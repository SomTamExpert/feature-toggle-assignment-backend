package ch.swiss.km.featuretoggleassignmentbackend.api;

import ch.swiss.km.featuretoggleassignmentbackend.model.FeatureToggle;
import ch.swiss.km.featuretoggleassignmentbackend.service.FeatureToggleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class FeatureToggleController
 *
 * @author marco karpf
 * @version 04.10.22
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api")
public class FeatureToggleController {

    @Autowired
    private FeatureToggleService featureToggleService;

    /**
     * get FeatureToggle by id
     *
     * @param id
     * @return FeatureToggle
     */
    @GetMapping("/feature-toggles/{id}")
    @ResponseBody
    public FeatureToggle getFeatureToggleById(@PathVariable long id) {
        return featureToggleService.getFeatureToggleById(id);
    }

    /**
     * get all FeatureToggles
     *
     * @param name
     * @return List<FeatureToggle>
     */
    @GetMapping("/feature-toggles")
    @ResponseBody
    public List<FeatureToggle> getAllFeatureToggles(@RequestParam(required = false) String name) {
        if (name == null) {
            return featureToggleService.getFeatureToggles();
        } else {
            return featureToggleService.getFeatureTogglesByName(name);
        }
    }

    /**
     * create FeatureToggle
     *
     * @param featureToggle
     * @return FeatureToggle
     */
    @PostMapping("/feature-toggles")
    @ResponseBody
    public FeatureToggle createFeatureToggle(@RequestBody FeatureToggle featureToggle) {
        return featureToggleService.createFeatureToggle(featureToggle);
    }

    /**
     * update FeatureToggle
     *
     * @param id
     * @param featureToggle
     * @return FeatureToggle
     */
    @PutMapping("/feature-toggles/{id}")
    @ResponseBody
    public FeatureToggle updateFeatureToggle(@PathVariable long id, @RequestBody FeatureToggle featureToggle) {
        return featureToggleService.updateFeatureToggle(id, featureToggle);
    }

    /**
     * delete FeatureToggle by id
     *
     * @param id
     * @return void
     */
    @DeleteMapping("/feature-toggles/{id}")
    @ResponseBody
    public void deleteFeatureToggle(@PathVariable long id) {
        featureToggleService.deleteFeatureToggle(id);
    }

    /**
     * delete all FeatureToggles
     *
     * @return void
     */
    @DeleteMapping("/feature-toggles")
    @ResponseBody
    public void deleteAllFeatureToggles() {
        featureToggleService.deleteAllFeatureToggles();
    }

    /**
     * get active FeatureToggles
     *
     * @return List<FeatureToggle>
     */
    @GetMapping("/feature-toggles/active")
    @ResponseBody
    public List<FeatureToggle> getActiveFeatureToggles() {
        return featureToggleService.getActiveFeatureToggles();
    }

}
