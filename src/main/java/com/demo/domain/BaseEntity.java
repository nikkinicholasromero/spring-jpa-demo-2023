package com.demo.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Transient;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.domain.Persistable;

import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity<ID> implements Persistable<ID> {
    private static final int STRING_MAXLENGTH = 8_000;

    @Transient
    private boolean persisted = false;

    @Override
    public boolean isNew() {
        return !persisted;
    }

    @PostLoad
    @PostPersist
    protected void setPersisted() {
        this.persisted = true;
    }

    public abstract ID id();

    public String sanitize(String value) {
        return StringUtils.truncate(StringUtils.trimToNull(value), STRING_MAXLENGTH);
    }

    @Override
    public ID getId() {
        return id();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        return new EqualsBuilder()
                .append(id(), ((BaseEntity<?>) o).id())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id())
                .toHashCode();
    }
}
