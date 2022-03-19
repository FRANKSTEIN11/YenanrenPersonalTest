package com.heaboy.Test;

/**
 * @author yenanren
 * @date 2022/3/16 0016
 * @Description
 */
class ThreadMark_to_win extends Thread {
    Thread mainT;
    ThreadShareTest t;

    public void run() {
        try {
            mainT.join();
        } catch (Exception e) {
            System.out.println("我是子程序， 也被打断");
        }
        System.out.println("完成" + "e 在子线程" + t.e);
    }

    public void setMainThread(Thread t1, ThreadShareTest tTest) {
        mainT = t1;
        t = tTest;
    }

}

public class ThreadShareTest {
    int e;

    public static void main(String[] args) {
        ThreadShareTest t = new ThreadShareTest();
        Thread mainT = Thread.currentThread();
        ThreadMark_to_win tm = new ThreadMark_to_win();

        tm.setMainThread(mainT, t);
        tm.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            if (i == 4) tm.interrupt();
            t.e = t.e + i;
        }


        System.out.println("主线程e = " + t.e);

    }

}

