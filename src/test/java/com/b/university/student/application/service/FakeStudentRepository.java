package com.b.university.student.application.service;

import com.b.university.student.application.port.out.StudentRepository;
import com.b.university.student.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class FakeStudentRepository implements StudentRepository {

    ArrayList<Student> studentArrayList =new ArrayList<>();

    @Override
    public boolean existsByStudentNumber(String studentNumber) {

        for(Student student:studentArrayList)
        {
            if(student.studentNumber().equals(studentNumber))
                return true;
        }
        return false;
    }

    @Override
    public void save(Student student) {
        studentArrayList.add(student);
    }

    public List<Student> findAll(){
        return studentArrayList;
    }
}
