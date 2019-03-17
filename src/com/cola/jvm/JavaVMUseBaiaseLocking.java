package com.cola.jvm;

import java.util.concurrent.CyclicBarrier;

/**
 * Copyright (C), 杭州未智科技有限公司
 *
 * @author: Cola
 * @date: 2019/03/11 14:52
 * @description:
 */
public class JavaVMUseBaiaseLocking {

    private int stackLenght = 0; //调用测试

    //自己定义的方法
    public synchronized void function(){
        stackLenght ++ ;
    }

    public static void main(String[] args) throws Exception{

        JavaVMUseBaiaseLocking stackSOF = new JavaVMUseBaiaseLocking();
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000000; i++) {
            stackSOF.function();
        }

        Long endTime = System.currentTimeMillis();

        //单线程耗时 -XX:-UseBiasedLocking 停用 ：3745
        //单线程耗时 -XX:+UseBiasedLocking 开启 ：3871
        System.out.println("单线程耗时 -XX:+UseBiasedLocking ："+(endTime-startTime));



        /*JavaVMUseBaiaseLocking stackSOF = new JavaVMUseBaiaseLocking();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        Long startTime = System.currentTimeMillis();

        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20000000; i++) {
                    stackSOF.function();
                }

                try {
                    cyclicBarrier.await();
                }catch (Exception e){

                }

              //  Long endTime = System.currentTimeMillis();

              //  System.out.println("多线程线程耗时："+(endTime-startTime));
            }
        };
        thread.start();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20000000; i++) {
                    stackSOF.function();
                }
                try {
                    cyclicBarrier.await();
                }catch (Exception e){

                }

               // Long endTime = System.currentTimeMillis();

               // System.out.println("多线程线程耗时："+(endTime-startTime));
            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20000000; i++) {
                    stackSOF.function();
                }
                try {
                    cyclicBarrier.await();
                }catch (Exception e){

                }

                Long endTime = System.currentTimeMillis();

                //3个线程测试
                //多线程线程耗时 开启  -XX:+UseBiasedLocking：2204
                //多线程线程耗时 停用  -XX:-UseBiasedLocking：2045
                System.out.println("多线程线程耗时 停用  -XX:-UseBiasedLocking："+(endTime-startTime));
            }
        };
        thread2.start();
*/

    }


}
