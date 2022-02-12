package com.scarletshroud.course_work.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="spot")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="update_date")
    private Date updateDate;

    @Column(name="activity_id")
    private Long activityId;

    @Column(name="location_id")
    private Long locationId;

    public Spot() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date update_date) {
        this.updateDate = update_date;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activity_id) {
        this.activityId = activity_id;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long location_id) {
        this.locationId = location_id;
    }
}
