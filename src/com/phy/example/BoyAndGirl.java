package com.phy.example;

import com.phy.entity.User;

/**
 * @author ：pihuiyou
 * @date ：Created in 2019/3/26 14:52
 * @description：设计一个线程类，输出顺序为男，女，男，女 第二次输出小红女在提问
 */


//定义一个线程类
class RunnableExample implements Runnable {
    private User user;
    boolean flag;
    User userB = new User("小明", "男", 1);
    User userG = new User("小红", "女", 1);

    public RunnableExample(User user, boolean flag) {
        this.user = user;
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (user) {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (flag) {
                    System.out.println(userB.getName() + userB.getSex() + "正在问问题");
                } else {
                    System.out.println(userG.getName() + userG.getSex() + "正在问问题");
                }
                user.notifyAll();
                try {
                    user.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//测试函数
public class BoyAndGirl {
    public static void main(String args[]) {
        User c = new User();
        Thread threadB = new Thread(new RunnableExample(c, true));
        Thread threadG = new Thread(new RunnableExample(c, false));
        threadB.start();
        threadG.start();
    }
}

