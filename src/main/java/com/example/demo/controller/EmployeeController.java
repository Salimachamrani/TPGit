package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        super();
        this.employeeService=employeeService;
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> GetAllEmployees() {
        return employeeService.GetAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> GetEmployeeById(@PathVariable long id) {
        return new ResponseEntity<>(employeeService.GetEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> UpdateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        return new ResponseEntity<>(employeeService.UpdateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable long id) {
        employeeService.DeleteEmployee(id);
        return new ResponseEntity<>("Employee deleted with success", HttpStatus.OK);
    }
}
