package com.scarletshroud.course_work.entity;

import javax.persistence.*;

@Entity
@Table(name="sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="kind")
    private String kind;

    @Column(name="description")
    private String description;

    @Column(name="amount_of_riders")
    private Long amount_of_riders;

    public Sport() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAmount_of_riders() {
        return amount_of_riders;
    }

    public void setAmount_of_riders(Long amount_of_riders) {
        this.amount_of_riders = amount_of_riders;
    }
}
