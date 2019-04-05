package com.phy.example;

import com.phy.thread.RunableTest;

/**
 * @author ：pihuiyou
 * @date ：Created in 2019/3/26 10:53
 * @description：
 */
public class Test {
    public static void main(String args[]) {
        ThreadTest threadTest = new ThreadTest();

        //threadTest.start();

        RunableTest runableTest = new RunableTest();
        Thread thread = new Thread(runableTest);
        thread.start();

    }
}
