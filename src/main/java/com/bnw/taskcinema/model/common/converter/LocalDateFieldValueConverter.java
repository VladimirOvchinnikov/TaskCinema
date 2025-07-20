package com.bnw.taskcinema.model.common.converter;

import com.bnw.taskcinema.model.common.LocalDateFieldValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDate;

@Converter
public class LocalDateFieldValueConverter implements AttributeConverter<LocalDateFieldValue, LocalDate> {
    @Override
    public LocalDate convertToDatabaseColumn(LocalDateFieldValue localDateFieldValue) {
        return localDateFieldValue.getValue();
    }

    @Override
    public LocalDateFieldValue convertToEntityAttribute(LocalDate val) {
        return new LocalDateFieldValue(val);
    }
}
