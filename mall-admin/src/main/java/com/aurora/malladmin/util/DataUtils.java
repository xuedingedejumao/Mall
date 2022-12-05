package com.aurora.malladmin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
    public static String getSysTimeByFormat(String format){
        SimpleDateFormat df = new SimpleDateFormat(format);//设置日期格式
        return df.format(new Date());
    }
}
