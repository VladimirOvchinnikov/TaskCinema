package com.bnw.taskcinema.model.common;

import com.bnw.taskcinema.utils.DefaultValueConst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldValueTest {

//    основная проверка будет в конретных реализациях. Тут для галочки

    @Test
    public void t_construct_01() {
        FieldValue<Boolean> fVal = new FieldValue<>(Boolean.class);
        assertFalse(fVal.getValue());
    }

    @Test
    public void t_construct_02() {
        FieldValue<Boolean> fVal = new FieldValue<>(true, Boolean.class);
        assertTrue(fVal.getValue());
    }


    @Test
    public void t_construct_03() {
        FieldValue<Boolean> fVal = new FieldValue<>(false, Boolean.class);
        assertFalse(fVal.getValue());
    }


    @Test
    public void t_construct_04() {
        FieldValue<Boolean> fVal = new FieldValue<>(null, Boolean.class);
        assertFalse(fVal.getValue());
    }


    @Test
    public void t_setValue_05() {
        FieldValue<Boolean> fVal = new FieldValue<>(Boolean.class);
        fVal.setValue(true);
        assertTrue(fVal.getValue());
    }

    @Test
    public void t_setValue_06() {
        FieldValue<Boolean> fVal = new FieldValue<>(Boolean.class);
        fVal.setValue(false);
        assertFalse(fVal.getValue());
    }

    @Test
    public void t_setValue_07() {
        FieldValue<Boolean> fVal = new FieldValue<>(Boolean.class);
        fVal.setValue(null);
        assertFalse(fVal.getValue());
    }


    @Test
    public void t_setValue_08() {
        FieldValue<Boolean> fVal = new FieldValue<>(true, Boolean.class);
        fVal.setValue(null);
        assertEquals(DefaultValueConst.BOOL_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_09() {
        FieldValue<Boolean> fVal = new FieldValue<>(true, Boolean.class);
        fVal.setValue(false);
        assertEquals(DefaultValueConst.BOOL_DEF_VAL, fVal.getValue());
    }

    @Test
    public void t_setValue_10() {
        Boolean tVal = true;
        FieldValue<Boolean> fVal = new FieldValue<>(true, Boolean.class);
        fVal.setValue(tVal);
        assertEquals(tVal, fVal.getValue());
    }


}