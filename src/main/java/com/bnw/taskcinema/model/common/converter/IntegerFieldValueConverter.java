package com.bnw.taskcinema.model.common.converter;


import com.bnw.taskcinema.model.common.IntegerFieldValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class IntegerFieldValueConverter implements AttributeConverter<IntegerFieldValue, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IntegerFieldValue integerFieldValue) {
        return integerFieldValue.getValue();
    }

    @Override
    public IntegerFieldValue convertToEntityAttribute(Integer val) {
        return new IntegerFieldValue(val);
    }
}
