package io.github.ianfairman.example.jpa.liquibase.value;

import java.util.Objects;
import static java.util.Objects.requireNonNull;

public class IndividualId {
    
    public static IndividualId individualId(Integer value) {
        return new IndividualId(value);
    }
    
    private final Integer value;

    public IndividualId(Integer value) {
        requireNonNull(value);
        if (value < 0) {
            throw new IllegalArgumentException("value should not be negative");
        }
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IndividualId other = (IndividualId) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }
}
