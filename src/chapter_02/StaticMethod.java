package chapter_02;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【第2章---创建对象和销毁对象】
 * 1.考虑使用静态工厂方法代替构造器
 *
 *
 * */


public class StaticMethod {

    public static Boolean valueOf(boolean b){
        return b ? Boolean.TRUE : Boolean.FALSE;
    }


    Map<String,List<String>> m = new HashMap<>();

    //静态工厂
    public static <k,v> HashMap<k,v> newInstance(){
        return new HashMap<k,v>();
    }

    Map<String,List<String>> k = newInstance();
    Map<String,List<String>> s = StaticMethod.newInstance();

}
