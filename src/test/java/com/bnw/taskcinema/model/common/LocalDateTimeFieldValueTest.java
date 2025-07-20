package com.bnw.taskcinema.model.common;

import com.bnw.taskcinema.utils.DefaultValueConst;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateTimeFieldValueTest {
    private final LocalDateTime defVal = DefaultValueConst.TIMESTAMP_DEF_VAL;
    private final LocalDateTime val = LocalDateTime.now().minusDays(100);
    private final LocalDateTime nullVal = null;


    @Test
    public void t_construct_01() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue();
        assertEquals(DefaultValueConst.TIMESTAMP_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_construct_02() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue(defVal);
        assertEquals(DefaultValueConst.TIMESTAMP_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_construct_03() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue(val);
        assertEquals(val, fVal.getValue());
    }


    @Test
    public void t_construct_04() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue(nullVal);
        assertEquals(DefaultValueConst.TIMESTAMP_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_setValue_05() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue();
        fVal.setValue(defVal);
        assertEquals(DefaultValueConst.TIMESTAMP_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_06() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue();
        fVal.setValue(val);
        assertEquals(val, fVal.getValue());
    }

    @Test
    public void t_setValue_07() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue();
        fVal.setValue(nullVal);
        assertEquals(DefaultValueConst.TIMESTAMP_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_setValue_08() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue(val);
        fVal.setValue(nullVal);
        assertEquals(DefaultValueConst.TIMESTAMP_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_09() {
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue(val);
        fVal.setValue(defVal);
        assertEquals(DefaultValueConst.TIMESTAMP_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_10() {
        LocalDateTime tVal = LocalDateTime.now().minusDays(10);
        LocalDateTimeFieldValue fVal = new LocalDateTimeFieldValue(val);
        fVal.setValue(tVal);
        assertEquals(tVal, fVal.getValue());
    }
}