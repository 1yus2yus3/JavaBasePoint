package com.cola.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/03/11 14:52
 * @description:
 */
public class JavaVMStackSOF {

    private int stackLenght = 0; //调用测试

    //自己定义的方法
    public void function(){
        stackLenght ++ ;
        //递归调用
        function();


    }

    public static void main(String[] args) {

        JavaVMStackSOF stackSOF = new JavaVMStackSOF();

        try {
            stackSOF.function();
        }catch (Exception e){
            System.out.println("Exception : "+e);
        }catch (Throwable e){
            //栈异常不属于Exception  Exception异常是继承Throwable底层的异常
            System.out.println("Throwable : "+e);
        }
        finally {
            //栈的容量 JVM参数 ：-Xss1024k 默认
            System.out.println("调用次数 : " + stackSOF.stackLenght );
        }

    }


}
