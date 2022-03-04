package com.company.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTest {
    public static void main(String[] args) {
//        String dateStr = "Mon Aug 16 14:59:43 CST 2021";
        String dateStr = "Fri Feb 19 17:32:34 CST 2021";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = new Date();
        try{
            date = sdf.parse(dateStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(new SimpleDateFormat("YYYY/MM/DD HH:mm:ss",Locale.CHINA).format(date));
    }
}
