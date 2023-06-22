package com.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;

import java.util.UUID;

@Entity
@ToString
public class DemoTable extends BaseEntity<UUID> {
    @Id
    private UUID id;

    protected DemoTable() {
        // Note : Required by JPA. Do not use.
    }

    public DemoTable(UUID id) {
        this.id = id;
    }

    @Override
    public UUID id() {
        return id;
    }
}
