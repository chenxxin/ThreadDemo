package stack_queue;

import java.util.Stack;

/**
 * Created by xin on 2016/5/16.
 */

//用两个栈实现队列
public class StackToQueueTest<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public StackToQueueTest(Stack<T> stack1, Stack<T> stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    public void appendTail(T node){
        stack1.push(node);
    }
    public T deleteHead(){
        if (stack2.empty()){
            while (stack1.size()>0){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()){
            System.out.println("Quene is empty!");
            System.exit(0);
        }
        return stack2.pop();
    }
}

