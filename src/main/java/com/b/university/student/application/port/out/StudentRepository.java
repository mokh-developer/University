package com.b.university.student.application.port.out;

import com.b.university.student.domain.Student;
//import com.b.university.student.domain.StudentId;

public interface StudentRepository {
    boolean existsByStudentNumber(String studentNumber);
    void save(Student student);
}
