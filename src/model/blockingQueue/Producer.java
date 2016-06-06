package model.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by xin on 2016/3/14.
 */
public class Producer implements Runnable {
    private BlockingQueue<String> bq;

    public Producer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        String[] strArr = new String[]{"Java","Struts2","Spring"};
        for (int i = 0; i < 99999999; i++) {
            System.out.println(Thread.currentThread().getName() + "--生产者准备生产集合元素！");
            try {
                Thread.sleep(200);
                bq.put(strArr[i%3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-----------------------生产完成"+bq);
        }
    }
}
