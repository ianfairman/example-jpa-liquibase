package io.github.ianfairman.example.jpa.liquibase.value.jpa;

import io.github.ianfairman.example.jpa.liquibase.value.LastName;
import static io.github.ianfairman.example.jpa.liquibase.value.LastName.lastName;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LastNameConverter implements AttributeConverter<LastName, String> {

    @Override
    public String convertToDatabaseColumn(LastName value) {
        return value.getValue();
    }

    @Override
    public LastName convertToEntityAttribute(String value) {
        return lastName(value);
    }

}
