package com.bnw.taskcinema.model.common.converter;

import com.bnw.taskcinema.model.common.LocalDateTimeFieldValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;

@Converter
public class LocalDateTimeFieldValueConverter implements AttributeConverter<LocalDateTimeFieldValue, LocalDateTime> {
    @Override
    public LocalDateTime convertToDatabaseColumn(LocalDateTimeFieldValue localDateTimeFieldValue) {
        return localDateTimeFieldValue.getValue();
    }

    @Override
    public LocalDateTimeFieldValue convertToEntityAttribute(LocalDateTime val) {
        return new LocalDateTimeFieldValue(val);
    }
}
