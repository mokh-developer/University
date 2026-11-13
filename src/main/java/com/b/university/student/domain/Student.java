package com.b.university.student.domain;

public final class Student {

    private final StudentId id;
    private final String studentNumber;
    private String firstName;
    private String lastName;

    private Student(StudentId id, String studentNumber, String firstName, String lastName) {
        this.id = id;
        this.studentNumber = requireText("Student number", studentNumber);
        this.firstName = requireText("First name", firstName);
        this.lastName = requireText("Last name", lastName);
    }

    public static Student register(String studentNumber, String firstName, String lastName) {
        return new Student(StudentId.generate(), studentNumber, firstName, lastName);
    }

    public void updateName(String firstName, String lastName) {
        String normalizedFirstName = requireText("First name", firstName);
        String normalizedLastName = requireText("Last name", lastName);

        this.firstName = normalizedFirstName;
        this.lastName = normalizedLastName;
    }

    public StudentId id() {
        return id;
    }

    public String studentNumber() {
        return studentNumber;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    private static String requireText(String fieldName, String value) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " must not be null or blank");
        }

        String normalizedValue = value.strip();
        if (normalizedValue.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be null or blank");
        }

        return normalizedValue;
    }
}
