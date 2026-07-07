package com.hritik.springrestpractice.controller;

import com.hritik.springrestpractice.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {

        return new Student(
                1,
                "Hritik",
                "Computer Science"
        );
    }
}