package chapter_02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * 【第2章---创建对象和销毁对象】
 * 5.避免创建不必要的对象
 *
 * P17 -------->  《effective java》
 * */
public class AvoidUnnecessaryObject {

    //反面列子
    //String s = new String("str");
    //优化
    //String s = "str";


    public class Person{

        private final Date birthDate=null;

        // other fields , method , and constructor omitted
        // DON`T DO THIS!!
        public boolean isBabyBoomer(){
            // Unneccessary allocation of expensive objec
            Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
            Date boomStart = gmtCal.getTime();
            gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
            Date boomEnd = gmtCal.getTime();
            return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;

        }


    }

    /**
     * 上述案例中  isBabyBoomer每次被调用的时候，都会新建一个Calendar
     * 一个Date 和 TimeZone实例，这是不必要的  下面是一个静态的初始化器
     * 避免了这种效率低下的情况   详见 类 Person
     * */












}
