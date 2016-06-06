import stack_queue.QueueToStackTest;

import java.util.LinkedList;

/**
 * Created by xin on 2016/5/16.
 */
public class Demo {
    public static void main(String[] args) {
        QueueToStackTest<Integer> qtst = new QueueToStackTest<Integer>(new LinkedList<Integer>(), new LinkedList<Integer>());
        qtst.appendTop(1);
        qtst.appendTop(2);
        qtst.appendTop(3);
        qtst.appendTop(4);
        qtst.appendTop(5);

        System.out.println(qtst.deleteTop());
        System.out.println(qtst.deleteTop());
        System.out.println(qtst.deleteTop());
        qtst.appendTop(6);
        System.out.println(qtst.deleteTop());
        System.out.println(qtst.deleteTop());
        System.out.println(qtst.deleteTop());
        System.out.println(qtst.deleteTop());
    }
}
