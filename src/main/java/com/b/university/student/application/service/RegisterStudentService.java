package com.b.university.student.application.service;

import com.b.university.student.application.exception.StudentNumberAlreadyExistsException;
import com.b.university.student.application.port.in.RegisterStudentUseCase;
import com.b.university.student.application.port.out.StudentRepository;
import com.b.university.student.domain.Student;
import com.b.university.student.domain.StudentId;

public class RegisterStudentService implements RegisterStudentUseCase{
   private  final StudentRepository studentRepository;

    public RegisterStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Override
    public StudentId register(String studentNumber, String firstName, String lastName){
        Student student=Student.register(studentNumber,firstName,lastName);
        String studentNumberStrip=student.studentNumber();
        if( !studentRepository.existsByStudentNumber(studentNumberStrip))
        {
            studentRepository.save(student);

        }
        else
            throw new StudentNumberAlreadyExistsException(studentNumberStrip);
        return student.id();
    }
}
