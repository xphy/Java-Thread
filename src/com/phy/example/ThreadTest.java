package com.phy.example;

/**
 * @author ：pihuiyou
 * @date ：Created in 2019/3/26 10:51
 * @description：
 */
public class ThreadTest extends Thread {
    public void run() {
        while (true) {
            System.out.println("0");
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
