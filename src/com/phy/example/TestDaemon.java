package com.phy.example;


import java.util.Scanner;

/**
 * @author ：pihuiyou
 * @date ：Created in 2019/3/26 11:00
 * @description：main函数也是主线程，th是子线程
 */

class MT implements Runnable{
    public boolean flog = false;
    public  void run() {
        int i = 0 ;
        while(true){
            System.out.println("Hello World"+i);
            i++;
            if(flog){
                synchronized(this){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class TestDaemon {
    public static void main(String[] args){
        MT mt = new MT();
        Thread t = new Thread(mt);
        t.start();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("输入0暂停");
            int n = sc.nextInt();
            if(n==0) mt.flog = true;
            System.out.println("输入1继续");
            n = sc.nextInt();
            if(n==1){
                synchronized (mt) {
                    mt.flog = false;
                    mt.notify();
                }
            }
        }
    }

}


