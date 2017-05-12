package io.github.ianfairman.family.value;

import java.util.Objects;
import static java.util.Objects.requireNonNull;

public class FamilyId {

    public static FamilyId familyId(Integer value) {
        return new FamilyId(value);
    }
    
    private final Integer value;

    public FamilyId(Integer value) {
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
        hash = 41 * hash + Objects.hashCode(this.value);
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
        final FamilyId other = (FamilyId) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }
}
