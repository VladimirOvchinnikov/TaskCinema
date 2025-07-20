package com.bnw.taskcinema.model.common;

import com.bnw.taskcinema.utils.DefaultValueConst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleanFieldValueTest {


    @Test
    public void t_construct_01() {
        BooleanFieldValue fVal = new BooleanFieldValue();
        assertFalse(fVal.getValue());
    }

    @Test
    public void t_construct_02() {
        BooleanFieldValue fVal = new BooleanFieldValue(true);
        assertTrue(fVal.getValue());
    }


    @Test
    public void t_construct_03() {
        BooleanFieldValue fVal = new BooleanFieldValue(false);
        assertFalse(fVal.getValue());
    }


    @Test
    public void t_construct_04() {
        BooleanFieldValue fVal = new BooleanFieldValue(null);
        assertFalse(fVal.getValue());
    }


    @Test
    public void t_setValue_05() {
        BooleanFieldValue fVal = new BooleanFieldValue();
        fVal.setValue(true);
        assertTrue(fVal.getValue());
    }

    @Test
    public void t_setValue_06() {
        BooleanFieldValue fVal = new BooleanFieldValue();
        fVal.setValue(false);
        assertFalse(fVal.getValue());
    }

    @Test
    public void t_setValue_07() {
        BooleanFieldValue fVal = new BooleanFieldValue();
        fVal.setValue(null);
        assertFalse(fVal.getValue());
    }


    @Test
    public void t_setValue_08() {
        BooleanFieldValue fVal = new BooleanFieldValue(true);
        fVal.setValue(null);
        assertEquals(DefaultValueConst.BOOL_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_09() {
        BooleanFieldValue fVal = new BooleanFieldValue(true);
        fVal.setValue(false);
        assertEquals(DefaultValueConst.BOOL_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_10() {
        Boolean tVal = true;
        BooleanFieldValue fVal = new BooleanFieldValue(true);
        fVal.setValue(tVal);
        assertEquals(tVal, fVal.getValue());
    }

}