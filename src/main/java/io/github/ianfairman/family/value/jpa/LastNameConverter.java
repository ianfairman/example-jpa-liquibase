package io.github.ianfairman.family.value.jpa;

import io.github.ianfairman.family.value.LastName;
import static io.github.ianfairman.family.value.LastName.lastName;
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
