package org.lyz.test_project.test;

import java.lang.reflect.InvocationTargetException;

// 普通懒汉
class SingleTonLH{
    private SingleTonLH(){}
    private static SingleTonLH INSTANCE = null;
    public static SingleTonLH getInstance(){
        // 多线程不安全
        if(INSTANCE == null){
            INSTANCE = new SingleTonLH();
        }
        return INSTANCE;
    }
}

// DCR双重锁
class SingleTonDCR {
    private SingleTonDCR(){}
    private static SingleTonDCR INSTANCE = null;

    public int a = 111;

    public static SingleTonDCR getInstance(){
        if(INSTANCE == null){
            synchronized (SingleTonDCR.class){
                if(INSTANCE == null){
                    INSTANCE = new SingleTonDCR();
                }
                return INSTANCE;
            }
        }
        return INSTANCE;
    }
}

// 饿汉模式
class SingleTonEH{
    private SingleTonEH(){}
    private static final SingleTonEH INSTANCE = new SingleTonEH();
    public static SingleTonEH getInstance(){
        return INSTANCE;
    }
}

// 静态内部类
class SingleTonJT{
    private SingleTonJT(){}
    private static class SingleTonInner{
        private static SingleTonJT INSTANCE = new SingleTonJT();
    }
    public static SingleTonJT getInstance(){
        return SingleTonInner.INSTANCE;
    }
}

// 枚举单例
enum SingleTonMJ {
    INSTANCE;

    public static SingleTonMJ getIntance() {
        return INSTANCE;
    }
}

public class SingleTonTest implements Runnable{

    @Override
    public void run() {
        // 测试 普通懒汉
//        SingleTonLH instance = SingleTonLH.getInstance();
        // 测试 双重锁懒汉
//        SingleTonDCR instance = SingleTonDCR.getInstance();
        // 测试 饿汉
//        SingleTonEH instance = SingleTonEH.getInstance();
        // 测试 静态内部类
//        SingleTonJT instance = SingleTonJT.getInstance();
        // 测试 枚举
        SingleTonMJ instance = SingleTonMJ.getIntance();
        System.out.println("当前线程为：" + Thread.currentThread() + "---对象地址为：" + instance);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 单例测试
//        SingleTonTest test = new SingleTonTest();
//        Thread t1 = new Thread(test, "线程111");
//        Thread t2 = new Thread(test, "线程222");
//        Thread t3 = new Thread(test, "线程333");
//        long time1 = System.nanoTime();
//        t1.start();
//        t2.start();
//        t3.start();
//        long time2 = System.nanoTime();
//        System.out.println("用时：" + (time2 - time1));
    }
}
