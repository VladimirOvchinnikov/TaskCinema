package com.bnw.taskcinema.utils;

import java.util.Objects;

public class StringUtils {

    public static boolean isEmpty(String str){
        return Objects.isNull(str) || str.isEmpty();
    }


}
