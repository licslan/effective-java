package chapter_02;
/**
 *
 * 【第2章---创建对象和销毁对象】
 * 4.通过私有构造器强化不可实例化的能力
 *
 * P16 -------->  《effective java》
 * */
public class UtilityClass {

    private UtilityClass(){
        throw new AssertionError();
    }
    // remainder omitted
}
