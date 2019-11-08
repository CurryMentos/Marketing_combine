package Encourge.recommend;

/**
 * Created by zengyouzu on 2019/10/21.
 */
public class ThreadSafeTest extends Thread {
    int i = 10;

    public void run() {
        while (true) {
            synchronized ("") {
                if (i > 0) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("numbers" + i--);
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest t = new ThreadSafeTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
