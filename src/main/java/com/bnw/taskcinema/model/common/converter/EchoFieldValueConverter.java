package com.bnw.taskcinema.model.common.converter;

import com.bnw.taskcinema.model.Echo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EchoFieldValueConverter implements AttributeConverter<Echo, Integer> {


    @Override
    public Integer convertToDatabaseColumn(Echo fVal) {
        return fVal.getId();
    }

    @Override
    public Echo convertToEntityAttribute(Integer val) {
        Echo echo = new Echo();
        echo.setId(val);
        return echo;
    }
}
