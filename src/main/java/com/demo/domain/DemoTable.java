package com.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Entity
@ToString
public class DemoTable extends BaseEntity<UUID> {
    @Id
    private UUID id;

    private String firstName;

    private String middleName;

    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "\\d{2}-\\d{6}-\\d")
    private String sssId;

    protected DemoTable() {
        // Note : Required by JPA. Do not use.
    }

    public DemoTable(UUID id, String firstName, String lastName, String email, String sssId) {
        this.id = Objects.requireNonNull(id);
        this.firstName = Objects.requireNonNull(sanitize(firstName));
        this.lastName = Objects.requireNonNull(sanitize(lastName));
        this.email = Objects.requireNonNull(sanitize(email));
        this.sssId = Objects.requireNonNull(sanitize(sssId));
    }

    @Override
    public UUID id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String middleName() {
        return middleName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }

    public String sssId() {
        return sssId;
    }

    public DemoTable middleName(String middleName) {
        this.middleName = sanitize(middleName);
        return this;
    }
}
