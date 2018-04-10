package com.iflytek.cachemanager.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author: tishen
 * @date: 2018/3/3
 * @description: 异常处理工具
 */
public class ThrowableUtils {

    public static String printStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }

}
