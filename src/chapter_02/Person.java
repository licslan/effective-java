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
public class Person {
    private final Date birthDate = null;

    // the starting and ending dates of the baby boom
    private static final Date BOOM_START = null;
    private static final Date BOOM_END = null;

    static {
        // Unneccessary allocation of expensive objec
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();

    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }
}