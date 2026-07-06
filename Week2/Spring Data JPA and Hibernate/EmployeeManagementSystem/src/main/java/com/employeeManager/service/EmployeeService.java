package com.employeeManager.service;

import com.employeeManager.entity.Employee;
import com.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }

    public Employee getEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> searchEmployee(String keyword){
        return employeeRepository.findByNameContaining(keyword);
    }

    public List<Employee> getEmployeeByDepartment(String department){
        return employeeRepository.findByDepartmentName(department);
    }

    // Create
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read All
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Read By Id
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Update
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}