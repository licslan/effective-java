package chapter_02;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 * 【第2章---创建对象和销毁对象】
 * 6.消除过期引用
 *
 * P21 -------->  《effective java》
 * */
public class EliminateExpiredReferences {

    /**
     * 例子 ： 内存泄漏
     *
     *
     * */

    public class Stack{

        private Object[] elements;
        private int size=0;
        private static final int DEFAULT_INITTAL_CAPACITY =16;

        public Stack(){
            elements= new Object[DEFAULT_INITTAL_CAPACITY];
        }

        public void push(Object o){
            ensureCapacity();
            elements[size++] = o;
        }

        public Object pop(){
            if(size==0)
                throw  new EmptyStackException();
            return elements[--size];
        }

        /**
         * Ensure space for at least one more elment, roughly
         * doubling the capactty each time the array needs to grow
         *
         * */

        private void ensureCapacity(){
            if(elements.length==size)
                elements= Arrays.copyOf(elements,2*size+1);
        }
    }

    /**
     * 这段程序中隐藏一个问题  内存泄漏  memory leak
     *
     *
     *
     * 如果是一个栈先是增长，然后再收缩，那么，从栈中弹出来的对象将不会被
     * 当作垃圾回收，即使使用栈的程序不再引用这些对象，他们也不会被回收
     * 过期引用  obsolete reference
     *
     * 修复办法如下：
     *
     * */


   /* public Object pop(){
        if(size == 0)
        throw  new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return  result;
    }
*/

   /**
    * 清空过期的引用的另一个好处是，如果他们以后又被错误的解除引用，
    * 程序就会立即抛出NullPointerException异常，而不是悄悄的错误的运行下去，尽快监测
    * 出程序中的错误总是有益的
    * */





}



