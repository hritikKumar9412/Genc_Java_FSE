package com.employeeManager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@NamedQuery(
        name="Employee.findByEmailAddress",
        query="SELECT e FROM Employee e WHERE e.email=:email"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;


    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;
}