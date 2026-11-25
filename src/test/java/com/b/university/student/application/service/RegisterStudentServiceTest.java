package com.b.university.student.application.service;
import com.b.university.student.application.exception.StudentNumberAlreadyExistsException;
import com.b.university.student.domain.Student;
import com.b.university.student.domain.StudentId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterStudentServiceTest {

    private FakeStudentRepository fakeStudentRepository;
    private RegisterStudentService registerStudentService;

    @BeforeEach
    void setUp(){
        fakeStudentRepository =new FakeStudentRepository();
        registerStudentService =new RegisterStudentService(fakeStudentRepository);
    }
    @Test
    void shouldRegisterStudentSuccessfully() {

        StudentId studentId = registerStudentService.register(
                "1001",
                "Ali",
                "Ahmadi"
        );

        assertNotNull(studentId);
        assertEquals(1, fakeStudentRepository.findAll().size());
    }

    @Test
    void shouldThrowExceptionWhenStudentNumberAlreadyExists(){
        fakeStudentRepository.save(Student.register("1001","ALi" ,"Ahmadi"));
        assertThrows(
                StudentNumberAlreadyExistsException.class , () -> registerStudentService.register("1001","Ali","Ahmadi")
        );
    }
    @Test
    void shouldThrowExceptionWhenInputIsInvalid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> registerStudentService.register("", "Ali", "Ahmadi")
        );
    }
}
