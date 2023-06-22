package com.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;
import java.util.UUID;

@Entity
@ToString
@Validated
public class DemoTable extends BaseEntity<UUID> {
    private static final int STRING_MAXLENGTH = 8_000;

    @Id
    @Column
    @NotNull
    private UUID id;

    @Column
    @NotBlank
    @Size(max = STRING_MAXLENGTH)
    private String firstName;

    @Column
    @NotBlank
    @Email
    @Size(max = STRING_MAXLENGTH)
    private String email;

    @Column
    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{6}-\\d{1}")
    private String sssId;

    protected DemoTable() {
        // Note : Required by JPA. Do not use.
    }

    public DemoTable(
            @NotNull UUID id,
            @NotNull String firstName,
            @NotNull String email,
            @NotNull String sssId) {
        this.id = Objects.requireNonNull(id);
        this.firstName = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(firstName)), STRING_MAXLENGTH);
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

    public String email() {
        return StringUtils.trimToEmpty(email);
    }
    public String sssId() {
        return StringUtils.trimToEmpty(sssId);
    }
}
