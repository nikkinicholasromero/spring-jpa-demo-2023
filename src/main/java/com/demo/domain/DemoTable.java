package com.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.UUID;

@Entity
@ToString
public class DemoTable extends BaseEntity<UUID> {
    @Id
    @Column
    private UUID id;

    @Column
    @Size(max = STRING_MAXLENGTH)
    private String firstName;

    @Column
    @Size(max = STRING_MAXLENGTH)
    private String middleName;

    @Column
    @Size(max = STRING_MAXLENGTH)
    private String lastName;

    @Column
    @Email
    @Size(max = STRING_MAXLENGTH)
    private String email;

    @Column
    @Pattern(regexp = "\\d{2}-\\d{6}-\\d")
    private String sssId;

    protected DemoTable() {
        // Note : Required by JPA. Do not use.
    }

    public DemoTable(UUID id, String firstName, String lastName, String email, String sssId) {
        this.id = Objects.requireNonNull(id);
        this.firstName = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(firstName)), STRING_MAXLENGTH);
        this.lastName = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(lastName)), STRING_MAXLENGTH);
        this.email = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(email)), STRING_MAXLENGTH);
        this.sssId = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(sssId)), STRING_MAXLENGTH);
    }

    @Override
    public UUID id() {
        return id;
    }

    public String firstName() {
        return StringUtils.trimToEmpty(firstName);
    }

    public String middleName() {
        return StringUtils.trimToEmpty(middleName);
    }

    public String lastName() {
        return StringUtils.trimToEmpty(lastName);
    }

    public String email() {
        return StringUtils.trimToEmpty(email);
    }

    public String sssId() {
        return StringUtils.trimToEmpty(sssId);
    }

    public DemoTable middleName(String middleName) {
        this.middleName = StringUtils.truncate(StringUtils.trimToEmpty(middleName), STRING_MAXLENGTH);;
        return this;
    }
}
