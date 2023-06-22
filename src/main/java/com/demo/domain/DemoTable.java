package com.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.UUID;

@Entity
public class DemoTable {
    @Id
    private String id;

    protected DemoTable() {
        // Note : Required by JPA. Do not use.
    }

    public DemoTable(UUID uuid) {
        this.id = uuid.toString();
    }

    public UUID id() {
        return UUID.fromString(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        DemoTable demoTable = (DemoTable) o;

        return new EqualsBuilder().append(id, demoTable.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .toString();
    }
}
