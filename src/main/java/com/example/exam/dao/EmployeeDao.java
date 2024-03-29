package com.example.exam.dao;

import com.example.exam.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> selectAll();
    public void addEmployee(Employee employee);
    public Employee findEmployeeById(int id);
    public void deleteEmployee(int id);
}
