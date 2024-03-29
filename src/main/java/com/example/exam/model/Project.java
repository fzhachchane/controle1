package com.example.exam.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double budget;

    @OneToMany(mappedBy = "project", cascade= CascadeType.ALL)
    private Set<Charge> charges = new HashSet<Charge>();

    public Project(){
        super();
    }
    public Project(String name, double budget, Set<Charge> charges) {
        this.name = name;
        this.budget = budget;
        this.charges = charges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Set<Charge> getCharges() {
        return charges;
    }

    public void setCharges(Set<Charge> charges) {
        this.charges = charges;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", charges=" + charges +
                '}';
    }
}
