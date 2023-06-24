package com.demo.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Accessors(fluent = true)
@ToString
public class DemoTable extends BaseEntity<String> {
    @Id
    @NotNull
    private String id;

    @NotBlank
    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String middleName;

    @NotBlank
    @Size(max = 255)
    private String lastName;

    @NotBlank
    @Email
    @Size(max = STRING_MAXLENGTH)
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{6}-\\d")
    @Size(max = 12)
    private String sssId;

    @NotNull
    private Boolean isRegular;

    @NotNull
    @PositiveOrZero
    private Long numberOfDependents;

    @NotNull
    @PositiveOrZero
    private BigDecimal height;

    @NotNull
    private LocalDate hireDate;

    @NotNull
    private LocalTime startTime;

    @Embedded
    private Audit audit;

    protected DemoTable() {
        // Note : Required by JPA. Do not use.
    }

    public DemoTable(
            String id, String firstName, String lastName,
            String email, String sssId,
            LocalDate hireDate, LocalTime startTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sssId = sssId;
        this.isRegular = false;
        this.numberOfDependents = 0L;
        this.height = BigDecimal.ZERO;
        this.hireDate = hireDate;
        this.startTime = startTime;
        this.audit = new Audit();
    }

    @Override
    public String id() {
        return id;
    }

    public DemoTable middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public DemoTable isRegular(Boolean isRegular) {
        this.isRegular = isRegular;
        return this;
    }

    public DemoTable numberOfDependents(Long numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
        return this;
    }

    public DemoTable height(BigDecimal height) {
        this.height = height;
        return this;
    }
}
