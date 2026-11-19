package com.b.university.student.application.exception;

public class StudentNumberAlreadyExistsException extends RuntimeException {
    public StudentNumberAlreadyExistsException(String studentNumberAlreadyExistsException) {
    super("Student Number "+ studentNumberAlreadyExistsException+ " Already Exists Exception");
    }
}
