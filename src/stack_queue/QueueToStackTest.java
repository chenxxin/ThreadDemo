package stack_queue;

import java.util.Queue;

/**
 * Created by xin on 2016/5/16.
 */
//用两个队列实现栈
public class QueueToStackTest<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public QueueToStackTest(Queue<T> queue1, Queue<T> queue2) {
        this.queue1 = queue1;
        this.queue2 = queue2;
    }

    public void appendTop(T node){
        queue1.offer(node);
    }
    public T deleteTop(){
        if (queue1.isEmpty() && queue2.isEmpty()){
            System.out.println("Stack is empty!");
            System.exit(0);
        }
        while (queue1.size()>1){
            queue2.offer(queue1.poll());
        }
        T node = queue1.poll();
        while (queue2.size()>0){
            queue1.offer(queue2.poll());
        }
        return node;
    }
}
