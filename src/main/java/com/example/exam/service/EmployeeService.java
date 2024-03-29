package com.example.exam.service;

import com.example.exam.dao.EmployeeDao;
import com.example.exam.dao.imp.EmployeeDaoImp;
import com.example.exam.model.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDao employeeDao;
    public EmployeeService(){
        employeeDao = new EmployeeDaoImp();
    }

    public List<Employee> selectAllService(){
        return employeeDao.selectAll();
    }

    public void addEmployeeService(Employee employee){
        employeeDao.addEmployee(employee);
    }
    public Employee findEmployeeService(int id){ return employeeDao.findEmployeeById(id);}
    public void deleteEmployeeService(int id){ employeeDao.deleteEmployee(id);}
}
