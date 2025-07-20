package com.bnw.taskcinema.model.common;

import com.bnw.taskcinema.utils.DefaultValueConst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerFieldValueTest {

    private final Integer defVal = DefaultValueConst.INT_DEF_VAL;
    private final Integer val = 1;
    private final Integer nullVal = null;


    @Test
    public void t_construct_01() {
        IntegerFieldValue fVal = new IntegerFieldValue();
        assertEquals(DefaultValueConst.INT_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_construct_02() {
        IntegerFieldValue fVal = new IntegerFieldValue(defVal);
        assertEquals(DefaultValueConst.INT_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_construct_03() {
        IntegerFieldValue fVal = new IntegerFieldValue(val);
        assertEquals(val, fVal.getValue());
    }


    @Test
    public void t_construct_04() {
        IntegerFieldValue fVal = new IntegerFieldValue(nullVal);
        assertEquals(DefaultValueConst.INT_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_setValue_05() {
        IntegerFieldValue fVal = new IntegerFieldValue();
        fVal.setValue(defVal);
        assertEquals(DefaultValueConst.INT_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_06() {
        IntegerFieldValue fVal = new IntegerFieldValue();
        fVal.setValue(val);
        assertEquals(val, fVal.getValue());
    }

    @Test
    public void t_setValue_07() {
        IntegerFieldValue fVal = new IntegerFieldValue();
        fVal.setValue(nullVal);
        assertEquals(DefaultValueConst.INT_DEF_VAL, fVal.getValue());
    }


    @Test
    public void t_setValue_08() {
        IntegerFieldValue fVal = new IntegerFieldValue(val);
        fVal.setValue(nullVal);
        assertEquals(DefaultValueConst.INT_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_09() {
        IntegerFieldValue fVal = new IntegerFieldValue(val);
        fVal.setValue(defVal);
        assertEquals(DefaultValueConst.INT_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_10() {
        Integer tVal = 2;
        IntegerFieldValue fVal = new IntegerFieldValue(val);
        fVal.setValue(tVal);
        assertEquals(tVal, fVal.getValue());
    }



}