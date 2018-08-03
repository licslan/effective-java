package chapter_02;

/**
 *
 * 【第2章---创建对象和销毁对象】
 * 3.用私用构造器或者枚举类型强化singleton属性
 * */

public class Singleton {

    /**
     * java 1.5 发行之前实现singleton有两种方式 2种方式都要把构造器保持为私有，
     *
     * 并导出公有的静态成员，以便允许客户端能够访问该类的唯一实例
     *
     * */


    //singleton with public final field   method A

   /* public static final Singleton singleton = new Singleton();
    private Singleton(){}
    public void leaveTheBuilding(){}*/


    /**
     *
     * 上述方案中  私有构造器仅被调用一次，用来实例化公有的静态final域
     * */




    //singleton with static factory   method B
    public static final Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getSingleton(){
        return singleton;
    }
    public void leaveTheBuilding(){}


    /**
     * 对于静态方法 Singleton.getSingleton的所有调用，都会返回
     * 同一个对象引用，所以永远不会创建其他的实例
     * 公有域方法的主要好处在于组成的成员的申明很清楚的申明了这是一个singleton
     * 公有的静态域是final的，所以该域将总是包含相同的对象引用，公有域方法在性能上不再有
     * 任何优势，现代JVM实现几乎都能够将静态工厂方法的调用内联化
     * 工厂方法的优势之一在于它提供了灵活性在不改变API前提下，我们可以
     * 改变该类是否应该为singtelon的想法
     *
     *
     * 1.5 jdk ++  枚举实现singleton
     * */

    /*public enum Singleton {

        INSTANCE;

        public  void leaveTheBuilding(){}

    }*/






}
