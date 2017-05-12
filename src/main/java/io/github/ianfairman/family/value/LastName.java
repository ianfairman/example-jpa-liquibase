package io.github.ianfairman.family.value;

import java.io.Serializable;
import java.util.Objects;

public class LastName implements Serializable {

    public static LastName lastName(String lastNameString) {
        return new LastName(lastNameString);
    }

    private final String value;

    public LastName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.value);
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
        final LastName other = (LastName) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }
}
