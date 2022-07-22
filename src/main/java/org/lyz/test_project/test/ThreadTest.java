package org.lyz.test_project.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class ThreadCreate extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "Thread");
    }
}

class RunnableCreate implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "Runnable");
    }
}

class CallableCreate implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread() + "Callable");
        while(true){
            break;
        }
        return "Done!";
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        new ThreadCreate().start(); // by extends Thread
        new Thread(new RunnableCreate()).start(); // by immplements Runnable
        FutureTask<String> ft = new FutureTask<String>(new CallableCreate()); // by Callable&Future
        try {
            new Thread(ft).start();
            Thread.sleep(1000);
//        System.out.println(ft.cancel(true));
            System.out.println(ft.isCancelled());
            System.out.println(ft.isDone());
            System.out.println(ft.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

