package com.demo.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class Audit {
    @NotNull
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    protected Audit() {
        // Note : Required by JPA. Do not use.
        createDate = LocalDateTime.now();
    }
}
