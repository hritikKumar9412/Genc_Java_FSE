package com.hritik.springrestpractice.service;

import com.hritik.springrestpractice.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student addStudent(Student student);

    Student updateStudent(int id, Student student);

    void deleteStudent(int id);
}