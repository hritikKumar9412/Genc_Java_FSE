package com.hritik.springrestpractice.service.impl;

import com.hritik.springrestpractice.entity.Student;
import com.hritik.springrestpractice.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final List<Student> students = new ArrayList<>();

    public StudentServiceImpl() {

        students.add(new Student(1, "Hritik", "CSE"));
        students.add(new Student(2, "Rahul", "IT"));
        students.add(new Student(3, "Aman", "ECE"));
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(int id) {

        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Student addStudent(Student student) {

        students.add(student);
        return student;
    }

    @Override
    public Student updateStudent(int id, Student student) {

        Student existing = getStudentById(id);

        if (existing != null) {

            existing.setName(student.getName());
            existing.setCourse(student.getCourse());
        }

        return existing;
    }

    @Override
    public void deleteStudent(int id) {

        students.removeIf(student -> student.getId() == id);
    }
}