package com.b.university.student.application.port.in;
import com.b.university.student.application.exception.StudentNumberAlreadyExistsException;
import  com.b.university.student.domain.StudentId;
public interface RegisterStudentUseCase {

    StudentId register(String studentNumber , String firstName , String lastName)
            throws StudentNumberAlreadyExistsException;

}