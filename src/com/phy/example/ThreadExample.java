package com.phy.example;

/**
 * @author ：xp
 * @date ：Created in 2018/10/26 16:12
 * @description：实现两个线程之间的通信
 */
public class ThreadExample {
    public static void main(String[] args) {
        Object obj = new Object();
        Number s = new Number(obj);
        Char z = new Char(obj);
        Thread th1 = new Thread(s);
        Thread th2 = new Thread(z);
        th1.start();//数字的线程先运行，数字先执行
        th2.start();
    }

}

//数字类实现runnable接口
class Number implements Runnable {
    private Object obj;

    public Number() {
    }

    public Number(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {//给共享资源上锁
            for (int i = 1; i < 53; i++) {
                System.out.println(i);
                if (i % 2 == 0) {//保证输出两个数字
                    obj.notifyAll();//唤醒其他线程
                    try {
                        obj.wait();//等待并释放锁
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

//字母类
class Char implements Runnable {

    private Object obj;

    public Char() {
    }

    public Char(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 26; i++) {
                System.out.println((char) (i + 'A'));
                obj.notifyAll();//唤醒其他线程
                try {
                    obj.wait();//释放锁等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
