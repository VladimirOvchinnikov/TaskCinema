package com.bnw.taskcinema.model.common;

import com.bnw.taskcinema.utils.DefaultValueConst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFieldValueTest {

    private final String defVal = DefaultValueConst.STRING_DEF_VAL;
    private final String val = "check";
    private final String nullVal = null;


    @Test
    public void t_construct_01() {
        StringFieldValue fVal = new StringFieldValue();
        assertEquals(DefaultValueConst.STRING_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_construct_02() {
        StringFieldValue fVal = new StringFieldValue(defVal);
        assertEquals(DefaultValueConst.STRING_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_construct_03() {
        StringFieldValue fVal = new StringFieldValue(val);
        assertEquals(val, fVal.getValue());
    }


    @Test
    public void t_construct_04() {
        StringFieldValue fVal = new StringFieldValue(nullVal);
        assertEquals(DefaultValueConst.STRING_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_setValue_05() {
        StringFieldValue fVal = new StringFieldValue();
        fVal.setValue(defVal);
        assertEquals(DefaultValueConst.STRING_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_06() {
        StringFieldValue fVal = new StringFieldValue();
        fVal.setValue(val);
        assertEquals(val, fVal.getValue());
    }

    @Test
    public void t_setValue_07() {
        StringFieldValue fVal = new StringFieldValue();
        fVal.setValue(nullVal);
        assertEquals(DefaultValueConst.STRING_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_setValue_08() {
        StringFieldValue fVal = new StringFieldValue(val);
        fVal.setValue(nullVal);
        assertEquals(DefaultValueConst.STRING_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_09() {
        StringFieldValue fVal = new StringFieldValue(val);
        fVal.setValue(defVal);
        assertEquals(DefaultValueConst.STRING_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_10() {
        String tVal = "AAAAAAAAAAAAAAaaaaaa";
        StringFieldValue fVal = new StringFieldValue(val);
        fVal.setValue(tVal);
        assertEquals(tVal, fVal.getValue());
    }

}