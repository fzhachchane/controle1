package com.example.exam.model;

import jakarta.persistence.*;

@Entity
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double charge;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    public Charge(){
        super();
    }
    public Charge(double charge, Employee employee, Project project) {
        this.charge = charge;
        this.employee = employee;
        this.project = project;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "id=" + id +
                ", charge=" + charge +
                ", employee=" + employee +
                ", project=" + project +
                '}';
    }
}
