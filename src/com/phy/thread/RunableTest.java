package com.phy.thread;

/**
 * @author ：pihuiyou
 * @date ：Created in 2019/3/26 10:56
 * @description：实现runnable接口
 */
public class RunableTest implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println('1');
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
