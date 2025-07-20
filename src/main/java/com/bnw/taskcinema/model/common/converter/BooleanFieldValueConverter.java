package com.bnw.taskcinema.model.common.converter;

import com.bnw.taskcinema.model.common.BooleanFieldValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter
public class BooleanFieldValueConverter implements AttributeConverter<BooleanFieldValue, Boolean> {


    @Override
    public Boolean convertToDatabaseColumn(BooleanFieldValue booleanFieldValue) {
        return booleanFieldValue.getValue();
    }

    @Override
    public BooleanFieldValue convertToEntityAttribute(Boolean val) {
        return new BooleanFieldValue(val);
    }
}
