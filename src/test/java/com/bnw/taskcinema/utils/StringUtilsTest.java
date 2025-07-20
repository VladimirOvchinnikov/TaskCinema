package com.bnw.taskcinema.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    public void t_isEmpty_1(){
        assertTrue(StringUtils.isEmpty(null));
    }
    @Test
    public void t_isEmpty_2(){
        assertTrue(StringUtils.isEmpty(""));
    }
    @Test
    public void t_isEmpty_3(){
        assertFalse(StringUtils.isEmpty("1"));
    }
    @Test
    public void t_isEmpty_4(){
        assertFalse(StringUtils.isEmpty(" "));
    }

}