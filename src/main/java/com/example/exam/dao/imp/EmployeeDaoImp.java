package com.example.exam.dao.imp;

import com.example.exam.dao.EmployeeDao;
import com.example.exam.model.Employee;
import jakarta.persistence.*;

import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {
    public List<Employee> selectAll(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Query query = entityManager.createQuery("SELECT o FROM Employee o");
        List<Employee> resultList = query.getResultList();
        tx.commit();
        entityManager.close();
        entityManagerFactory.close();

        return resultList;
    }
    public void addEmployee(Employee employee){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(employee);
        tx.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public Employee findEmployeeById(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Employee resultEmp = entityManager.find(Employee.class, 14);
        tx.commit();

        entityManager.close();
        entityManagerFactory.close();

        return resultEmp;
    }

    public void deleteEmployee(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Employee toDelete = new Employee();
        toDelete = findEmployeeById(id);
        entityManager.remove(toDelete);
        tx.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
