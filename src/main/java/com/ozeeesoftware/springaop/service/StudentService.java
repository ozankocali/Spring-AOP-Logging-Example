package com.ozeeesoftware.springaop.service;

import com.ozeeesoftware.springaop.model.Student;


import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Student student);

    Student deleteStudentById(Long id);

}
