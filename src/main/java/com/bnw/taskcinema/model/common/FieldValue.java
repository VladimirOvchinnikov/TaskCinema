package com.bnw.taskcinema.model.common;

import com.bnw.taskcinema.utils.DefaultValueUtils;

import java.util.Objects;

public class FieldValue<T> {
    //ConverterJpaAnnotation
    private T value;
    private final Class<T> type;

    public FieldValue(Class<T> type) {
        this.type = type;
        setValue(null);
    }

    public FieldValue(T value, Class<T> type) {
        this.type = type;
        setValue(value);
    }

//    public FieldValue(T value) {
//        this.type = (Class<T>) value.getClass();
//        setValue(value);
//    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        if (Objects.isNull(value)) {
            this.value = DefaultValueUtils.get(type);
        } else {
            this.value = value;
        }
    }


    public void destroy() {
        value = null;//
//        type = null;
    }

}
