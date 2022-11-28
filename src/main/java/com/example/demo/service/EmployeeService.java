package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> GetAllEmployees();

    Employee GetEmployeeById(long id);

    Employee UpdateEmployee(Employee employee, long id);

    void DeleteEmployee(long id);
}
