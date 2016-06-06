package list;

import java.util.Stack;

/**
 * Created by xin on 2016/5/13.
 */
public class ListTest {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        printLinkedList2(head);
    }

    //从尾到头打印链表--栈
    public static void printLinkedList(LinkedListNode head){
        LinkedListNode temp = head;
        Stack<LinkedListNode> stack = new Stack<LinkedListNode>();
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        while (stack.size()>0){
            System.out.print(stack.pop().value + " ");
        }
    }
    //从尾到头打印链表--递归
    public static void printLinkedList2(LinkedListNode head){
        if(head!=null){
            printLinkedList2(head.next);
            System.out.print(head.value+" ");
        }
    }
}
