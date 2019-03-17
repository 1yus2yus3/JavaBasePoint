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
public class JavaVMHeapOOM {

    public static void main(String[] args) {

        try {
            List<byte[]> buffer = new ArrayList<byte[]>();
            buffer.add(new byte[10*1024*1024]);
        }catch (Exception e){
            System.out.println("Exception : "+e);
        }catch (Throwable e){

            System.out.println("Throwable : "+e);
        }
        finally {
        }

    }


}
