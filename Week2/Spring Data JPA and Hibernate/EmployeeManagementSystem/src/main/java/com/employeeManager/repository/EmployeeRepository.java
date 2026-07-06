package com.employeeManager.repository;

import com.employeeManager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Exact Name
    List<Employee> findByName(String name);

    // Exact Email
    Employee findByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee getEmployeeByEmail(String email);

    // Department Name
    List<Employee> findByDepartmentName(String departmentName);

    // Name contains keyword
    List<Employee> findByNameContaining(String keyword);

    // Starts With
    List<Employee> findByNameStartingWith(String prefix);

    // Ends With
    List<Employee> findByNameEndingWith(String suffix);

}