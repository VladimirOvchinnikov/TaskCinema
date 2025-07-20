package com.bnw.taskcinema.model.common.converter;

import com.bnw.taskcinema.model.common.StringFieldValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringFieldValueConverter implements AttributeConverter<StringFieldValue, String> {


    @Override
    public String convertToDatabaseColumn(StringFieldValue stringFieldValue) {
        return stringFieldValue.getValue();
    }

    @Override
    public StringFieldValue convertToEntityAttribute(String val) {
        return new StringFieldValue(val);
    }
}
