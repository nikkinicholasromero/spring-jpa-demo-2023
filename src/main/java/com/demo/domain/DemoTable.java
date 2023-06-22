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
    @Id
    @Column
    @NotNull
    private UUID id;

    @Column
    @NotBlank
    @Size(max = STRING_MAXLENGTH)
    private String firstName;

    @Column
    @Size(max = STRING_MAXLENGTH)
    private String middleName;

    @Column
    @NotBlank
    @Size(max = STRING_MAXLENGTH)
    private String lastName;

    @Column
    @NotBlank
    @Email
    @Size(max = STRING_MAXLENGTH)
    private String email;

    @Column
    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{6}-\\d")
    private String sssId;

    protected DemoTable() {
        // Note : Required by JPA. Do not use.
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

    public static class Builder {
        private final UUID id;
        private final String firstName;
        private final String lastName;
        private final String email;
        private final String sssId;

        private String middleName;

        public Builder(UUID id, String firstName, String lastName, String email, String sssId) {
            this.id = Objects.requireNonNull(id);
            this.firstName = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(firstName)), STRING_MAXLENGTH);
            this.lastName = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(lastName)), STRING_MAXLENGTH);
            this.email = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(email)), STRING_MAXLENGTH);
            this.sssId = StringUtils.truncate(Objects.requireNonNull(StringUtils.trimToNull(sssId)), STRING_MAXLENGTH);
        }

        public Builder middleName(String middleName) {
            this.middleName = StringUtils.truncate(StringUtils.trimToNull(middleName), STRING_MAXLENGTH);;
            return this;
        }

        public DemoTable build() {
            DemoTable demoTable = new DemoTable();
            demoTable.id = id;
            demoTable.firstName = firstName;
            demoTable.middleName = middleName;
            demoTable.lastName = lastName;
            demoTable.email = email;
            demoTable.sssId = sssId;
            return demoTable;
        }
    }
}
