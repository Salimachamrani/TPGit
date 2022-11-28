package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository=employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> GetAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee GetEmployeeById(long id) {
        Optional<Employee> employee= employeeRepository.findById(id);
        // error
        return employee.orElseGet(Employee::new);
    }

    @Override
    public Employee UpdateEmployee(Employee employee, long id) {
        Optional<Employee> existingEmployee= employeeRepository.findById(id);
        Employee employee1;
        if (existingEmployee.isPresent()){
            employee1=existingEmployee.get();
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setEmail(employee.getEmail());
            employeeRepository.save(employee1);
            return employee1;
        }else {
            return new Employee(); // error
        }

    }

    @Override
    public void DeleteEmployee(long id) {

        employeeRepository.deleteById(id);

    }
}
