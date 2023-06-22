package com.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.ToString;

import java.util.Optional;
import java.util.UUID;

@Entity
@ToString
public class DemoTable extends BaseEntity<UUID> {
    @Id
    @NotNull
    private UUID id;

    @NotBlank
    @Size(max = 255)
    @Column(length = 255)
    private String firstName;

    @Size(max = 255)
    @Column(length = 255)
    private String middleName;

    @NotBlank
    @Size(max = 255)
    @Column(length = 255)
    private String lastName;

    @NotBlank
    @Email
    @Size(max = STRING_MAXLENGTH)
    @Column(length = STRING_MAXLENGTH)
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{6}-\\d")
    @Size(max = 12)
    @Column(length = 12)
    private String sssId;

    protected DemoTable() {
        // Note : Required by JPA. Do not use.
    }

    public DemoTable(UUID id, String firstName, String lastName, String email, String sssId) {
        this.id = id;
        this.firstName = sanitize(firstName);
        this.lastName = sanitize(lastName);
        this.email = sanitize(email);
        this.sssId = sanitize(sssId);
    }

    @Override
    public UUID id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public Optional<String> middleName() {
        return Optional.of(middleName);
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
