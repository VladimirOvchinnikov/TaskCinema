package com.bnw.taskcinema.model.common.converter;

import com.bnw.taskcinema.model.common.FieldValue;
import jakarta.persistence.AttributeConverter;

public class FieldValueConverter<T> implements AttributeConverter<FieldValue<T>, T> {
    @Override
    public T convertToDatabaseColumn(FieldValue<T> fieldValue) {
        return fieldValue.getValue();//есть подозрение, что тут можно уничтожать FieldValue
    }

    @Override
    public FieldValue<T> convertToEntityAttribute(T t) {
        return null;
//        return new FieldValue<T>(t, t.getClass());
    }

}
