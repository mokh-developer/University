package com.b.university.student.domain;

import java.util.Objects;
import java.util.UUID;

public record StudentId(UUID value) {

    public StudentId {
        Objects.requireNonNull(value, "Student ID value must not be null");
    }

    public static StudentId generate() {
        return new StudentId(UUID.randomUUID());
    }
}
