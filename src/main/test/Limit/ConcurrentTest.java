package Limit;

import org.testng.annotations.Test;

/**
 * Created by zengyouzu on 2019/8/6.
 */
public class ConcurrentTest {
    //限额同步--累加--撤销--查询校验--查询累加结果
    public static class LimitThread extends Thread {
        public void run() {
            //限额同步
            CombineTest.synchronizingLimitInfo();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //限额校验查询
            CombineTest.checkLimit();
            //限额累加
            CombineTest.addLimit();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //限额累加撤销
            CombineTest.cancelAddLimit();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //限额累加查询
            CombineTest.checkAddDetail();
        }
    }

    //部分撤销
    public static class LimitThread1 extends Thread {
        public void run() {
            //限额同步
            CombineTest.synchronizingLimitInfo();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //限额累加
            CombineTest.addLimit();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 1000; i++) {
                //限额部分撤销
                CombineTest.partialCancelAddLimit();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //循环累加
    public static class LimitThread2 extends Thread {
        public void run() {
            //限额同步
            CombineTest.synchronizingLimitInfo();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <=1; i++) {
                //限额累加
                CombineTest.addLimit();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //70%正+30%反
    public static class LimitThread3 extends Thread {
        public void run() {
            //限额同步
            CombineTest.synchronizingLimitInfo();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 300; i++) {
                //限额累加
                CombineTest.addLimit();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //限额累加撤销
                CombineTest.cancelAddLimit();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= 700; i++) {
                //限额累加
                CombineTest.addLimit();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //累加-累加查询
    public static class LimitThread4 extends Thread {
        public void run() {
            //限额同步
            CombineTest.synchronizingLimitInfo();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //限额查询
            CombineTest.checkLimit();
            for (int i = 1; i <= 1; i++) {
                //限额累加
                CombineTest.addLimit();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //限额累加查询
                CombineTest.checkAddDetail();
            }
        }
    }

    /*public static class LimitThread5 extends Thread {
        public void run() {
            LimitConfigServiceTest.synchronizingLimitInfo();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LimitAddServiceTest.addLimit();
        }
    }*/

    //并发测试
    public static class ThreadSafe implements Runnable {
        int num = 99;

        public void run() {
            if (num > 0) {
                //限额累加
                CombineTest.addLimit();
                System.out.println("Thread" + num--);
            }
        }
    }

    //批量测试
    @Test
    public void TestA() {
        for (int i = 1; i <= 1; i++) {
            try {
//                new LimitThread().run();
//                new LimitThread1().run();
                new LimitThread2().run();
//                new LimitThread3().run();
//                new LimitThread4().run();
//                new LimitThread5().run();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //多线程并发
    public static void main(String[] args) {
        //限额同步
        CombineTest.synchronizingLimitInfo();
        ThreadSafe threadSafe = new ThreadSafe();
        Thread threadSafe1 = new Thread(threadSafe);
        Thread threadSafe2 = new Thread(threadSafe);
        Thread threadSafe3 = new Thread(threadSafe);
        Thread threadSafe4 = new Thread(threadSafe);
        Thread threadSafe5 = new Thread(threadSafe);
        Thread threadSafe6 = new Thread(threadSafe);
        Thread threadSafe7 = new Thread(threadSafe);
        Thread threadSafe8 = new Thread(threadSafe);
        Thread threadSafe9 = new Thread(threadSafe);
        Thread threadSafe10 = new Thread(threadSafe);
        Thread threadSafe11 = new Thread(threadSafe);
        Thread threadSafe12 = new Thread(threadSafe);
        Thread threadSafe13 = new Thread(threadSafe);
        Thread threadSafe14 = new Thread(threadSafe);
        Thread threadSafe15 = new Thread(threadSafe);
        Thread threadSafe16 = new Thread(threadSafe);
        Thread threadSafe17 = new Thread(threadSafe);
        Thread threadSafe18 = new Thread(threadSafe);
        Thread threadSafe19 = new Thread(threadSafe);
        Thread threadSafe20 = new Thread(threadSafe);
        Thread threadSafe21 = new Thread(threadSafe);
        Thread threadSafe22 = new Thread(threadSafe);
        Thread threadSafe23 = new Thread(threadSafe);
        Thread threadSafe24 = new Thread(threadSafe);
        Thread threadSafe25 = new Thread(threadSafe);
        Thread threadSafe26 = new Thread(threadSafe);
        Thread threadSafe27 = new Thread(threadSafe);
        Thread threadSafe28 = new Thread(threadSafe);
        Thread threadSafe29 = new Thread(threadSafe);
        Thread threadSafe30 = new Thread(threadSafe);
        Thread threadSafe31 = new Thread(threadSafe);
        Thread threadSafe32 = new Thread(threadSafe);
        Thread threadSafe33 = new Thread(threadSafe);
        Thread threadSafe34 = new Thread(threadSafe);
        Thread threadSafe35 = new Thread(threadSafe);
        Thread threadSafe36 = new Thread(threadSafe);
        Thread threadSafe37 = new Thread(threadSafe);
        Thread threadSafe38 = new Thread(threadSafe);
        Thread threadSafe39 = new Thread(threadSafe);
        Thread threadSafe40 = new Thread(threadSafe);
        Thread threadSafe41 = new Thread(threadSafe);
        Thread threadSafe42 = new Thread(threadSafe);
        Thread threadSafe43 = new Thread(threadSafe);
        Thread threadSafe44 = new Thread(threadSafe);
        Thread threadSafe45 = new Thread(threadSafe);
        Thread threadSafe46 = new Thread(threadSafe);
        Thread threadSafe47 = new Thread(threadSafe);
        Thread threadSafe48 = new Thread(threadSafe);
        Thread threadSafe49 = new Thread(threadSafe);
        Thread threadSafe50 = new Thread(threadSafe);
        Thread threadSafe51 = new Thread(threadSafe);
        Thread threadSafe52 = new Thread(threadSafe);
        Thread threadSafe53 = new Thread(threadSafe);
        Thread threadSafe54 = new Thread(threadSafe);
        Thread threadSafe55 = new Thread(threadSafe);
        Thread threadSafe56 = new Thread(threadSafe);
        Thread threadSafe57 = new Thread(threadSafe);
        Thread threadSafe58 = new Thread(threadSafe);
        Thread threadSafe59 = new Thread(threadSafe);
        Thread threadSafe60 = new Thread(threadSafe);
        Thread threadSafe61 = new Thread(threadSafe);
        Thread threadSafe62 = new Thread(threadSafe);
        Thread threadSafe63 = new Thread(threadSafe);
        Thread threadSafe64 = new Thread(threadSafe);
        Thread threadSafe65 = new Thread(threadSafe);
        Thread threadSafe66 = new Thread(threadSafe);
        Thread threadSafe67 = new Thread(threadSafe);
        Thread threadSafe68 = new Thread(threadSafe);
        Thread threadSafe69 = new Thread(threadSafe);
        Thread threadSafe70 = new Thread(threadSafe);
        Thread threadSafe71 = new Thread(threadSafe);
        Thread threadSafe72 = new Thread(threadSafe);
        Thread threadSafe73 = new Thread(threadSafe);
        Thread threadSafe74 = new Thread(threadSafe);
        Thread threadSafe75 = new Thread(threadSafe);
        Thread threadSafe76 = new Thread(threadSafe);
        Thread threadSafe77 = new Thread(threadSafe);
        Thread threadSafe78 = new Thread(threadSafe);
        Thread threadSafe79 = new Thread(threadSafe);
        Thread threadSafe80 = new Thread(threadSafe);
        Thread threadSafe81 = new Thread(threadSafe);
        Thread threadSafe82 = new Thread(threadSafe);
        Thread threadSafe83 = new Thread(threadSafe);
        Thread threadSafe84 = new Thread(threadSafe);
        Thread threadSafe85 = new Thread(threadSafe);
        Thread threadSafe86 = new Thread(threadSafe);
        Thread threadSafe87 = new Thread(threadSafe);
        Thread threadSafe88 = new Thread(threadSafe);
        Thread threadSafe89 = new Thread(threadSafe);
        Thread threadSafe90 = new Thread(threadSafe);
        Thread threadSafe91 = new Thread(threadSafe);
        Thread threadSafe92 = new Thread(threadSafe);
        Thread threadSafe93 = new Thread(threadSafe);
        Thread threadSafe94 = new Thread(threadSafe);
        Thread threadSafe95 = new Thread(threadSafe);
        Thread threadSafe96 = new Thread(threadSafe);
        Thread threadSafe97 = new Thread(threadSafe);
        Thread threadSafe98 = new Thread(threadSafe);
        Thread threadSafe99 = new Thread(threadSafe);
        threadSafe1.start();
        threadSafe2.start();
        threadSafe3.start();
        threadSafe4.start();
        threadSafe5.start();
        threadSafe6.start();
        threadSafe7.start();
        threadSafe8.start();
        threadSafe9.start();
        threadSafe10.start();
        threadSafe11.start();
        threadSafe12.start();
        threadSafe13.start();
        threadSafe14.start();
        threadSafe15.start();
        threadSafe16.start();
        threadSafe17.start();
        threadSafe18.start();
        threadSafe19.start();
        threadSafe20.start();
        threadSafe21.start();
        threadSafe22.start();
        threadSafe23.start();
        threadSafe24.start();
        threadSafe25.start();
        threadSafe26.start();
        threadSafe27.start();
        threadSafe28.start();
        threadSafe29.start();
        threadSafe30.start();
        threadSafe31.start();
        threadSafe32.start();
        threadSafe33.start();
        threadSafe34.start();
        threadSafe35.start();
        threadSafe36.start();
        threadSafe37.start();
        threadSafe38.start();
        threadSafe39.start();
        threadSafe40.start();
        threadSafe41.start();
        threadSafe42.start();
        threadSafe43.start();
        threadSafe44.start();
        threadSafe45.start();
        threadSafe46.start();
        threadSafe47.start();
        threadSafe48.start();
        threadSafe49.start();
        threadSafe50.start();
        threadSafe51.start();
        threadSafe52.start();
        threadSafe53.start();
        threadSafe54.start();
        threadSafe55.start();
        threadSafe56.start();
        threadSafe57.start();
        threadSafe58.start();
        threadSafe59.start();
        threadSafe60.start();
        threadSafe61.start();
        threadSafe62.start();
        threadSafe63.start();
        threadSafe64.start();
        threadSafe65.start();
        threadSafe66.start();
        threadSafe67.start();
        threadSafe68.start();
        threadSafe69.start();
        threadSafe70.start();
        threadSafe71.start();
        threadSafe72.start();
        threadSafe73.start();
        threadSafe74.start();
        threadSafe75.start();
        threadSafe76.start();
        threadSafe77.start();
        threadSafe78.start();
        threadSafe79.start();
        threadSafe80.start();
        threadSafe81.start();
        threadSafe82.start();
        threadSafe83.start();
        threadSafe84.start();
        threadSafe85.start();
        threadSafe86.start();
        threadSafe87.start();
        threadSafe88.start();
        threadSafe89.start();
        threadSafe90.start();
        threadSafe91.start();
        threadSafe92.start();
        threadSafe93.start();
        threadSafe94.start();
        threadSafe95.start();
        threadSafe96.start();
        threadSafe97.start();
        threadSafe98.start();
        threadSafe99.start();
    }
}
