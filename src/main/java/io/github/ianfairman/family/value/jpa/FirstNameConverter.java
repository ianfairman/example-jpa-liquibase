package io.github.ianfairman.family.value.jpa;

import io.github.ianfairman.family.value.FirstName;
import static io.github.ianfairman.family.value.FirstName.firstName;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class FirstNameConverter implements AttributeConverter<FirstName, String> {

    @Override
    public String convertToDatabaseColumn(FirstName value) {
        return value.getValue();
    }

    @Override
    public FirstName convertToEntityAttribute(String value) {
        return firstName(value);
    }

}
