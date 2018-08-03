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

    /**
     * 改进后person类只在初始化的时候创建Calendear TimceZone Date
     * 而不是每次调用isBabyBoomer的时候都创建这邪恶实例
     * */


    /**
     * java1.5中有一种创建多余对象的新方法，称为自动装箱（autoboxing）
     * 允许程序员将基本类型和装箱基本类型混用
     * 按需自动装箱和拆箱
     * */

    public static void main(String[] args) {
        Long sun = 0L;
        for(long i =0;i<Integer.MAX_VALUE;i++){
            sun +=i;
        }
        System.out.println(sun);
    }

    /**
     * 这段程序运行结果是对的，但是实际情况要更慢一些
     * 因为sum申明的是Long 不是long  意味着程序构造了2^31
     * 个多余的Long实例  如果是long 就不会拆箱操作 优先使用基本
     * 类型而不是装箱基本类型
     *
     * */

    /**
     * 通过维护自己的对象池来避免创建对象并不是一种好的做法，除非
     * 池中的对象是非常重量级的，真正正确使用对象池的典型对象例子就是
     * 数据库连接池，建立数据库连接的代价是非常昂贵的，因此重用这些对象
     * 非常有意义
     * */
}