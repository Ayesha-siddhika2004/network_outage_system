package com.example.engineer_management.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "engineers")
public class Engineer {

    @Id
    private String id;   // store UUID as String

    private String name;
    private String region;

    @Column(columnDefinition = "TEXT")
    private String areas;   // "T.Nagar, Anna Nagar, Porur"

    // constructor: auto generate UUID when new engineer created
    public Engineer() {
        this.id = UUID.randomUUID().toString();
    }

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getAreas() { return areas; }
    public void setAreas(String areas) { this.areas = areas; }
}
