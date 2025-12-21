package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String description;
    private Integer weight;
    private boolean active = true;

    public Integer getWeight() { return weight; }
    public boolean isActive() { return active; }
}
