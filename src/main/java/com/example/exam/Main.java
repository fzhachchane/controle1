package com.example.exam;

import com.example.exam.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-eclipselink");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Employee employee = new Employee();
            employee.setName("John Doe");
            employee.setEmail("john@example.com");
            employee.setPost(Post.MANAGER);

//            // Create skills
//            Skill skill1 = new Skill();
//            skill1.setSkillName("Java Programming");
//            skill1.setEmployee(employee); // Set the employee for skill1
//
//            Skill skill2 = new Skill();
//            skill2.setSkillName("Database Management");
//            skill2.setEmployee(employee); // Set the employee for skill2
//
//            List<Skill> skills = new ArrayList<>();
//            skills.add(skill1);
//            skills.add(skill2);

            // Add skills to employee
            employee.setSkill("Database Management");

            // Create a project
            Project project = new Project();
            project.setName("Web Application Development");
            project.setBudget(50000.0);

            // Create a charge
            Charge charge = new Charge();
            charge.setCharge(1000.0);
            charge.setEmployee(employee);
            charge.setProject(project);

            // Add charge to project
            project.getCharges().add(charge);

            // Persist the employee, skills, project, and charge
            em.persist(employee);
            em.persist(project);
            em.persist(charge);

            // Commit the transaction
            tx.commit();

            System.out.println("Employee, skills, project, and charge saved successfully!");

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
