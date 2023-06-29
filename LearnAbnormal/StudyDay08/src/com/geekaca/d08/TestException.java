package com.geekaca.d08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestException {
    /**
     * 异常
     */
    public static void main(String[] args) {
        int[] arr = {3,2,4,5};
        //ArrayIndexOutOfBoundsException 数组越界异常
        //System.out.println(arr[9]);

        List<String> list= new ArrayList<>();
        //IndexOutOfBoundsException 索引越界
        //list.get(0);

        String str = "9.9gg";
        //.NumberFormatException 无法转化 导致数字格式化异常
        //Double.parseDouble(str);

        String strDate = "2023-09-09日 12:00:00";
        //java.time.format.DateTimeParseException  日期解析异常
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //LocalDateTime localDateTime = LocalDateTime.parse(strDate, dtf);
        //System.out.println(localDateTime);

        String mystr = null;
        //.NullPointerException 空指针异常
        //System.out.println(mystr.length());

        //Animal a1 = new Cat();
        //Animal a2 = new Tiger();
        //ClassCastException 类型转换异常
        //Tiger a = (Tiger) a1;

        //编译时异常 有可能出现异常,必须捕获，否则代码无法通过编译
        String date = "2023年01-12 10:23:21";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date d=sdf2.parse(date);
        //System.out.println(d);
        Date d= null;
        try {
            d = sdf2.parse(date);
            System.out.println(d);
        } catch (ParseException e) {
            //打印异常堆栈java.text.ParseException
            //当发生异常的时候，自动创建对象，把异常信息放进去 ex
            e.printStackTrace();
        }

    }
}
