package com.scarletshroud.course_work.entity;

import javax.persistence.*;

@Entity
@Table(name="spot_activity")
public class SpotActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="people_visited")
    private Long peopleVisited;

    @Column(name="activity")
    private String activity;

    public SpotActivity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPeopleVisited() {
        return peopleVisited;
    }

    public void setPeopleVisited(Long peopleVisited) {
        this.peopleVisited = peopleVisited;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
