package com.bnw.taskcinema.model.common.converter;

import com.bnw.taskcinema.model.common.LocalTimeFieldValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalTime;

@Converter
public class LocalTimeFieldValueConverter implements AttributeConverter<LocalTimeFieldValue, LocalTime> {
    @Override
    public LocalTime convertToDatabaseColumn(LocalTimeFieldValue localTimeFieldValue) {
        return localTimeFieldValue.getValue();
    }

    @Override
    public LocalTimeFieldValue convertToEntityAttribute(LocalTime val) {
        return new LocalTimeFieldValue(val);
    }
}
