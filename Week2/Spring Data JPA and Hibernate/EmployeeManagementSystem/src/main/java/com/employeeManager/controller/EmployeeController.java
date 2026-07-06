package com.employeeManager.controller;

import com.employeeManager.entity.Employee;
import com.employeeManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create Employee
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/name/{name}")
    public List<Employee> getByName(@PathVariable String name){

        return employeeService.getEmployeeByName(name);

    }
    @GetMapping("/email/{email}")
    public Employee getByEmail(@PathVariable String email){

        return employeeService.getEmployeeByEmail(email);

    }

    @GetMapping("/search/{keyword}")
    public List<Employee> search(@PathVariable String keyword){

        return employeeService.searchEmployee(keyword);

    }

    @GetMapping("/department/{department}")
    public List<Employee> getDepartmentEmployees(
            @PathVariable String department){

        return employeeService.getEmployeeByDepartment(department);

    }

    // Get Employee By Id
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}