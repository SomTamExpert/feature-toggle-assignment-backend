package ch.swiss.km.featuretoggleassignmentbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "feature_toggles")
public class FeatureToggle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private Boolean active;

    public FeatureToggle(long id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }
    public FeatureToggle(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }
    public FeatureToggle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean isActive) {
        active = isActive;
    }
}


