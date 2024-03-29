package com.example.exam.beans;

import com.example.exam.model.Employee;
import com.example.exam.service.EmployeeService;
import jakarta.faces.context.FacesContext;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeBean implements Serializable {
    private static final long serialVersionUID = 2L;
    private Employee employee = new Employee();
    private Employee newEmployee = new Employee();
    //    @Inject
    private EmployeeService service = new EmployeeService();
    private List<Employee> allEmployees;

    public EmployeeBean(){
        super();
        this.allEmployees = selectAll();
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getNewEmployee() {
        return newEmployee;
    }

    public void setNewEmployee(Employee newEmployee) {
        this.newEmployee = newEmployee;
    }

    public EmployeeService getService() {
        return service;
    }

    public void setService(EmployeeService service) {
        this.service = service;
    }

    public List<Employee> getAllEmployees() {
        return allEmployees;
    }

    public void setAllEmployees(List<Employee> allEmployees) {
        this.allEmployees = allEmployees;
    }



    public List<Employee> selectAll(){
        this.setAllEmployees(service.selectAllService());
        return service.selectAllService();
    }
    public void addEmployee(Employee employee) {
        service.addEmployeeService(employee);
    }
    public void deleteEmployee(int id){
        service.deleteEmployeeService(id);
    }
    public Employee findEmployee(int id){
        return service.findEmployeeService(id);
    }
}
