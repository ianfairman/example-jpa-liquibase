package io.github.ianfairman.example.jpa.liquibase.value;

import java.util.Objects;

public class FirstName {

    public static FirstName firstName(String firstNameString) {
        return new FirstName(firstNameString);
    }
    
    private final String value;

    public FirstName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.value);
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
        final FirstName other = (FirstName) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }
}
