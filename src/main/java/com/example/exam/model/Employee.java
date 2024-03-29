package com.example.exam.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, email;
    private Post post;

//    @OneToMany(mappedBy = "employee", cascade= CascadeType.ALL)
//    private List<Skill> skills = new ArrayList<Skill>();
    private String skill;
    @OneToMany(mappedBy = "employee", cascade= CascadeType.ALL)
    private Set<Charge> charges = new HashSet<Charge>();


    public Employee(){
        super();
    }

    public Employee(String name, String email, String skills, Post post, Set<Charge> charges) {
        this.name = name;
        this.email = email;
        this.skill = skills;
        this.post = post;
        this.charges = charges;
    }
    public Employee(String name, String email, Post post) {
        this.name = name;
        this.email = email;
        this.post = post;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Set<Charge> getCharges() {
        return charges;
    }

    public void setCharges(Set<Charge> charges) {
        this.charges = charges;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", skills=" + skill +
                ", post=" + post +
                ", charges=" + charges +
                '}';
    }
}
