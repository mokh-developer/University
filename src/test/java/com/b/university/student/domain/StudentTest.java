package com.b.university.student.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    @Test
    void registerCreatesStudentWithGeneratedIdAndNormalizedValues() {
        Student student = Student.register("  U-1001  ", "  آوا مریم ", " رضایی-حسینی  ");

        assertNotNull(student.id());
        assertEquals("U-1001", student.studentNumber());
        assertEquals("آوا مریم", student.firstName());
        assertEquals("رضایی-حسینی", student.lastName());
    }

    @Test
    void registerGeneratesDifferentIdsForDifferentStudents() {
        Student first = Student.register("U-1001", "آوا", "رضایی");
        Student second = Student.register("U-1002", "مریم", "حسینی");

        assertNotEquals(first.id(), second.id());
    }

    @Test
    void registerRejectsNullStudentNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> Student.register(null, "آوا", "رضایی"));
    }

    @Test
    void registerRejectsBlankStudentNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> Student.register(" \t ", "آوا", "رضایی"));
    }

    @Test
    void registerRejectsNullFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> Student.register("U-1001", null, "رضایی"));
    }

    @Test
    void registerRejectsBlankFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> Student.register("U-1001", " \t ", "رضایی"));
    }

    @Test
    void registerRejectsNullLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> Student.register("U-1001", "آوا", null));
    }

    @Test
    void registerRejectsBlankLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> Student.register("U-1001", "آوا", " \t "));
    }

    @Test
    void updateNameChangesNamesButKeepsIdAndStudentNumber() {
        Student student = Student.register("U-1001", "آوا", "رضایی");
        StudentId originalId = student.id();

        student.updateName(" مریم ", " حسینی ");

        assertEquals(originalId, student.id());
        assertEquals("U-1001", student.studentNumber());
        assertEquals("مریم", student.firstName());
        assertEquals("حسینی", student.lastName());
    }

    @Test
    void updateNameRejectsInvalidValuesWithoutPartiallyUpdatingStudent() {
        Student student = Student.register("U-1001", "آوا", "رضایی");

        assertThrows(IllegalArgumentException.class,
                () -> student.updateName("مریم", "  "));

        assertEquals("آوا", student.firstName());
        assertEquals("رضایی", student.lastName());
    }
}
