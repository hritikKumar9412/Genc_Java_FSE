package com.employeeManager.service;

import com.employeeManager.entity.Department;
import com.employeeManager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Read All
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Read By Id
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Update
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Delete
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}