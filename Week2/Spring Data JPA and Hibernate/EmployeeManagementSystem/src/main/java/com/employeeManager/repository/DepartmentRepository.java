package com.employeeManager.repository;

import com.employeeManager.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

}