package com.company.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParse {
    public static void main(String[] args) {
        Long time = 160335311L;
        Date date = new Date();
        date.setTime(time);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }
}
