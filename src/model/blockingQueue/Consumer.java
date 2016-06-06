package model.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by xin on 2016/3/14.
 */
public class Consumer implements Runnable {
    private BlockingQueue<String> bq;

    public Consumer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + "--消费者准备消费集合元素！");
            try {
                Thread.sleep(200);
                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-------------------------------消费完成"+bq);
        }
    }
}
