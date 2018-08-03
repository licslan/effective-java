package chapter_02;

/**
 *
 * 【第2章---创建对象和销毁对象】
 * 7.避免使用终结方法
 *
 * P24 -------->  《effective java》
 * */

public class AvoidUsingFinallyMethod {

    public static void main(String[] args) {
        AvoidUsingFinallyMethod afm = new AvoidUsingFinallyMethod();
       /* try {
            //Do what must be done with afm
        }finally {
            afm.terminate();//Explicit termination method
        }*/
    }

}
