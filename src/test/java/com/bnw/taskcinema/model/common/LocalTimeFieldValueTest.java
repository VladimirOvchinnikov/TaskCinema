package com.bnw.taskcinema.model.common;

import com.bnw.taskcinema.utils.DefaultValueConst;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalTimeFieldValueTest {
    private final LocalTime defVal = DefaultValueConst.TIME_DEF_VAL;
    private final LocalTime val = LocalTime.now().minusSeconds(100);
    private final LocalTime nullVal = null;


    @Test
    public void t_construct_01() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue();
        assertEquals(DefaultValueConst.TIME_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_construct_02() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue(defVal);
        assertEquals(DefaultValueConst.TIME_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_construct_03() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue(val);
        assertEquals(val, fVal.getValue());
    }


    @Test
    public void t_construct_04() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue(nullVal);
        assertEquals(DefaultValueConst.TIME_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_setValue_05() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue();
        fVal.setValue(defVal);
        assertEquals(DefaultValueConst.TIME_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_06() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue();
        fVal.setValue(val);
        assertEquals(val, fVal.getValue());
    }

    @Test
    public void t_setValue_07() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue();
        fVal.setValue(nullVal);
        assertEquals(DefaultValueConst.TIME_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_setValue_08() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue(val);
        fVal.setValue(nullVal);
        assertEquals(DefaultValueConst.TIME_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_09() {
        LocalTimeFieldValue fVal = new LocalTimeFieldValue(val);
        fVal.setValue(defVal);
        assertEquals(DefaultValueConst.TIME_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_10() {
        LocalTime tVal = LocalTime.now().minusSeconds(10);
        LocalTimeFieldValue fVal = new LocalTimeFieldValue(val);
        fVal.setValue(tVal);
        assertEquals(tVal, fVal.getValue());
    }
}